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

        int storeCartID = Integer.parseInt(request.getParameter("storeCartID"));
        int salespersonID = Integer.parseInt(request.getParameter("salespersonID"));

        // Double cost = Double.parseDouble(request.getParameter("totalPrice"));

        // Manager tab
        StorePurchaseDAO storePurchaseManager = (StorePurchaseDAO) session.getAttribute("storePurchaseManager");
        if (storePurchaseManager == null) throw new IOException("cartManager is null");

        try {
            storePurchaseManager.createPurchase(storeCartID, salespersonID);
            System.out.println("Purchase successful!");

            request.getRequestDispatcher("/StorePurchaseConfirmation.jsp").forward(request, response);

            // Create order object
        } catch (SQLException e){
            Logger.getLogger(SubmitCartServlet.class.getName()).log(Level.SEVERE, null, e);    
        }

    }
}
