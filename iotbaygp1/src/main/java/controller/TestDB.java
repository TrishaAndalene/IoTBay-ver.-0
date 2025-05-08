package controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DBConnector;
import dao.OrderDAO;
import dao.StaffDAO;

// Data type import
import model.Staff;
import model.Cart;
import model.Categories;
import model.Order;
import model.Product;
import model.Purchase;
public class TestDB {
    private static Scanner in = new Scanner(System.in);

 

public static void main(String[] args) {

    // establishes connection - need to be in every one if these
try {
    DBConnector connector = new DBConnector();
    Connection conn = connector.openConnection();

    // StaffDAO db = new StaffDAO(conn);

    // Staff staff = db.findStaff("michael.scott@iotbay.com", "12345");

    // System.out.println(staff);

    // Order db
    OrderDAO orderDB = new OrderDAO(conn);

    Order order = orderDB.findOrder("123456789");

    System.out.println(order);

    // Unit testing adding a cart (success)
    // Cart unitC = new Cart();
    // unitC.addItemToCart(new Purchase(new Product("", "", 2, "", "", "", "", 3, Categories.ACTIVITY_TRACKERS), 0));
    // orderDB.addOrder(unitC);

    // Order status update (success)
    orderDB.updateOrder("123456789", 3);
    System.out.println(orderDB.findOrder("123456789"));

connector.closeConnection();

 

} catch (ClassNotFoundException | SQLException ex) {

Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);

}

}

}
