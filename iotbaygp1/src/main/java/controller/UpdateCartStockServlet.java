package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CartDAO;
import dao.CartItemsDAO;
import dao.ProductDAO;
import model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateCartStockServlet")
public class UpdateCartStockServlet extends HttpServlet {
    

    @Override   
protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
    //retrieve the current session
    HttpSession session = request.getSession();

    //capture the posted details
    String upc = request.getParameter("upc");
    String symbol = request.getParameter("symbol");

    //retrive the necesseary ObjectManager for the Servlet
    CartDAO cartManager = (CartDAO) session.getAttribute("cartManager");
    if (cartManager == null) throw new IOException("cartManager is not found");

    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
    if (productManager == null) throw new IOException("productManager is not found");

    Integer cartID = (Integer) session.getAttribute("cartID"); 
    Integer customerID = (Integer) session.getAttribute("customerID");
    if (customerID == null){ // <- is a set up for anonymous user
        customerID = 9;
    }
   
    CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
    if (cartItemsManager == null) throw new IOException("DB manager not found");
 
    // main process
    try {       
        cartID = cartManager.getCreateCart(customerID);
        Product p = productManager.findProduct(upc);
        // defect log solution to avoid quantity > product stock
        if (symbol.equalsIgnoreCase("plus")){
            if (cartItemsManager.findCartItemQuantity(cartID, upc) < p.getQuantity()){
                cartItemsManager.updateStock(cartID, upc, symbol);
            }
        } else {
            cartItemsManager.updateStock(cartID, upc, symbol);
        }
        
    } catch (SQLException ex) {           
        Logger.getLogger(UpdateCartStockServlet.class.getName()).log(Level.SEVERE, null, ex);    
    }

    response.sendRedirect("ViewCartServlet");
    }


}