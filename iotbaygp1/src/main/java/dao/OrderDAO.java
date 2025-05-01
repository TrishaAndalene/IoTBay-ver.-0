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
@SuppressWarnings("unchecked")
public Order findOrder(String code) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Order WHERE code = '" + code  + "' ";

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String customerName = rs.getString("name"); // to get the customer name
        double cost = rs.getDouble("totalCost");
        ArrayList<Purchase> orderList = (ArrayList<Purchase>) rs.getArray("orderList");

        Cart placeholder = new Cart();
        placeholder.addItemToCart(orderList);
        return new Order(placeholder);

  }
    return null;
  }



//Add a user-data into the database   
public void addOrder(Cart cart) throws SQLException {                   //code for add-operation       
  Order placeholder = new Order(cart);
  String sqlQuery = "INSERT placeholder.getCode(), placeholder.getName(), placeholder.getList(), placeholder.getCost(), placeholder.getStatus() INTO Orders values(code, name, orderList, cost, status)";
  st.executeUpdate(sqlQuery);   
}
}

