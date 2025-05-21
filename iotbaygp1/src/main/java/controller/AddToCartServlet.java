package controller;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        //1- retrieve the current session
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(request.getParameter("userID"));

        String upc = request.getParameter("upc");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        //5- retrieve the manager instance from session      
        CartDAO cartManager = (CartDAO) session.getAttribute("cartManager");

        if (cartManager == null) throw new IOException("DB manager not found");

        CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
        if (cartItemsManager == null) throw new IOException("DB manager not found");

        System.out.println("Input received: " + userID + "; " + upc + "; " + quantity);
           
        try {
            int cartID = cartManager.getCreateCart(userID);
            int itemID = cartItemsManager.findCartItem(cartID, upc);
            System.out.println(itemID);
            if (itemID != 0){
                cartItemsManager.updateCartItem(cartID, itemID, upc, quantity);
            } else {
                cartItemsManager.addItemToCart(cartID, upc, quantity);
            }
            
            session.setAttribute("cartID", cartID);
            response.sendRedirect("BrowseItemsServlet");

            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);  
            }
        }
    
}