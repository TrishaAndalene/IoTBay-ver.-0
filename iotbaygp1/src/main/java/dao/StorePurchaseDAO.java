package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.StorePurchase;



public class StorePurchaseDAO {
    private Statement st;
    private Connection conn;
   
public StorePurchaseDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}


public void createPurchase(int cartID, int salespersonID) throws SQLException {
    try {
    String q1 = "INSERT" + " INTO StorePurchases (salespersonID, purchaseDate) VALUES ( " + salespersonID + ", CURRENT_TIMESTAMP)";
    st.executeUpdate(q1);
    ResultSet rs = st.executeQuery("SELECT" + " last_insert_rowid()");
    int purchaseID = rs.next() ? rs.getInt(1) : 0;

    st.executeUpdate("INSERT" + " INTO StorePurchaseItems (purchaseID, upc, quantity) " + "SELECT" + " " + purchaseID + ", upc, quantity FROM StoreCartItems WHERE cartID = " + cartID);
    
    st.executeUpdate("DELETE" + " FROM StoreCartItems WHERE cartID = " + cartID);
    st.executeUpdate("DELETE" + " FROM StoreCarts WHERE cartID = " + cartID);
    
} catch (SQLException e) {
        throw new SQLException("Failed to create cart.");
    }

    } 

    public List<StorePurchase> getPurchasesByFilter(String filter){

        List<StorePurchase> storePurchaseList = new ArrayList<>();

        return storePurchaseList;


        /* 
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
        */

    }

    }


