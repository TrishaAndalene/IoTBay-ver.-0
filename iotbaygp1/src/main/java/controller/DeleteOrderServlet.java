package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.OrderDAO;
import dao.OrderItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {

        @Override   
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
            //1- retrieve the current session
            HttpSession session = request.getSession();

            String orderID = (String) request.getParameter("orderID");
            if (orderID == null) throw new IOException("orderID is null");
            
            OrderItemsDAO orderItemsManager = (OrderItemsDAO) session.getAttribute("orderItemsManager");
            if (orderItemsManager == null) throw new IOException("DB manager not found");

            OrderDAO orderManager = (OrderDAO) session.getAttribute("orderManager");
            if (orderManager == null) throw new IOException("DB order manager is not found");
        
            //3- capture the posted email - check jsp form name to see what parameter name
            Integer customerID = (Integer) session.getAttribute("customerID");  
            if (customerID == null){customerID = 0;};   

         
            try {      
                if (customerID != null){
                    orderItemsManager.removeAllItem(orderID);
                    System.out.println(orderItemsManager.getOrderItems(orderID));

                    orderManager.deleteOrder(orderID);
                    System.out.println("order removed");

                    ArrayList<String> orderCodes = orderManager.getOrders(customerID);
                    request.setAttribute("orderCodes", orderCodes);

                    request.getRequestDispatcher("ViewOrderServlet").forward(request, response);
                }
                
            } catch (SQLException ex) {           
                Logger.getLogger(RemoveProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
            }
            }
    }