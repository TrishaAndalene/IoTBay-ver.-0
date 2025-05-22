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

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        CustomerDAO customerManager = (CustomerDAO)session.getAttribute("customerManager");
        if (customerManager == null) throw new IOException("DB customer Manager not found");

        Customer customer = null;

        int logID = 0;


        try{
            customer = customerManager.findCustomer(email, password);
            if(customer != null){
                logID = customerManager.addAccessCustomerLog(customer);
            }

        }catch (SQLException ex){
            Logger.getLogger(CustomerLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(customer != null){
            session.setAttribute("customer", customer);
            session.setAttribute("logID", logID);
            session.setAttribute("customerID", customer.getID());
            request.getRequestDispatcher("/Main.jsp").include(request, response);
        }else{
            request.setAttribute("errorMsg", "User does not exist in the system");
            request.getRequestDispatcher("/CustomerLogin.jsp").include(request, response);
        }
    }
}
