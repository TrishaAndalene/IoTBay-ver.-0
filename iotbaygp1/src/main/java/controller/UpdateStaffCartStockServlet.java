package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.StoreCartItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateStaffCartStockServlet")
public class UpdateStaffCartStockServlet extends HttpServlet {
    

    @Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //3- capture the posted details
    String upc = request.getParameter("upc");
    String symbol = request.getParameter("symbol");
    Integer storeCartID = (Integer) session.getAttribute("storeCartID"); 

    
    //5- retrieve the manager instance from session      
    StoreCartItemsDAO storeCartItemsManager = (StoreCartItemsDAO) session.getAttribute("storeCartItemsManager");

    if (storeCartItemsManager == null) throw new IOException("DB manager not found");
 
    try {       
        storeCartItemsManager.updateStock(storeCartID, upc, symbol);
        
    } catch (SQLException ex) {           
        Logger.getLogger(UpdateStaffCartStockServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    response.sendRedirect("StoreCartServlet");
    }


}

