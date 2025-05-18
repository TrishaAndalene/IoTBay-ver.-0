package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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

@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {

        @Override   
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
            //1- retrieve the current session
            HttpSession session = request.getSession();
        
            //3- capture the posted details
            String upc = request.getParameter("upc");
            
            //5- retrieve the manager instance from session      
            CartItemsDAO cartItemManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
        
            if (cartItemManager == null) throw new IOException("DB manager not found");

            CartDAO cartManager = (CartDAO) session.getAttribute("cartManager");
            if (cartManager == null) throw new IOException("DB manager 2 is not found");

            Integer customerID = (Integer) session.getAttribute("customerID");
            if (customerID == null){customerID = 0;};
         
            try {       
                if (customerID != null){
                    int cartID = cartManager.getCreateCart(customerID);
                    cartItemManager.removeCartItem(cartID, upc);
                    List<CartItem> cartItems = cartItemManager.getCartItems(cartID);
                    request.setAttribute("cartItems", cartItems);
                }
                
            } catch (SQLException ex) {           
                Logger.getLogger(RemoveProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
            }
        
            response.sendRedirect("ViewCartServlet");
            }
    }
