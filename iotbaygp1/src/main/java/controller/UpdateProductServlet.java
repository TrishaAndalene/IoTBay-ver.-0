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


@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    
@Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    // Retrieving the current session
    HttpSession session = request.getSession();
    // Retrieving the manager instance from the session      
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
    if (productManager == null) throw new IOException("DB manager not found");

    // Capturing parameters passed in from the JSP
    String upc = request.getParameter("upc");
    String field = request.getParameter("field");
    String value = request.getParameter("value"); 

    // Error Checking - Price must be a number 
    if (field.equals("price")){
        try {
            double pricedouble = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "Update quantity must be an integer");
            request.getRequestDispatcher("ProductEditServlet").forward(request, response);
            return; 
            }
        }
    // Error Checking - image URL must be a URL       
    if (field.equals("image")){
            try {
                if (!value.contains("https://")){
                request.setAttribute("errorMesg", "Image URL Update must be a URL");
                request.getRequestDispatcher("ProductEditServlet").forward(request, response);
            return;
                }
            } catch (Exception e){    
        }
    }
    
    // Update product instance in the database
    try {       
        productManager.updateProduct(field, upc, value);   
    } catch (SQLException ex) {           
        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }
    // Redirects to the Stock Management page
    response.sendRedirect("StockMgmtServlet");
    }
}