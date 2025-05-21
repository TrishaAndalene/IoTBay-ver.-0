package controller;
/* 
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Payment;
import model.Product;

@WebServlet("/SavedPaymentServlet")
public class SavedPaymentServlet extends HttpServlet{

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PaymentDAO paymentManager = (PaymentDAO) session.getAttribute("paymentManager");
        if (paymentManager == null) throw new IOException("paymentManager is not found");

        String selected = request.getParameter("selected");

        int selectedIndex = Integer.parseInt(selected); 

        int customerID = (int) session.getAttribute("customerID");

            try{
               

                request.getRequestDispatcher("/OrderConfirmation.jsp").include(request, response);
                
            }catch(SQLException ex){
                Logger.getLogger(AddToPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

}
        */