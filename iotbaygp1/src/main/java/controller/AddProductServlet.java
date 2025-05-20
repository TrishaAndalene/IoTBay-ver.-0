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
import model.Categories;
import model.Product;


@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    
@Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //1- retrieve the current session
    HttpSession session = request.getSession();
    //5- retrieve the manager instance from session      
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
    if (productManager == null) throw new IOException("DB manager not found");

    //3- capture the posted details
    String upc = request.getParameter("upc");
    String name = request.getParameter("name"); 
    String brand = request.getParameter("brand");  
    String priceStr = request.getParameter("price");
    String colour = request.getParameter("colour");
    String size = request.getParameter("size");
    String description = request.getParameter("description");
    String quantityStr = request.getParameter("quantity");
    String image = request.getParameter("image");
    String categoryStr = request.getParameter("category");

    Categories cat = null;

            if (categoryStr.equalsIgnoreCase("wifi")){
                cat = Categories.WIFI;
            } else if (categoryStr.equalsIgnoreCase("home_security")){
                cat = Categories.HOME_SECURITY;
            } else if (categoryStr.equalsIgnoreCase("activity_trackers")){
                cat = Categories.ACTIVITY_TRACKERS;
            } else if (categoryStr.equalsIgnoreCase("actuator")){
                cat = Categories.ACTUATOR;
            } else if (categoryStr.equalsIgnoreCase("ambient_iot")){
                cat = Categories.AMBIENT_IOT;
            } else if (categoryStr.equalsIgnoreCase("mini_pc")){
                cat = Categories.MINI_PC;
            }


    double price = 0;
    int quantity = 0;

    try {   
        price = Double.parseDouble(priceStr);  
    } catch (NumberFormatException ex) {           
        request.setAttribute("errorMsg", "Price must be a number");
        request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
        return; }

    try {
        if (!image.contains("https://")){
            request.setAttribute("errorMsg", "Image URL must be a URL");
            request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
            return;
                }
            } catch (Exception e){    
        }
        
    try {   
        quantity = Integer.parseInt(quantityStr);  
    } catch (NumberFormatException ex) {           
        request.setAttribute("errorMesg", "Stock quantity must be an integer");
        request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
        return; }

    Product product = new Product(upc, name, price, brand, colour, size, image, quantity, cat, description);  
    
    try {       
        productManager.addProduct(product);
            request.setAttribute("confirmMessg", "New Item Added!");
            request.getRequestDispatcher("AddProductServlet").forward(request, response);
            return;
        
    } catch (SQLException ex) {           
        Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    //response.sendRedirect("StockMgmtServlet");
    }
}