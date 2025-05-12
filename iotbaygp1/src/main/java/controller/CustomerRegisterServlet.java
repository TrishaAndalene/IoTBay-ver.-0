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

@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

@Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //3- capture the posted email - check jsp form name to see what parameter name
    String email = request.getParameter("email");      
    String password = request.getParameter("password");
    String phoneNum = request.getParameter("phoneNum");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    //5- retrieve the manager instance from session      
    CustomerDAO customerManager = (CustomerDAO) session.getAttribute("customerManager");
    if (customerManager == null) throw new IOException("DB customerManager not found");

    try { 
        Customer customer = new Customer(firstName, lastName, email, phoneNum, password);
        int userID = customerManager.addCustomer(customer);
        Customer customerWID = new Customer(userID, firstName, lastName, email, phoneNum, password);
        session.setAttribute("customer", customerWID);
        session.setAttribute("customerID", customerWID.getID());
        response.sendRedirect("index.jsp");
        
    } catch (SQLException ex) {           
        Logger.getLogger(CustomerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);    
        response.sendRedirect("index.jsp");   
    }

    
}
}
