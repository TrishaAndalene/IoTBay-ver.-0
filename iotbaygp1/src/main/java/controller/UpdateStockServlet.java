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

@WebServlet("/UpdateStockServlet")
public class UpdateStockServlet extends HttpServlet {
    
    @Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //3- capture the posted details
    String upc = request.getParameter("upc");
    int qty = Integer.parseInt(request.getParameter("quantity"));

    
    //5- retrieve the manager instance from session      
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");

    if (productManager == null) throw new IOException("DB manager not found");
 
    try {       
        productManager.updateStock(upc, qty);
        
    } catch (SQLException ex) {           
        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    response.sendRedirect("StockMgmtServlet");
    }


}
