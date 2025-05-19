package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;


@WebServlet("/AddStoreCustomerServlet")
public class AddStoreCustomerServlet extends HttpServlet {
    
@Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //3- capture the posted details
    String customerPhn = request.getParameter("customerPhn");
    
    //5- retrieve the manager instance from session      
    CustomerDAO customerManager = (CustomerDAO) session.getAttribute("customerManager");

    if (customerManager == null) throw new IOException("DB manager not found");
 
    try {       
        Customer storeCustomer = customerManager.findCustomerbyPh(customerPhn);
        session.setAttribute("storeCustomer", storeCustomer);
    } catch (SQLException ex) {           
        Logger.getLogger(AddStoreCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    response.sendRedirect("StoreCartServlet");
    }
}