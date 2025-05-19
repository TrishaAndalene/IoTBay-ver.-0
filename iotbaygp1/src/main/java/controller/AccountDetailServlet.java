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

@WebServlet("/AccountDetailServlet")
public class AccountDetailServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        
        Customer customer = (Customer)session.getAttribute("customer");
        Staff staff = (Staff)session.getAttribute("staff");

        int customerId = 0;
        int staffId = 0;

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");
        String password = request.getParameter("password");

        CustomerDAO customerManager = (CustomerDAO)session.getAttribute("customerManager");
        StaffDAO staffManager = (StaffDAO)session.getAttribute("staffManager");

        int success = 0;

        if(customer != null){
            customerId = customer.getID();

            try{
                success = customerManager.updateCustomer(customerId, firstName, lastName, email, phoneNum, password);
                System.out.println("Update success");
                Customer updatedCustomer = (Customer) customerManager.findCustomer(email,password);
                session.setAttribute("customer", updatedCustomer);
            }catch(SQLException ex){
                Logger.getLogger(AccountDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(success == 1){
                System.out.println("Success");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }else{
                System.out.println("Fail");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }
        }else{
            staffId = staff.getID();

            try{
                success = staffManager.updateStaff(staffId, firstName, lastName, email, phoneNum, password);
                System.out.println("Update success");
                Staff updatedStaff = (Staff) staffManager.findStaff(email, password);
                session.setAttribute("staff", updatedStaff);
            }catch(SQLException ex){
                Logger.getLogger(AccountDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(success == 1){
                System.out.println("Success");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }else{
                System.out.println("Fail");
                request.getRequestDispatcher("/Myaccount.jsp").include(request, response);
            }
        }
    }
}
