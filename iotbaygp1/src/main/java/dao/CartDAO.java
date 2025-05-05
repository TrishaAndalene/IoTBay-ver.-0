package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Cart;
import model.Categories;
import model.Customer;
import model.Product;
import model.Purchase;

import dao.CustomerDAO;

import java.util.*;
import java.util.Locale.Category;

public class CartDAO {

private Statement st;
private Connection conn;
   
public CartDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}

public Cart findCart(String code) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Carts WHERE code = '" + code  + "' ";

    CustomerDAO customDAO = new CustomerDAO(conn);

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        int customer_ID = rs.getInt("customer_id");
        double cost = rs.getDouble("cost");
        String[] orderList = rs.getString("orderList").split(",");
        String[] quantityList = rs.getString("quantityList").split(",");

        ArrayList<Purchase> lists = new ArrayList<>();

        // need to add another list of count in database
        for (int i = 0; i < orderList.length; i++){ 
          String name = orderList[i];
          String connectQuery = "SELECT * FROM Products WHERE name = '" + name + "'";

          ResultSet rs2 = st.executeQuery(connectQuery);
          
          Product p = new Product(rs2.getString("upc"), rs2.getString("name"), rs2.getDouble("price"), rs2.getString("brand"), rs2.getString("colour"), rs2.getString("size"), rs2.getString("image"), rs2.getInt("quantity"), Categories.ACTIVITY_TRACKERS);

          lists.add(new Purchase(p, Integer.parseInt(quantityList[i])));

        }

        Cart placeholder = null;

        if (customer_ID != 0){
            placeholder = new Cart(customDAO.findCustomerbyId(customer_ID), code); 
        } else {
            placeholder = new Cart();
        }

        placeholder.addItemToCart(lists);

        return placeholder;

  }
    return null;
  }

public List<Purchase> listIteminCart(String code) throws SQLException{
  Cart cart = this.findCart(code);
  return cart.getList();
}

// Update order status (Order is unable to be deleted -> business rule)
public void updateOrder(String code, String[] OrderList){
    //setup the select sql query string

    try {
        String query = "UPDATE Carts SET orderList = '" + OrderList + "' WHERE code = '" + code + "'";

        st.executeUpdate(query);

        System.err.println("Here");

    }
    catch (SQLException s){};
  
  }

}
