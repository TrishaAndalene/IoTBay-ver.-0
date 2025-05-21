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
    //1- retrieve the current session
    HttpSession session = request.getSession();
        //5- retrieve the manager instance from session      
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");

    if (productManager == null) throw new IOException("DB manager not found");
    //3- capture the posted details
    String upc = request.getParameter("upc");
    String field = request.getParameter("field");
    String value = request.getParameter("value"); 
    
    if (field.equals("price")){
        try {
            double pricedouble = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "Update quantity must be an integer");
            request.getRequestDispatcher("ProductEditServlet").forward(request, response);
            return; 
            }
        }
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
    
    try {       

        productManager.updateProduct(field, upc, value);
        System.out.println(field + ": " + upc + ": " + value);
        
    } catch (SQLException ex) {           
        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    response.sendRedirect("StockMgmtServlet");
    }
}