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
import model.Product;


@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    
@Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();

    //3- capture the posted details
    String upc = request.getParameter("upc");
    String name = request.getParameter("name"); 
    String brand = request.getParameter("brand");  
    Double price = Double.valueOf(request.getParameter("price"));
    String colour = request.getParameter("colour");
    String size = request.getParameter("size");
    String description = request.getParameter("description");
    Integer quantity = Integer.valueOf(request.getParameter("quantity"));
    String image = request.getParameter("image");
    String category = request.getParameter("categoryStr");

    Product product = new Product(upc, name, price, brand, colour, size, image, quantity, category, description);  
    
    //5- retrieve the manager instance from session      
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");

    if (productManager == null) throw new IOException("DB manager not found");
 
    try {       
        productManager.addProduct(product);
        
    } catch (SQLException ex) {           
        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    response.sendRedirect("/StockMgmt.jsp");
    }
}