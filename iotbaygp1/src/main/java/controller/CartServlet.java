package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CartDAO;
import dao.DBConnector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Purchase;

 
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    private DBConnector db;
    private Connection conn;
    private CartDAO cartManager;

    @Override //Add the DBConnector, DBManager, Connection instances to the session

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");       

        HttpSession session = request.getSession();  

        int customerID = (int) session.getAttribute("customerID");

        List<Purchase> CartList;
        try {
            cartManager = new CartDAO(conn);
            CartList = cartManager.getList(customerID);
            //export the DB manager to the view-session (JSPs)
            session.setAttribute("cartManager", cartManager);
            request.setAttribute("carts", CartList);
        // Sending to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewCart.jsp");
        dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    } 
    

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}