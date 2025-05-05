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

public class ProductDAO {

private Statement st;
private Connection conn;
   
public ProductDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}

public Product findProduct(String code) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Products WHERE code = '" + code  + "' ";

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String productID = rs.getString("upc");
        String productName = rs.getString("name");
        double price = rs.getDouble("price");
        String brand = rs.getString("brand");
        String colour = rs.getString("colour");
        String size = rs.getString("size");
        String image = rs.getString("image");
        int quantity = rs.getInt("quantity");

        String categoryStr = rs.getString("category");
        String desc = rs.getString("description");

        Categories cat = null;

        if (categoryStr.equalsIgnoreCase("wifi")){
            cat = Categories.WIFI;
        } else if (categoryStr.equalsIgnoreCase("home_security")){
            cat = Categories.HOME_SECURITY;
        } else if (categoryStr.equalsIgnoreCase("activity_trackers")){
            cat = Categories.ACTIVITY_TRACKERS;
        } else if (categoryStr.equalsIgnoreCase("actuator")){
            cat = Categories.ACTUATOR;
        } else if (categoryStr.equalsIgnoreCase("ambient_iot")){
            cat = Categories.AMBIENT_IOT;
        } else if (categoryStr.equalsIgnoreCase("mini_pc")){
            cat = Categories.MINI_PC;
        }

        Product p = new Product(productID, productName, price, brand, colour, size, image, quantity, cat);
        p.setDescription(desc);

        return p;

    }
    return null;
  }

public List<Product> listAllProducts() throws SQLException{
    List<Product> productList = new ArrayList<>();

    String query = "SELECT * FROM Products";

    ResultSet result = st.executeQuery(query);

    while (result.next()){
        String productID = result.getString("upc");
        String productName = result.getString("name");
        double price = result.getDouble("price");
        String brand = result.getString("brand");
        String colour = result.getString("colour");
        String size = result.getString("size");
        String image = result.getString("image");
        int quantity = result.getInt("quantity");

        String categoryStr = result.getString("category");
        String desc = result.getString("description");

        Categories cat = null;

        if (categoryStr.equalsIgnoreCase("wifi")){
            cat = Categories.WIFI;
        } else if (categoryStr.equalsIgnoreCase("home_security")){
            cat = Categories.HOME_SECURITY;
        } else if (categoryStr.equalsIgnoreCase("activity_trackers")){
            cat = Categories.ACTIVITY_TRACKERS;
        } else if (categoryStr.equalsIgnoreCase("actuator")){
            cat = Categories.ACTUATOR;
        } else if (categoryStr.equalsIgnoreCase("ambient_iot")){
            cat = Categories.AMBIENT_IOT;
        } else if (categoryStr.equalsIgnoreCase("mini_pc")){
            cat = Categories.MINI_PC;
        }

        Product p = new Product(productID, productName, price, brand, colour, size, image, quantity, cat);
        p.setDescription(desc);
        productList.add(p);
    }

    return productList;
}

}
