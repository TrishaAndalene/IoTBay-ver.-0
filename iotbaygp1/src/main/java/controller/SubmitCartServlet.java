package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CartDAO;
import dao.CartItemsDAO;
import dao.OrderDAO;
import dao.OrderItemsDAO;
import dao.PaymentDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;
import model.OrderItem;
import model.Product;

@WebServlet("/SubmitCartServlet")
public class SubmitCartServlet extends HttpServlet{
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        // Manager tab
        CartDAO cartManager = (CartDAO) session.getAttribute("cartManager");
        if (cartManager == null) throw new IOException("cartManager is null");

        CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
        if (cartItemsManager == null) throw new IOException("cartItemsManager is null");

        OrderDAO orderManager = (OrderDAO) session.getAttribute("orderManager");
        if (orderManager == null) throw new IOException("orderManager is not found");

        OrderItemsDAO orderItemManager = (OrderItemsDAO) session.getAttribute("orderItemsManager");
        if (orderItemManager == null) throw new IOException("orderItemManager is not found");

        PaymentDAO paymentManager = (PaymentDAO) session.getAttribute("paymentManager");
        if (paymentManager == null) throw new IOException("paymentManager is not found");

        ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
        if (productManager == null) throw new IOException("productManager is not found");

        Double cost = Double.parseDouble(request.getParameter("totalPrice"));
        Integer paymentID = (Integer) session.getAttribute("paymentID");

        Integer customerID = (Integer) session.getAttribute("customerID");
        if (customerID == null){customerID = 9;}



        try {
            if (customerID != null){
                int cartID = cartManager.getCreateCart(customerID);
                System.out.println(cartID);

                List<CartItem> cartItems = cartItemsManager.getCartItems(cartID);
                System.out.println("I am here");

                String orderID = orderManager.createOrder(customerID, cost);
                System.out.println("No, I'm here");

                int confirmedPaymentID = paymentManager.confirmPayment(orderID, paymentID);


                for (CartItem c : cartItems){
                    if (c.getQuantity() != 0){
                        orderItemManager.addItemToOrder(orderID, c.getUPC(), c.getQuantity());
                        Product p = productManager.findProduct(c.getUPC());
                        int stock = p.getQuantity() - c.getQuantity();
                        System.out.println(p.getQuantity());
                        System.out.println(c.getQuantity());
                        System.out.println(stock);
                        productManager.updateStockAfterOrder(c.getUPC(), stock);
                        System.out.println(c.getUPC());
                        System.out.println("here2");
                    }
                }

                List<OrderItem> orderItemsList = orderItemManager.getOrderItems(orderID);

                cartItemsManager.removeAllItem(cartID);
                request.setAttribute("orderItems", orderItemsList);
                request.setAttribute("orderID", orderID);
                request.setAttribute("confirmedPaymentID", confirmedPaymentID);

                request.getRequestDispatcher("OrderConfirmation.jsp").include(request, response);
            } else {
                System.out.println("customerID is null");
            }

            // Create order object
        } catch (SQLException e){
            Logger.getLogger(RemoveProductServlet.class.getName()).log(Level.SEVERE, null, e);    
        }

    }

}
