package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.CartDAO;
import dao.CartItemsDAO;
import dao.CustomerDAO;
import dao.DBConnector;
import dao.OrderDAO;
import dao.OrderItemsDAO;
import dao.PaymentDAO;
import dao.ProductDAO;
import dao.ShipmentDAO;
import dao.StaffDAO;
import dao.StoreCartDAO;
import dao.StoreCartItemsDAO;
import dao.StorePurchaseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

 
@WebServlet("/ConnServlet")
public class ConnServlet extends HttpServlet {

    private DBConnector db;
    private StaffDAO staffManager;
    private ProductDAO productManager;
    private CustomerDAO customerManager;
    private CartDAO cartManager;
    private CartItemsDAO cartItemsManager;
    private StoreCartDAO storeCartManager;
    private StoreCartItemsDAO storeCartItemsManager;
    private OrderDAO orderManager;
    private OrderItemsDAO orderItemsManager;
    private StorePurchaseDAO storePurchaseManager;
    private PaymentDAO paymentManager;
    private ShipmentDAO shipmentManager;
    private Connection conn;
    

    @Override //Create and instance of DBConnector for the deployment session
    public void init() {
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    @Override //Add the DBConnector, DBManager, Connection instances to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");       
        HttpSession session = request.getSession();

        conn = db.openConnection();       
        try {            
            // Adding all of the DAO
            staffManager = new StaffDAO(conn);
            productManager = new ProductDAO(conn);
            customerManager = new CustomerDAO(conn);
            cartManager = new CartDAO(conn);
            cartItemsManager = new CartItemsDAO(conn);
            orderManager = new OrderDAO(conn);
            orderItemsManager = new OrderItemsDAO(conn);
            storePurchaseManager = new StorePurchaseDAO(conn);
            paymentManager = new PaymentDAO(conn);
            shipmentManager = new ShipmentDAO(conn);

            // These are non-essential ones for the store cart/purchases (not part of our assignment features)
            storeCartItemsManager = new StoreCartItemsDAO(conn);
            storeCartManager = new StoreCartDAO(conn);

        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            //export the DB managers to the view-session (JSPs)
            session.setAttribute("staffManager", staffManager);  
            session.setAttribute("productManager", productManager);  
            session.setAttribute("customerManager", customerManager); 
            session.setAttribute("cartManager", cartManager);
            session.setAttribute("cartItemsManager", cartItemsManager);
            session.setAttribute("orderManager", orderManager);
            session.setAttribute("orderItemsManager", orderItemsManager);
            session.setAttribute("paymentManager", paymentManager);
            session.setAttribute("shipmentManager", shipmentManager);
            
            // These are non-essential ones for the store cart/purchases (not part of our assignment features)
            session.setAttribute("storeCartManager", storeCartManager);  
            session.setAttribute("storeCartItemsManager", storeCartItemsManager); 
            session.setAttribute("storePurchaseManager", storePurchaseManager);  
       }   

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   }