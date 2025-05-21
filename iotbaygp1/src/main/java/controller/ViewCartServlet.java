package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CartDAO;
import dao.CartItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;
import model.Product;
 
@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        //1- retrieve the current session
        HttpSession session = request.getSession();

        CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
        if (cartItemsManager == null) throw new IOException("DB manager not found");

        CartDAO cartManager = (CartDAO) session.getAttribute("cartManager");
        if (cartManager == null) throw new IOException("DB cart manager is not found");
    
        //3- capture the posted email - check jsp form name to see what parameter name
        Integer customerID = (Integer) session.getAttribute("customerID");  
        if (customerID == null){
            customerID = 9;
        }

        Integer cartID = (Integer) session.getAttribute("cartID");
        if (cartID == null) {
            try {
                cartID = cartManager.getCreateCart(customerID);
            } catch (SQLException e){}
        }
        
        //5- retrieve the manager instance from session      

     
        try {    

            List<CartItem> cartItemList = cartItemsManager.getCartItems(cartID);
            Map<Product, Integer> cartItems = new HashMap<>();

            for (CartItem c : cartItemList){
                int qty = c.getQuantity();
                Product p = c.getProduct();
                cartItems.put(p, qty);}

            request.setAttribute("cartItems", cartItems);
            //14- redirect user to the main.jsp
            request.getRequestDispatcher("/ViewCart.jsp").include(request, response);

            
        } catch (SQLException ex) {           
            Logger.getLogger(ViewCartServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

}}