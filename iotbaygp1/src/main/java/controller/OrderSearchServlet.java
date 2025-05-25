package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Order;

@WebServlet("/OrderSearchServlet")
public class OrderSearchServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        //retrieve the current session
        HttpSession session = request.getSession();

        //retrive the search query for the Servlet
        String search = request.getParameter("searchQuery");

    
        //retrieve the manager instance from session      
        OrderDAO orderManager = (OrderDAO) session.getAttribute("orderManager");
        if (orderManager == null) throw new IOException("DB manager not found");

        // main process (CustomerID is not used due to everyone can search for an order)
        System.out.println("Search received: " + search);
        ArrayList<Order> orderList = new ArrayList<>();
            try {
                if (search != null){

                    Order o = orderManager.getOrder(search);
                    orderList.add(o);
                    request.setAttribute("orderLists", orderList);

                    request.getRequestDispatcher("ViewOrderServlet").forward(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(StockSearchServlet.class.getName()).log(Level.SEVERE, null, ex);  
            }
        }
    }
