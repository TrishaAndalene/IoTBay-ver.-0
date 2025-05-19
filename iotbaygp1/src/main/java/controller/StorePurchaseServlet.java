package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.StorePurchaseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StorePurchaseServlet")
public class StorePurchaseServlet extends HttpServlet {
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int customerID = Integer.parseInt(request.getParameter("storeCustomerID"));
        double totalCost = Double.parseDouble(request.getParameter("totalPrice"));
        int storeCartID = Integer.parseInt(request.getParameter("storeCartID"));
        int salespersonID = Integer.parseInt(request.getParameter("salespersonID"));

        // Manager tab
        StorePurchaseDAO storePurchaseManager = (StorePurchaseDAO) session.getAttribute("storePurchaseManager");
        if (storePurchaseManager == null) throw new IOException("cartManager is null");
        //ProductDAO productManager = (ProductDAO) session. getAttribute("productManager");
        //if (productManager == null) throw new IOException("productManager is null");

        try {
            storePurchaseManager.createPurchase(customerID, storeCartID, salespersonID, totalCost);
            System.out.println("Purchase successful!");


            request.getRequestDispatcher("/StorePurchaseConfirmation.jsp").forward(request, response);

            // Create order object
        } catch (SQLException e){
            Logger.getLogger(SubmitCartServlet.class.getName()).log(Level.SEVERE, null, e);    
        }

    }
}
