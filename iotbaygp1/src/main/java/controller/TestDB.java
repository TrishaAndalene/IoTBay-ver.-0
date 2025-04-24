package controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DBConnector;
import dao.StaffDAO;
import model.Staff;

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



connector.closeConnection();

 

} catch (ClassNotFoundException | SQLException ex) {

Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);

}

}

}
