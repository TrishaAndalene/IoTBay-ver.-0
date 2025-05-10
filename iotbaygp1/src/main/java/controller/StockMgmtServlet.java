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
        //1- retrieve the current session
        HttpSession session = request.getSession();
    
        //5- retrieve the manager instance from session      
        ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
        if (productManager == null) throw new IOException("DB manager not found");
    
    
        List<Product> allProduct = null; 
        
        System.out.println("Session ID: " + session.getId());
        System.out.println("productManager is null: " + (productManager == null));

     
        try {       
            allProduct = productManager.listAllProducts();
            
        } catch (SQLException ex) {           
            Logger.getLogger(StockMgmtServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }
    
        if (allProduct != null) {                     
            //13-save the logged in user object to the session
            request.setAttribute("allProduct", allProduct);
            //14- redirect user to the main.jsp
            request.getRequestDispatcher("/StockMgmt.jsp").forward(request, response);   
        } else {                       
            //15-set user does not exist error to the session
            request.setAttribute("errorMsg", "Idk what is going on :(");        
            //16- redirect user back to the login.jsp
            request.getRequestDispatcher("/BrowseItems.jsp").include(request, response);  
            }   
        }
    }
