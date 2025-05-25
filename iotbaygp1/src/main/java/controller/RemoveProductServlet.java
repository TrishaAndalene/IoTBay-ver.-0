package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        // Retrieving the current session
        HttpSession session = request.getSession();

        // Retrieving the manager instance from the session     
        ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
        if (productManager == null) throw new IOException("DB manager not found");
    
        // Capturing parameters passed in from the JSP
        String upc = request.getParameter("upc");
        
        // sending captured UPC to the product manager for removal from the database
        try {       
            productManager.removeProduct(upc);  
        } catch (SQLException ex) {           
            Logger.getLogger(RemoveProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

        // Sends back to the Stock Management page via the servlet
        response.sendRedirect("StockMgmtServlet");
        }
}
