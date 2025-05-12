package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.StaffDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Staff;

@WebServlet("/StaffLoginServlet")
public class StaffLoginServlet extends HttpServlet {
   
@Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       

    HttpSession session = request.getSession(); 

    String email = request.getParameter("email");      
    String password = request.getParameter("password");
          
    StaffDAO staffManager = (StaffDAO) session.getAttribute("staffManager");
    if (staffManager == null) throw new IOException("DB manager not found");


    Staff staff = null;       
 
    try {       
        staff = staffManager.findStaff(email, password);
        
    } catch (SQLException ex) {           
        Logger.getLogger(StaffLoginServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    if (staff != null) {                     
        //13-save the logged in user object to the session
        session.setAttribute("staff", staff);
        //14- redirect user to the main.jsp
        request.getRequestDispatcher("/StaffLanding.jsp").include(request, response);   
    } else {                       
        //15-set user does not exist error to the session
        session.setAttribute("errorMsg", "Incorrect email or password :(");        
        //16- redirect user back to the login.jsp
        request.getRequestDispatcher("/StaffLogin.jsp").include(request, response);  
        }   
    }
}
