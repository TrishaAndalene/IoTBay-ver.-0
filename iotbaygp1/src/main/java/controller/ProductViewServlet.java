package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

@WebServlet("/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
   
@Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //3- capture the posted email - check jsp form name to see what parameter name
    String upc = request.getParameter("upc");      
    
    //5- retrieve the manager instance from session      
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
    if (productManager == null) throw new IOException("DB manager not found");


    Product product = null;       
 
    try {       
        product = productManager.findProduct(upc);
        
    } catch (SQLException ex) {           
        Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }


    if (product != null) {   
        try {
            List<Product> recommendedList = productManager.listAllProducts();
            request.setAttribute("product", product);
            request.setAttribute("recommendedList", recommendedList);
            request.getRequestDispatcher("/ProductView.jsp").include(request, response); 
            }  
        catch (SQLException ex) {           
            Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, ex); 
            }                
          
    } else {                       
        //15-set user does not exist error to the session
        session.setAttribute("errorMsg", "Incorrect upc :(");        
        //16- redirect user back to the login.jsp
        request.getRequestDispatcher("/BrowseItems.jsp").include(request, response);  
        }   
    }
}
