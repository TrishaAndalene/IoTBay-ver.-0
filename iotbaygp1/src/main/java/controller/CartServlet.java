package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DBConnector;
import dao.CartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

 

public class CartServlet extends HttpServlet {

    private DBConnector db;
    private Connection conn;
    private CartDAO cartManager;

    @Override //Create and instance of DBConnector for the deployment session

    public void init() {

        try {
            System.out.println("CartServlet initializing...");
            db = new DBConnector();
            conn = db.openConnection();
            getServletContext().setAttribute("cartManager", cartManager);
            System.out.println("cartManager set in ServletContext");

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }      

    }

    

    @Override //Add the DBConnector, DBManager, Connection instances to the session

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");       

        HttpSession session = request.getSession();

        conn = db.openConnection();       

        try {

            cartManager = new CartDAO(conn);

        } catch (SQLException ex) {

            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

        //export the DB manager to the view-session (JSPs)

        session.setAttribute("cartManager", cartManager);           

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