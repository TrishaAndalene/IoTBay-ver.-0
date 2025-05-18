package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.OrderDAO;
import dao.OrderItemsDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Order;
import model.OrderItem;

@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        //1- retrieve the current session
        HttpSession session = request.getSession();

        //3- capture the posted email - check jsp form name to see what parameter name
        String orderID = (String) request.getParameter("orderID");  
        if (orderID == null) throw new IOException("orderID is null");
        
        //5- retrieve the manager instance from session      
        ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");
        if (productManager == null) throw new IOException("DB manager not found");

        OrderItemsDAO orderItemsManager = (OrderItemsDAO) session.getAttribute("orderItemsManager");
        if (orderItemsManager == null) throw new IOException("DB manager not found");

        OrderDAO orderManager = (OrderDAO) session.getAttribute("orderManager");
        if (orderManager == null) throw new IOException("DB order manager is not found");    
    
        try {       
            Order order = orderManager.getOrder(orderID);
            if (order != null){
                List<OrderItem> orderItemsList = orderItemsManager.getOrderItems(orderID);

                request.setAttribute("orderItems", orderItemsList);

                request.setAttribute("order", order);

                System.out.println("Inside OrderDetailsServlet");

                request.getRequestDispatcher("/OrderDetails.jsp").include(request, response);
            } else {
                System.err.println("order is null");
            }

            
        } catch (SQLException ex) {           
            Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }
}}
