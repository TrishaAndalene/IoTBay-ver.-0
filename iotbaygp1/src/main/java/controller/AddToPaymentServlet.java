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

@WebServlet("/AddToPaymentServlet")
public class AddToPaymentServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PaymentDAO paymentManager = (PaymentDAO) session.getAttribute("paymentManager");
        if (paymentManager == null) {throw new IOException("paymentManager is not found");}


        String name = request.getParameter("name");
        String cardNumber = request.getParameter("cardNumber");
        String type = request.getParameter("type");
        
        String save = request.getParameter("savePayment");
        boolean savePayment = (save != null);

        Integer customerID = (Integer) session.getAttribute("customerID");
        if (customerID == null) {
            customerID = 9;
                }
        System.out.println("Entered the AddToPayment servlet");
        
        if (savePayment) {
            // Checkbox was checked
                System.out.println("Save payment option selected.");
            } else {
                // Checkbox was not checked
                System.out.println("Save payment option NOT selected.");}
     
    try {
        if (savePayment) {
                paymentManager.savePayment(customerID, name, cardNumber, type); 
                System.out.println("Payment method saved.");
            }
        Payment payment = new Payment(customerID, name, cardNumber, type);
        int paymentID = paymentManager.setPayment(customerID, name, cardNumber, type);
        session.setAttribute("paymentID", paymentID);
        session.setAttribute("payment", payment);
        request.getRequestDispatcher("OrderConfirmationServlet").include(request, response);        
    
    } catch(SQLException ex){
                Logger.getLogger(AddToPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }