package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.StaffDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Staff;


public class StaffLoginController extends HttpServlet {

    @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
    
        
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            StaffDAO staffManager = (StaffDAO) getServletContext().getAttribute("staffManager");
            System.out.println("staffManager: " + staffManager);
  
            try {       
                Staff staff = staffManager.findStaff(email, password);
                //6- find user by email and password
                if (staff != null){
                    session.setAttribute("staff", staff);
                    request.getRequestDispatcher("/jsp/StaffLanding.jsp").forward(request, response);

                } else {
                    session.setAttribute("existErr", "Staff does not exist in database!");
                    request.getRequestDispatcher("/jsp/StaffLogin.jsp").forward(request, response);

                }

            } catch (SQLException ex) {           
               Logger.getLogger(StaffLoginController.class.getName()).log(Level.SEVERE, null, ex); 
    
    } 
}
}
