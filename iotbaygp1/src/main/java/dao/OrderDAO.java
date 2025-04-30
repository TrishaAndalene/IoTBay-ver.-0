package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cart;
import model.Order;
import model.Purchase;

import java.util.*;

public class OrderDAO {

private Statement st;
   
public OrderDAO(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public Order findOrder(String name) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Order WHERE name = '" + name  + "' ";

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String customerName = rs.getString("name"); // to get the customer name
        double cost = rs.getDouble("totalCost");
        List<Purchase> orderList = (List<Purchase>) rs.getArray("orderList");

        return null;

   }


    return null;
  }



//Add a user-data into the database   
public void addOrder(Cart cart) throws SQLException {                   //code for add-operation       
  st.executeUpdate("sql query");   

}
}

