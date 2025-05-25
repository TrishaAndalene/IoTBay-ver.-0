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
        //retrieve the current session
        HttpSession session = request.getSession();

        // retrieve the possible feature
        String filter = request.getParameter("status");

        //retrieve all relevant objectManager for the Servlet
        OrderItemsDAO orderItemsManager = (OrderItemsDAO) session.getAttribute("orderItemsManager");
        if (orderItemsManager == null) throw new IOException("order items manager not found");

        OrderDAO orderManager = (OrderDAO) session.getAttribute("orderManager");
        if (orderManager == null) throw new IOException("DB order manager is not found");
    
        Integer customerID = (Integer) session.getAttribute("customerID");  
        if (customerID == null){customerID = 9;} // <- is a set up for anonymous user

        @SuppressWarnings("unchecked")
        ArrayList<Order> orderLists = (ArrayList<Order>) request.getAttribute("orderLists"); // this is used to obtain new OrderLists in a case of cancelling or removing an order
        ArrayList<Order> finalContainer = new ArrayList<>(); 

        // retrieve the second filter option
        String filterDate = request.getParameter("filterDate");
        System.out.println("filter date is" + filterDate);

        // a conditioning to make that anonymous user can not see the other history of a collective anonymous user
        if (orderLists == null && customerID != 9){
            try {
                ArrayList<String> orderCodes = orderManager.getOrders(customerID);
                ArrayList<Order> orderList = new ArrayList<>();
                for (String s : orderCodes){
                    Order order = orderManager.getOrder(s);
                    // deployement of the first filter function (by date)
                    String time = order.getDate();
                    String dateOnly = time.substring(0, 10);
                    System.out.println(dateOnly);
                    if (filterDate == null || filterDate.isEmpty() || filterDate.equalsIgnoreCase(dateOnly)){
                        if (order != null){
                            orderList.add(order);
                        }
                    }
                }
                    finalContainer = orderList;
                } catch (SQLException e) {

                }
        }  else {
            finalContainer = orderLists;
        }

        try{
            // deployment of a second filtering option (status) -> however, filter can only be deployed once, so if date is chosen then there is no status filter
            if (filter == null || filter.equalsIgnoreCase("All")){
                request.setAttribute("orderLists", finalContainer);
            } else { 
                System.out.println("View order servlet filter: " + filter);  
                ArrayList<Order> filtered = new ArrayList<>(); 
                if (customerID != 9){
                List<String> orderCodes = orderManager.getOrdersByStatus(customerID, filter);
                for (String s : orderCodes){
                    Order order = orderManager.getOrder(s);
                    if (order != null){
                        filtered.add(order);
                    }
                }
                
            }
            request.setAttribute("orderLists", filtered);

        }} catch (SQLException e){

        }

        request.getRequestDispatcher("/ViewOrder.jsp").include(request, response);

}}