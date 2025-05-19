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
import model.Customer;
import model.Staff;

@WebServlet("/AccountDeleteServlet")
public class AccountDeleteServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        CustomerDAO customerManager = (CustomerDAO)session.getAttribute("customerManager");
        StaffDAO staffManager = (StaffDAO)session.getAttribute("staffManager");

        Customer customer = (Customer)session.getAttribute("customer");
        Staff staff = (Staff)session.getAttribute("staff");

        int success = 0;

        // If current user is customer
        if(customer != null){
            try{
                System.out.println("Customer exist");
                success = customerManager.deleteCustomer(customer, password);
                System.out.println("Customer account delete success");
            }catch(SQLException ex){
                Logger.getLogger(AccountDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(success == 1){
                session.invalidate();
                response.sendRedirect("Main.jsp");
            }else{
                session.setAttribute("errorMsg", "Something is wrong. Account delete fail");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }
        }else{
        // If current user is staff
            try{
                System.out.println("Staff exist");
                success = staffManager.deleteStaff(staff, password);
                System.out.println("Staff account delete success");
            }catch(SQLException ex){
                Logger.getLogger(AccountDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(success == 1){
                session.invalidate();
                response.sendRedirect("Main.jsp");
            }else{
                session.setAttribute("errorMsg", "Something is wrong. Account delete fail");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }
        }
    }
}
