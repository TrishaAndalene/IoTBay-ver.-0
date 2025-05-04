package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cart;
import model.Categories;
import model.Order;
import model.Product;
import model.Purchase;

import java.util.*;
import java.util.Locale.Category;

public class OrderDAO {

private Statement st;
   
public OrderDAO(Connection conn) throws SQLException {       
   st = conn.createStatement();
}

public Order findOrder(String code) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Orders WHERE code = '" + code  + "' ";

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String customerName = rs.getString("name"); // to get the customer name
        double cost = rs.getDouble("cost");
        String[] orderList = rs.getString("orderList").split(",");

        ArrayList<Purchase> lists = new ArrayList<>();

        // need to add another list of count in database
        for (int i = 0; i < orderList.length; i++){ 
          String name = orderList[i];
          String connectQuery = "SELECT * FROM Products WHERE name = '" + name + "'";

          ResultSet rs2 = st.executeQuery(connectQuery);
          
          Product p = new Product(rs2.getString("upc"), rs2.getString("name"), rs2.getDouble("price"), rs2.getString("brand"), rs2.getString("colour"), rs2.getString("size"), rs2.getString("image"), rs2.getInt("quantity"), Categories.ACTIVITY_TRACKERS);

          lists.add(new Purchase(p, 2));

        }

        Cart placeholder = new Cart();
        placeholder.addItemToCart(lists);

        Order o = new Order(placeholder, code);
        o.setName(customerName);

        return o;

  }
    return null;
  }



//Add a user-data into the database   
public void addOrder(Cart cart) throws SQLException {                   //code for add-operation       
  Order placeholder = new Order(cart, "");
  String sqlQuery = "INSERT INTO Orders (code, name, orderList, cost, status) VALUES ('" +
                  placeholder.getCode()+ "', '" +
                  placeholder.getName() + "', '" +
                  placeholder.getList() + "', '" +
                  placeholder.getCost() + "', '" +
                  placeholder.getStatus() + "')";
  st.executeUpdate(sqlQuery);
}

// Update order status (Order is unable to be deleted -> business rule)
public void updateOrder(String code, int statusCode){
    //setup the select sql query string

    try {
      Order o = this.findOrder(code);
      
      o.updateStatus(statusCode);

      String query = "UPDATE Orders SET status = '" + o.getStatus() + "' WHERE code = '" + code + "'";

      st.executeUpdate(query);

      System.err.println("Here");

    }
    catch (SQLException s){};
  
  }

}

