package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;


public class BrowseItemController extends HttpServlet {

    @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
    
        
            HttpSession session = request.getSession();
            String upc = request.getParameter("upc");
            ProductDAO productManager = (ProductDAO) getServletContext().getAttribute("productManager");
            System.out.println("productManager: " + productManager);
  
            try {       
                Product product = productManager.findProduct(upc);
                //6- find user by email and password
                if (product != null){
                    session.setAttribute("product", product);
                    request.getRequestDispatcher("/jsp/BrowseItems.jsp").forward(request, response);

                } else {
                    session.setAttribute("existErr", "Product does not exist in database!");
                    request.getRequestDispatcher("/jsp/StaffLogin.jsp").forward(request, response);

                }

            } catch (SQLException ex) {           
               Logger.getLogger(StaffLoginController.class.getName()).log(Level.SEVERE, null, ex); 
    
    } 
}
}
