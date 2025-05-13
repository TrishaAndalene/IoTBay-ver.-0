package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.StoreCartDAO;
import dao.StoreCartItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddToStoreCartServlet")
public class AddToStoreCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        //1- retrieve the current session
        HttpSession session = request.getSession();
        Integer staffID = (Integer) session.getAttribute("staffID");

        String upc = request.getParameter("upc");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        //5- retrieve the manager instance from session      
        StoreCartDAO storeCartManager = (StoreCartDAO) session.getAttribute("storeCartManager");

        if (storeCartManager == null) throw new IOException("DB manager not found");

        StoreCartItemsDAO storeCartItemsManager = (StoreCartItemsDAO) session.getAttribute("storeCartItemsManager");
        if (storeCartItemsManager == null) throw new IOException("DB manager not found");

        System.out.println("Input received: " + staffID + "; " + upc + "; " + quantity);
           
        try {
            int storeCartID = storeCartManager.getCreateCart(staffID);
            session.setAttribute("storeCartID", storeCartID);
            storeCartItemsManager.addItemToCart(storeCartID, upc, quantity);
            response.sendRedirect("StoreCartServlet");

            } catch (SQLException ex) {
                Logger.getLogger(StoreCartServlet.class.getName()).log(Level.SEVERE, null, ex);  
            }
        }
    
}

