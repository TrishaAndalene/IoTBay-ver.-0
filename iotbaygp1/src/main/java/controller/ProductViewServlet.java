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
    // Retrieving the current session
    HttpSession session = request.getSession();

    // Retrieving the manager instance from the session       
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
    if (productManager == null) throw new IOException("DB manager not found");

    // Capturing parameters passed in from the JSP
    String upc = request.getParameter("upc");      
    
    // Create product instance and capture object details retrieved by the database
    Product product = null;       
    try {       
        product = productManager.findProduct(upc);   
    } catch (SQLException ex) {           
        Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    // Send product instance to the JSP for viewing
    if (product != null) {   
        try {
            request.setAttribute("product", product);
            // Creates "recommended" list on product page - mostly for UX design
            List<Product> recommendedList = productManager.listAllProducts();
            request.setAttribute("recommendedList", recommendedList);

            request.getRequestDispatcher("/ProductView.jsp").include(request, response); 
            }  
        catch (SQLException ex) {           
            Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, ex); 
            }                
          
    } else {                       
        //Set up error message and redirect to the JSP   
        session.setAttribute("errorMsg", "UPC does not exist in the database");        
        request.getRequestDispatcher("BrowseItemsServlet").include(request, response);  
        }   
    }
}
