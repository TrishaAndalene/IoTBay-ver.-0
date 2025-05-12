package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CartItem;

public class CartItemsDAO {

private Statement st;
private Connection conn;
   
public CartItemsDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}


public void addItemToCart(int cartId, String upc, int quantity) throws SQLException {
    String query = "INSERT" + " INTO CartItems (cartId, upc, quantity) VALUES (" + cartId + ", '" + upc + "', " + quantity + ")";
    st.executeUpdate(query);
}



public List<CartItem> getCartItems(int cartID) throws SQLException{
        List<CartItem> cartItemsList = new ArrayList<>();
        String query = "SELECT" + " * FROM CartItems WHERE CartID =" + cartID;
        ResultSet result = st.executeQuery(query);
        while (result.next()){
            int itemID = result.getInt("cartItemID");
            String upc = result.getString("upc");
            int quantity = result.getInt("quantity");


            CartItem p = new CartItem(itemID, cartID, upc, quantity);
            cartItemsList.add(p);
            System.out.println("Total products loaded: " + cartItemsList.size());
        }

        return cartItemsList;
    
}
}