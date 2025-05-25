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
        //retrieve the current session
        HttpSession session = request.getSession();

        //retrieve all relevant objectManager for the Servlet
        CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
        if (cartItemsManager == null) throw new IOException("DB manager not found");

        CartDAO cartManager = (CartDAO) session.getAttribute("cartManager");
        if (cartManager == null) throw new IOException("DB cart manager is not found");
    
        Integer customerID = (Integer) session.getAttribute("customerID");  
        if (customerID == null){ // <- is a set up for anonymous user
            customerID = 9;
        }

        Integer cartID = (Integer) session.getAttribute("cartID");
        if (cartID == null) { // <- is a set up to create Cart if the user doesn not have one
            try {
                cartID = cartManager.getCreateCart(customerID);
            } catch (SQLException e){}
        }
     
        // main process
        try {    

            List<CartItem> cartItemList = cartItemsManager.getCartItems(cartID);
            Map<Product, Integer> cartItems = new HashMap<>();

            for (CartItem c : cartItemList){
                int qty = c.getQuantity();
                Product p = c.getProduct();
                cartItems.put(p, qty);}

            request.setAttribute("cartItems", cartItems);
            request.getRequestDispatcher("/ViewCart.jsp").include(request, response);

            
        } catch (SQLException ex) {           
            Logger.getLogger(ViewCartServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

}}