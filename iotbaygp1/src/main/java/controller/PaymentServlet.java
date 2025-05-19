package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import dao.CartDAO;
import dao.CartItemsDAO;
import dao.DBConnector;
import dao.OrderDAO;
import dao.PaymentDAO;
import dao.ProductDAO;
import model.Customer;
import model.Payment;
import model.Type;
import model.CartItem;
import model.Product;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the current session
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            request.getRequestDispatcher("Payment.jsp?action=edit").forward(request, response);
            return;
        }

        if ("confirm".equals(action)) {
            Payment confirmedPayment = (Payment) session.getAttribute("newPaymentSummary");
            if (confirmedPayment == null) {
                request.setAttribute("error", "No payment summary found in session.");
                request.getRequestDispatcher("Payment.jsp").forward(request, response);
                return;
            }

            // Verify cartItems before saving order
            List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
            if (cartItems == null || cartItems.isEmpty()) {
                request.setAttribute("error", "No cart items found in session.");
                request.getRequestDispatcher("Payment.jsp").forward(request, response);
                return;
            }

            // Calculate total amount from cartItems for consistency
            double totalAmount = 0.0;
            ProductDAO productDAO = (ProductDAO) session.getAttribute("productManager");
            if (productDAO == null) {
                request.setAttribute("error", "Product manager not found in session.");
                request.getRequestDispatcher("Payment.jsp").forward(request, response);
                return;
            }
            for (CartItem item : cartItems) {
                try {
                    Product product = productDAO.findProduct(item.getUPC());
                    if (product != null) {
                        totalAmount += product.getPrice() * item.getQuantity();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Failed to fetch product for UPC: " + item.getUPC());
                }
            }
            confirmedPayment.setAmount(totalAmount);

            // Save payment if requested
            Boolean save = (Boolean) session.getAttribute("saveThisPayment");
            if (Boolean.TRUE.equals(save)) {
                PaymentDAO paymentDAO = (PaymentDAO) session.getAttribute("paymentManager");
                if (paymentDAO == null) {
                    request.setAttribute("error", "Payment manager not found in session.");
                    request.getRequestDispatcher("Payment.jsp").forward(request, response);
                    return;
                }
                try {
                    paymentDAO.savePayment(confirmedPayment);
                    System.out.println("Payment saved successfully for customer ID: " + confirmedPayment.getCustomerID());
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Failed to save payment: " + e.getMessage());
                    request.getRequestDispatcher("Payment.jsp").forward(request, response);
                    return;
                }
            }

            // Create order using OrderDAO.createOrder
            String orderID = null;
            try {
                OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderManager");
                if (orderDAO == null) {
                    request.setAttribute("error", "Order manager not found in session.");
                    request.getRequestDispatcher("Payment.jsp").forward(request, response);
                    return;
                }
                Customer customer = (Customer) session.getAttribute("customer");
                if (customer == null) {
                    request.setAttribute("error", "Customer not found in session.");
                    request.getRequestDispatcher("Payment.jsp").forward(request, response);
                    return;
                }
                orderID = orderDAO.createOrder(customer.getID(), totalAmount);
                System.out.println("Order created successfully with orderID: " + orderID);

                // Save order items to OrderItems table directly
                String itemQuery = "INSERT INTO OrderItems (orderID, upc, quantity) VALUES (?, ?, ?)";
                Connection conn = (Connection) session.getAttribute("conn");
                if (conn == null) {
                    try {
                        DBConnector dbConnector = new DBConnector();
                        conn = dbConnector.openConnection();
                        session.setAttribute("conn", conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                        request.setAttribute("error", "Failed to open DB connection.");
                        request.getRequestDispatcher("Payment.jsp").forward(request, response);
                        return;
                    }
                }
                PreparedStatement itemStmt = conn.prepareStatement(itemQuery);
                for (CartItem item : cartItems) {
                    itemStmt.setString(1, orderID);
                    itemStmt.setString(2, item.getUPC());
                    itemStmt.setInt(3, item.getQuantity());
                    itemStmt.executeUpdate();
                }
                System.out.println("Order items saved: " + cartItems.size() + " items");

                // Update confirmedPayment with orderID
                confirmedPayment.setOrderID(orderID);
                session.setAttribute("orderID", orderID);
                session.setAttribute("confirmedPayment", confirmedPayment);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Failed to save order or order items: " + e.getMessage());
                request.getRequestDispatcher("Payment.jsp").forward(request, response);
                return;
            }

            

            // Clear cart
            CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
            CartDAO cartManager = (CartDAO) session.getAttribute("cartManager");
            Integer cartID = (Integer) session.getAttribute("cartID");
            if (cartID != null) {
                if (cartItemsManager != null) {
                    try {
                        cartItemsManager.removeAllItem(cartID);
                        System.out.println("Cart items cleared for cart ID: " + cartID);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Failed to clear cart items: " + e.getMessage());
                    }
                }
                if (cartManager != null) {
                    try {
                        cartManager.clearCart(cartID);
                        System.out.println("Cart cleared for cart ID: " + cartID);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Failed to clear cart: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("No cartID found in session");
            }

            // Clean up session attributes
            session.removeAttribute("cartID");
            session.removeAttribute("cartItems");
            session.removeAttribute("saveThisPayment");
            session.removeAttribute("newPaymentSummary");
            session.removeAttribute("name");
            session.removeAttribute("cardNumber");
            session.removeAttribute("type");

            // Redirect to OrderDetailsServlet with orderID
            System.out.println("Redirecting to OrderDetailsServlet with orderID: " + orderID);
            response.sendRedirect("OrderDetailsServlet?orderID=" + orderID);
            return;
        }

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String cardNumber = request.getParameter("cardNumber");
            String typeString = request.getParameter("type");
            Type type = Type.valueOf(typeString);
            String totalCost = request.getParameter("totalCost");
            double amount = (totalCost != null && !totalCost.isEmpty())
                    ? Double.parseDouble(totalCost) : 0.0;
            LocalDateTime date = LocalDateTime.now();

            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            int customerID = customer.getID();

            Payment payment = new Payment(customerID, name, cardNumber, type, amount, date);

            String saveCheckbox = request.getParameter("save");
            boolean save = "on".equals(saveCheckbox);
            session.setAttribute("saveThisPayment", save);
            session.setAttribute("newPaymentSummary", payment);

            request.getRequestDispatcher("Payment.jsp?action=add").forward(request, response);
            return;
        }

        if ("saved".equals(action)) {
            String selectedCardNumber = request.getParameter("cardNumber");
            PaymentDAO paymentDAO = (PaymentDAO) session.getAttribute("paymentManager");
            if (paymentDAO == null) {
                request.setAttribute("error", "Payment manager not found in session.");
                request.getRequestDispatcher("Payment.jsp").forward(request, response);
                return;
            }

            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            int customerId = customer.getID();

            try {
                for (Payment p : paymentDAO.getPaymentsByCustomerID(customerId)) {
                    if (p.getCardNumber().equals(selectedCardNumber)) {
                        session.setAttribute("newPaymentSummary", p);
                        break;
                    }
                }
                request.getRequestDispatcher("Payment.jsp?action=saved").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Failed to load saved payments: " + e.getMessage());
                request.getRequestDispatcher("Payment.jsp").forward(request, response);
            }
        }
    }
}