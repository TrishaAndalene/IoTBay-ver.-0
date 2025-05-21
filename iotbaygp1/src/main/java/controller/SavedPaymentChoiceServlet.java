package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.PaymentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Payment;

@WebServlet("/SavedPaymentChoiceServlet")
public class SavedPaymentChoiceServlet extends HttpServlet{

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer customerID = (Integer) session.getAttribute("customerID");

        PaymentDAO paymentManager = (PaymentDAO) session.getAttribute("paymentManager");
        if (paymentManager == null) throw new IOException("paymentManager is not found");

        String selected = request.getParameter("selected");
        String[] split = selected.split("\\.");
        String name = split[0];
        String cardNumber = split[1];
        String type = split[2];

            try{
                Payment payment = new Payment(customerID, name, cardNumber, type);
                int paymentID = paymentManager.setPayment(customerID, name, cardNumber, type);
                session.setAttribute("paymentID", paymentID);
                session.setAttribute("payment", payment);
                request.getRequestDispatcher("OrderConfirmationServlet").include(request, response); 
                
            }catch(SQLException ex){
                Logger.getLogger(AddToPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

}

