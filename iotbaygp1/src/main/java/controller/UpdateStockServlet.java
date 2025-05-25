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
    // Retrieving the current session
    HttpSession session = request.getSession();

    // Retrieving the manager instance from session  
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
    if (productManager == null) throw new IOException("DB manager not found");

    // Capturing parameters passed in from the JSP
    String upc = request.getParameter("upc");
    String qtystr = request.getParameter("quantity");

    // Error Checking & database update - QTY must be a number   
    try {   
        int qty = Integer.parseInt(qtystr); 
        productManager.updateStock(upc, qty);   
    } catch (NumberFormatException ex) {           
        request.setAttribute("errorMsg", "Update quantity must be an integer");
        request.getRequestDispatcher("StockMgmtServlet").forward(request, response);
        return;  
    } catch (SQLException ex) {           
        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    // Redirects to the Stock Management page with new product qty
    response.sendRedirect("StockMgmtServlet");
    }


}
