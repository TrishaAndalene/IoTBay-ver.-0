package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CustomerDAO;
import dao.StaffDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.AccessLog;
import model.Customer;
import model.Staff;

import java.util.ArrayList;

@WebServlet("/AccessLogServlet")
public class AccessLogServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();

        Customer customer = (Customer)session.getAttribute("customer");
        Staff staff = (Staff) session.getAttribute("staff");

        CustomerDAO customerManager = (CustomerDAO) session.getAttribute("customerManager");
        StaffDAO staffManager = (StaffDAO) session.getAttribute("staffManager");

        ArrayList<AccessLog> accessLogSet = new ArrayList<>();

        if(customer != null){
            String customerEmail = customer.getEmail();

            try{
            System.out.println(customerManager.getAccessLog(customerEmail));
            accessLogSet = customerManager.getAccessLog(customerEmail);
            }catch(SQLException e){
                Logger.getLogger(AccessLogServlet.class.getName()).log(Level.SEVERE, null, e);
            }

            if(accessLogSet != null){
                session.setAttribute("accessLogSet", accessLogSet);
                request.getRequestDispatcher("/AccessLog.jsp").include(request, response);
            }else{
                session.setAttribute("errorMsg", "There is no access log record");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }
        }else if (staff != null){
            String staffEmail = staff.getEmail();

            try{
                System.out.println(staffManager.getAccessLog(staffEmail));
                accessLogSet = staffManager.getAccessLog(staffEmail);
            }catch(SQLException e){
                Logger.getLogger(AccessLogServlet.class.getName()).log(Level.SEVERE, null, e);
            }

            if(accessLogSet != null){
                session.setAttribute("accessLogSet", accessLogSet);
                request.getRequestDispatcher("/AccessLog.jsp").include(request, response);
            }else{
                session.setAttribute("errorMsg", "There is no access log record");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }
        }

        
        
    }
}