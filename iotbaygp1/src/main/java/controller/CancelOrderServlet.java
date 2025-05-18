package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CartItemsDAO;
import dao.OrderDAO;
import dao.OrderItemsDAO;
import dao.CartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Order;

@WebServlet("/CancelOrderServlet")
public class CancelOrderServlet extends HttpServlet {

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
                    orderManager.cancelOrder(orderID);
                    System.out.println("order cancelled");

                    ArrayList<String> orderCodes = orderManager.getOrders(customerID);
                    ArrayList<Order> orderList = new ArrayList<>();
                    for (String s : orderCodes){
                        orderList.add(orderManager.getOrder(s));
                    }

                    request.setAttribute("orderLists", orderList);
                }
                
            } catch (SQLException ex) {           
                Logger.getLogger(RemoveProductServlet.class.getName()).log(Level.SEVERE, null, ex);    
            }
        
            response.sendRedirect("ViewOrderServlet");

            }
    }