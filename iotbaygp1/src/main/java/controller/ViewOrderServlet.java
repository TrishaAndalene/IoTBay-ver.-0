package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import dao.OrderItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Order;
 
@WebServlet("/ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        //1- retrieve the current session
        HttpSession session = request.getSession();
        String filter = request.getParameter("status");
        OrderItemsDAO orderItemsManager = (OrderItemsDAO) session.getAttribute("orderItemsManager");
        if (orderItemsManager == null) throw new IOException("order items manager not found");

        OrderDAO orderManager = (OrderDAO) session.getAttribute("orderManager");
        if (orderManager == null) throw new IOException("DB order manager is not found");
    
        //3- capture the posted email - check jsp form name to see what parameter name
        Integer customerID = (Integer) session.getAttribute("customerID");  
        if (customerID == null){customerID = 9;}

        @SuppressWarnings("unchecked")
        ArrayList<Order> orderLists = (ArrayList<Order>) request.getAttribute("orderLists");
        ArrayList<Order> finalContainer = new ArrayList<>();
        if (orderLists == null && customerID != 9){
            try {
                ArrayList<String> orderCodes = orderManager.getOrders(customerID);
                ArrayList<Order> orderList = new ArrayList<>();
                for (String s : orderCodes){
                    Order order = orderManager.getOrder(s);
                    if (order != null){
                        orderList.add(order);
                    }
                }
                    finalContainer = orderList;
                } catch (SQLException e) {

                }
        }  else {
            finalContainer = orderLists;
        }

        try{
            if (filter == null || filter.equalsIgnoreCase("All")){
                request.setAttribute("orderLists", finalContainer);
            } else { 
                System.out.println("View order servlet filter: " + filter);  
                ArrayList<Order> filtered = new ArrayList<>(); 
                List<String> orderCodes = orderManager.getOrdersByStatus(customerID, filter);
                for (String s : orderCodes){
                    Order order = orderManager.getOrder(s);
                    if (order != null && customerID != 9){
                        filtered.add(order);
                    }
                }
                request.setAttribute("orderLists", filtered);

        }} catch (SQLException e){

        }

        request.getRequestDispatcher("/ViewOrder.jsp").include(request, response);

}}