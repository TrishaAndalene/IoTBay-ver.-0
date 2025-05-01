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
import model.Order;
import model.Purchase;
public class TestDB {
    private static Scanner in = new Scanner(System.in);

 

public static void main(String[] args) {

    // establishes connection - need to be in every one if these
try {
    DBConnector connector = new DBConnector();
    Connection conn = connector.openConnection();

    StaffDAO db = new StaffDAO(conn);

    Staff staff = db.findStaff("michael.scott@iotbay.com", "12345");

    System.out.println(staff);

    // Order db
    OrderDAO orderDB = new OrderDAO(conn);

    // Cart trial = new Cart();

    // orderDB.addOrder(new Cart());

    Order order = orderDB.findOrder("Trisha");

    System.out.println(order);

connector.closeConnection();

 

} catch (ClassNotFoundException | SQLException ex) {

Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);

}

}

}
