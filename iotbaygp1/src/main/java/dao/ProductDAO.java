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

    public List<Product> getProductsByCat(String filter) throws SQLException{
        List<Product> productList = new ArrayList<>();

        String query = "SELECT" + " * FROM Products WHERE category = '" + filter + "'";

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
            if (categoryStr != null) {
            try {
                cat = Categories.valueOf(categoryStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Unknown category: " + categoryStr);
            }
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


        String sql = "INSERT" + " INTO Products (upc, name, price, brand, colour, size, image, quantity, category, description) VALUES ('" + upc + "', '" + name + "', " + price + ", '" + brand + "', '" + colour + "', '" + size + "', '" + image + "', " + quantity + ", '" + category + "', '" + description + "');";

        st.executeUpdate(sql);
        System.out.println("Product Added!");


    }

    public void updateProduct(String field, String upc, String value) throws SQLException {  
        //code for add-operation 
        List<String> strings = List.of("name", "brand", "colour", "size", "description", "category", "image");
        
        String sql;
        if (strings.contains(field)){
            sql = "UPDATE" + " Products SET " + field  + " = '" + value + "' WHERE upc = '" + upc + "'";
    }
        else {
            sql = "UPDATE" + " Products SET " + field  + " = " + value + " WHERE upc = '" + upc + "'";
        }
        st.executeUpdate(sql);
        System.out.println(sql);
    }

    public void updateStock(String upc, int qty) throws SQLException {  
        //code for add-operation 
        
        String sql = "UPDATE" + " Products SET quantity = quantity + " + qty + " WHERE upc = '" + upc + "'";
        
        st.executeUpdate(sql);
        System.out.println(sql);
    }

    public void updateStockAfterOrder(String upc, int qty) throws SQLException{
        String sql = "UPDATE" + " Products SET quantity = " + qty + " WHERE upc = '" + upc + "'";
        
        st.executeUpdate(sql);
        System.out.println(sql);
    }

    public void removeProduct(String upc) throws SQLException {  
        //code for add-operation 
        
        String sql = "DELETE" + " from Products WHERE upc = '" + upc + "'";
        
        st.executeUpdate(sql);
        System.out.println(sql);
    }

    public List<Product> productSearch(String search) throws SQLException{
        List<Product> productList = new ArrayList<>();

        String query = "SELECT" + " * FROM Products WHERE name LIKE '%" + search + "%' OR category LIKE '%" + search + "%' ";

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
            if (categoryStr != null) {
            try {
                cat = Categories.valueOf(categoryStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Unknown category: " + categoryStr);
            }
        }
            Product p = new Product(upc, name, price, brand, colour, size, image, quantity, cat, description);
            productList.add(p);
            System.out.println("Total products loaded: " + productList.size());
        }
        return productList;
    }


}
