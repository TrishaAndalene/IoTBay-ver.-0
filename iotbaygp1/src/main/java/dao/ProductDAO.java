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
        // Sets up the SQL query string
        String query = "SELECT * FROM Products WHERE upc = '" + upc  + "' ";

        //execute this query using the statement and create a result set from the search
        ResultSet rs = st.executeQuery(query);

    //retrieve the data from the ResultSet using the parameters of column headings
    if (rs.next()){
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

            // return the found product
            Product p = new Product(upc, productName, price, brand, colour, size, image, quantity, cat, desc);
            return p;
        }
        return null;
    }

    public List<Product> listAllProducts() throws SQLException{
        // Creates list for products to be added to
        List<Product> productList = new ArrayList<>();

        // Sets up the SQL query string
        String query = "SELECT * FROM Products";

        //execute this query using the statement and create a result set from the search
        ResultSet result = st.executeQuery(query);

        //retrieve the data from the ResultSet using the parameters of column headings for each item
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

            // create a product from the RS and adds it to the list to return
            Product p = new Product(upc, name, price, brand, colour, size, image, quantity, cat, description);
            productList.add(p);
        }

        return productList;
    }

    public List<Product> getProductsByCat(String filter) throws SQLException{
        // Creates list for products to be added to       
        List<Product> productList = new ArrayList<>();
        // Sets up the SQL query string to include the filter
        String query = "SELECT" + " * FROM Products WHERE category = '" + filter + "'";
        //execute this query using the statement and create a result set from the search
        ResultSet result = st.executeQuery(query);

        //retrieve the data from the ResultSet using the parameters of column headings for each item
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
            // create a product from the RS and adds it to the list to return
            Product p = new Product(upc, name, price, brand, colour, size, image, quantity, cat, description);
            productList.add(p);
        }
        return productList;
    }


    public void addProduct(Product product) throws SQLException {  
        //Retrieves each value from the input Product
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

        // set up SQL statement with input values
        String sql = "INSERT" + " INTO Products (upc, name, price, brand, colour, size, image, quantity, category, description) VALUES ('" + upc + "', '" + name + "', " + price + ", '" + brand + "', '" + colour + "', '" + size + "', '" + image + "', " + quantity + ", '" + category + "', '" + description + "');";

        // adds product to the DB
        st.executeUpdate(sql);
    }

    public void updateProduct(String field, String upc, String value) throws SQLException {  
        // checks if the field passed in would contain a String value
        List<String> strings = List.of("name", "brand", "colour", "size", "description", "category", "image");
    
  
        String sql;
        // if it were a String value
        if (strings.contains(field)){
            sql = "UPDATE" + " Products SET " + field  + " = '" + value + "' WHERE upc = '" + upc + "'";
    }
        else {
        // if it were an int/double
            sql = "UPDATE" + " Products SET " + field  + " = " + value + " WHERE upc = '" + upc + "'";
        }
        // updates the Product data in the DB
        st.executeUpdate(sql);

    }

    public void updateStock(String upc, int qty) throws SQLException {  
        //Creates SQL string for updating the product qty
        String sql = "UPDATE" + " Products SET quantity = quantity + " + qty + " WHERE upc = '" + upc + "'";
        
        st.executeUpdate(sql);
    }

    public void stockPurchase(String upc, int qty) throws SQLException {  
        //Creates SQL string for updating the product qty after purchase
        String sql = "UPDATE" + " Products SET quantity = quantity - " + qty + " WHERE upc = '" + upc + "'";
        
        st.executeUpdate(sql);
    }

    public void updateStockAfterOrder(String upc, int qty) throws SQLException{
        //Creates SQL string for updating the product qty after order
        String sql = "UPDATE" + " Products SET quantity = " + qty + " WHERE upc = '" + upc + "'";
        
        st.executeUpdate(sql);
    }

    public void removeProduct(String upc) throws SQLException {  
        //Creates SQL string for removing a product from the DB
        String sql = "DELETE" + " from Products WHERE upc = '" + upc + "'";
        
        st.executeUpdate(sql);
    }

    public List<Product> productSearch(String search) throws SQLException{
        // Creates list for relevant products to be added to
        List<Product> productList = new ArrayList<>();
        // Sets up the SQL string to retrieve products that include the search parameter in their name or category
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
        // create a product from the RS and adds it to the list to return
            Product p = new Product(upc, name, price, brand, colour, size, image, quantity, cat, description);
            productList.add(p);
            System.out.println("Total products loaded: " + productList.size());
        }
        return productList;
    }
}
