package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CustomerDAO;
import dao.StaffDAO;
import dao.StorePurchaseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Staff;
import model.StorePurchase;

@WebServlet("/InStoreSalesServlet")
public class InStoreSalesServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
        //1- retrieve the current session
        HttpSession session = request.getSession();
  
        //5- retrieve the manager instance from session    
        StorePurchaseDAO storePurchaseManager = (StorePurchaseDAO) session.getAttribute("storePurchaseManager");
        if (storePurchaseManager == null) throw new IOException("Store Purchase manager not found");
        StaffDAO staffManager = (StaffDAO) session.getAttribute("staffManager");
        if (staffManager == null) throw new IOException("Staff manager not found");
        CustomerDAO customerManager = (CustomerDAO) session.getAttribute("customerManager");
        if (customerManager == null) throw new IOException("Customer manager not found");

        List<StorePurchase> storePurchaseList = null;

            try {
                List<Staff> staffList = staffManager.getAllStaff();
                List<Customer> customerList = customerManager.getAllCustomers();
                
                storePurchaseList = storePurchaseManager.getStorePurchases();
                System.out.println("Purchase List Added!");
                request.setAttribute("customerList", customerList);
                request.setAttribute("staffList", staffList);
                request.setAttribute("storePurchaseList", storePurchaseList);
                request.getRequestDispatcher("/InStoreSales.jsp").forward(request, response);  
                
            } catch (SQLException ex) {
                Logger.getLogger(InStoreSalesServlet.class.getName()).log(Level.SEVERE, null, ex);  
            }
    
        if (storePurchaseList != null) {                  
            //13-save the logged in user object to the session
             
        } else {                       
            //15-set user does not exist error to the session
            request.setAttribute("errorMsg", "Idk what is going on :(");        
            //16- redirect user back to the login.jsp
            request.getRequestDispatcher("/InStoreSales.jsp").include(request, response);  
            }   
        }
    }
