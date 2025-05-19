package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.PaymentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Payment;

@WebServlet("/SavedPaymentsServlet")
public class SavedPaymentsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Connection conn = (Connection) session.getAttribute("conn");

        String action = request.getParameter("action");
        
        PaymentDAO paymentDAO = new PaymentDAO(conn);

        if ("saved".equals(action)) {
            try {
                List<Payment> savedPayments = paymentDAO.getPaymentsByCustomerID(customer.getID());
                session.setAttribute("savedPayments", savedPayments);
                response.sendRedirect("Payment.jsp?action=saved");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else if ("use".equals(action)) {
            List<Payment> savedPayments = (List<Payment>) session.getAttribute("savedPayments");
            String selectedIndex = request.getParameter("selected");

            try {
                int index = Integer.parseInt(selectedIndex);
                if (index >= 0 && index < savedPayments.size()) {
                    Payment selectedPayment = savedPayments.get(index);
                    session.setAttribute("name", selectedPayment.getName());
                    session.setAttribute("cardNumber", selectedPayment.getCardNumber());
                    session.setAttribute("type", selectedPayment.getType().toString());
                    System.out.println("SavedPaymentsServlet - Selected payment: " + selectedPayment.getName());
                    response.sendRedirect("Payment.jsp?action=enter");
                } else {
                    response.sendRedirect("Payment.jsp?error=invalid_selection");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Invalid input for payment selection: " + e.getMessage());
                response.sendRedirect("Payment.jsp?error=invalid_input");
            }
        }
    }
}
