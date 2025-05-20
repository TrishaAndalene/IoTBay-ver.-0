package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CartItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateCartStockServlet")
public class UpdateCartStockServlet extends HttpServlet {
    

    @Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //3- capture the posted details
    String upc = request.getParameter("upc");
    String symbol = request.getParameter("symbol");
    Integer cartID = (Integer) session.getAttribute("cartID"); 

    
    //5- retrieve the manager instance from session      
    CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");

    if (cartItemsManager == null) throw new IOException("DB manager not found");
 
    try {       
        cartItemsManager.updateStock(cartID, upc, symbol);
        
    } catch (SQLException ex) {           
        Logger.getLogger(UpdateCartStockServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    response.sendRedirect("ViewCartServlet");
    }


}
