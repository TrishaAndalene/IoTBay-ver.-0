package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categories;
import model.Product;

public class ProductDAO {

private Statement st;
private Connection conn;
   
public ProductDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}

    public Product findProduct(String upc) throws SQLException {   
        //setup the select sql query string
        String query = "SELECT * FROM Products WHERE upc = '" + upc  + "' ";

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

            Product p = new Product(productID, productName, price, brand, colour, size, image, quantity, cat, desc);

            return p;

        }
        return null;
    }

    public List<Product> listAllProducts() throws SQLException{
        List<Product> productList = new ArrayList<>();

        String query = "SELECT * FROM Products";

        ResultSet result = st.executeQuery(query);

        while (result.next()){
            String upc = result.getString("upc");
            String name = result.getString("name");
            double price = result.getDouble("price");
            String brand = result.getString("brand");
            String colour = result.getString("colour");
            String size = result.getString("size");
            String image = result.getString("image");
            int quantity = result.getInt("quantity");

            String categoryStr = result.getString("category");
            String description = result.getString("description");

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

            Product p = new Product(upc, name, price, brand, colour, size, image, quantity, cat, description);
            productList.add(p);
            System.out.println("Total products loaded: " + productList.size());
        }

        return productList;
    }


    public void addProduct(Product product) throws SQLException {  
        //code for add-operation 
        String upc = product.getUPC();
        String name = product.getName();
        String brand = product.getBrand();
        Double price = product.getPrice();
        String colour = product.getColour();
        String size = product.getSize();
        String description = product.getDescription();
        int quantity = product.getQuantity();
        String image = product.getImg();
        Categories category = product.getCategories();

        String sql = "INSERT" + " INTO Products (upc, name, price, brand, colour, size, image, quantity, description, category) VALUES ('" + upc + "', '" + name + "', " + price + ", '" + brand + "', '" + colour + "', '" + size + "', '" + image + "', " + quantity + ", '" + description + "', '" + category + "');";

        st.executeUpdate(sql);
        System.out.println("Product Added!");


    }


}
