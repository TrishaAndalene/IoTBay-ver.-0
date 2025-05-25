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

@WebServlet("/StockSearchServlet")
public class StockSearchServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        // Retrieving the current session
        HttpSession session = request.getSession();

        // Retrieving the manager instance from session     
        ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
        if (productManager == null) throw new IOException("DB manager not found");

        // Capturing the search parameter passed in from the JSP       
        String search = request.getParameter("searchQuery");

        // Create list to be passed in to the view
        List<Product> allProduct = null;
            try {
                if (search == null || search.equals("all")){
                    allProduct = null;
                } else {
                    //if there is a search parameter
                    allProduct = productManager.productSearch(search);} 
            } catch (SQLException ex) {
                Logger.getLogger(StockSearchServlet.class.getName()).log(Level.SEVERE, null, ex);  
            }

        // Pass the list to the view as an attribute and redirect to the JSP
        if (allProduct != null) {                     
            request.setAttribute("allProduct", allProduct);
            request.getRequestDispatcher("/StockSearch.jsp").forward(request, response);   
        } else {                       
            //Set up error message and redirect to the JSP
            request.setAttribute("errorMsg", "No items found");        
            request.getRequestDispatcher("/StockSearch.jsp").include(request, response);  
            }   

        }
    }
