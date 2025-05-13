package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.StoreCartItem;

public class StoreCartItemsDAO {


private Statement st;
private Connection conn;
   
public StoreCartItemsDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}


public void addItemToCart(int cartID, String upc, int quantity) throws SQLException {
    String query = "INSERT" + " INTO StoreCartItems (cartID, upc, quantity) VALUES (" + cartID + ", '" + upc + "', " + quantity + ")";
    st.executeUpdate(query);
}



public List<StoreCartItem> getCartItems(int cartID) throws SQLException{
        List<StoreCartItem> cartItemsList = new ArrayList<>();
        String query = "SELECT" + " * FROM StoreCartItems WHERE cartID =" + cartID;
        ResultSet result = st.executeQuery(query);
        while (result.next()){
            int itemID = result.getInt("cartItemID");
            String upc = result.getString("upc");
            int quantity = result.getInt("quantity");


            StoreCartItem p = new StoreCartItem(itemID, cartID, upc, quantity);
            cartItemsList.add(p);
            System.out.println("Total products loaded: " + cartItemsList.size());
        }

        return cartItemsList;
    
}
}
