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
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //2- create an instance of the Validator class 
    Validator validator = new Validator();  

    //3- capture the posted email - check jsp form name to see what parameter name
    String email = request.getParameter("email");      
    
    //4- capture the posted password 
    String password = request.getParameter("password");
    
    //5- retrieve the manager instance from session      
    StaffDAO manager = (StaffDAO) session.getAttribute("manager");
    if (manager == null) throw new IOException("DB manager not found");


    Staff staff = null;       
 
    try {       
        staff = manager.findStaff(email, password);
        
    } catch (SQLException ex) {           
        Logger.getLogger(StaffLoginServlet.class.getName()).log(Level.SEVERE, null, ex);       
    }


    // validator not super necessary for logging in 
    if (validator.validateEmail(email)) {           
        //8-set incorrect email error to the session  
        session.setAttribute("errorMsg", "email does not fit correct format");         
        //9- redirect user back to the login.jsp
        request.getRequestDispatcher("StaffLogin.jsp").include(request, response);     
    } else if (validator.validatePassword(password)) {                  
        //11-set incorrect password error to the session
        session.setAttribute("errorMsg", "password does not fit correct format");           
        //12- redirect user back to the login.jsp  
        request.getRequestDispatcher("StaffLogin.jsp").include(request, response);        
    } else if (staff != null) {                     
        //13-save the logged in user object to the session
        session.setAttribute("staff", staff);
        //14- redirect user to the main.jsp
        request.getRequestDispatcher("Landing.jsp").include(request, response);   
    } else {                       
        //15-set user does not exist error to the session
        session.setAttribute("errorMsg", "Incorrect email or password :(");        
        //16- redirect user back to the login.jsp
        request.getRequestDispatcher("StaffLogin.jsp").include(request, response);  
        }   
    }
}