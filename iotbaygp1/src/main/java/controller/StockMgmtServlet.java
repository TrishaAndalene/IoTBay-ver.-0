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

@WebServlet("/StockMgmtServlet")
public class StockMgmtServlet extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        // Retrieving the current session
        HttpSession session = request.getSession();
    
        // Retrieving the manager instance from the session   
        ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
        if (productManager == null) throw new IOException("DB manager not found");
    
        // Create list of all Products in the database to be passed in to the view   
        List<Product> allProduct = null; 
        try {       
            allProduct = productManager.listAllProducts();    
        } catch (SQLException ex) {           
            Logger.getLogger(StockMgmtServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

        // Pass the list to the view as an attribute and redirect to the JSP
        if (allProduct != null) {                     
            request.setAttribute("allProduct", allProduct);
            request.getRequestDispatcher("/StockMgmt.jsp").forward(request, response);   
        } else {                       
        //Set up error message and redirect to the JSP
            request.setAttribute("errorMsg", "No items found.");        
            request.getRequestDispatcher("/StockMgmt.jsp").include(request, response);  
            }   
        }
    }
