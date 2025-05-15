package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ProductDAO;
import dao.StaffDAO;
import dao.StoreCartItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;
import model.Staff;
import model.StoreCartItem;
 
@WebServlet("/StoreCartServlet")
public class StoreCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        //1- retrieve the current session
        HttpSession session = request.getSession();
    
        //3- capture the posted email - check jsp form name to see what parameter name
        Integer storeCartID = (Integer) session.getAttribute("storeCartID");      
        
        //5- retrieve the manager instance from session      
        StoreCartItemsDAO storeCartItemsManager = (StoreCartItemsDAO) session.getAttribute("storeCartItemsManager");
        if (storeCartItemsManager == null) throw new IOException("DB manager not found");
        ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
        if (productManager == null) throw new IOException("DB manager not found");
        StaffDAO staffManager = (StaffDAO) session.getAttribute("staffManager");
        if (staffManager == null) throw new IOException("Staff manager not found");
          
     
        try {    
            List<Staff> staffList = staffManager.getAllStaff();
            List<StoreCartItem> storeCartItemList = storeCartItemsManager.getCartItems(storeCartID);
            Map<Product, Integer> cartItems = new HashMap<>();

            for (StoreCartItem i : storeCartItemList){
                String upc = i.getUPC();
                int qty = i.getQuantity();
                Product p = productManager.findProduct(upc);
                cartItems.put(p, qty);}
            
            request.setAttribute("cartItems", cartItems);
            request.setAttribute("staffList", staffList);

            //14- redirect user to the main.jsp
            request.getRequestDispatcher("/StoreCart.jsp").include(request, response);

            
        } 
        
        
        
        catch (SQLException ex) {           
            Logger.getLogger(StoreCartServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

}}