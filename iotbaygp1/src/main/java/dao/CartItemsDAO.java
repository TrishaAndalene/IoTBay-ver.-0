package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CartItem;
import model.Product;

public class CartItemsDAO {

private Statement st;
private Connection conn;
private final ProductDAO productManager;
   
public CartItemsDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
    this.productManager = new ProductDAO(conn);
}


public void addItemToCart(int cartId, String upc, int quantity) throws SQLException {
    String query = "INSERT" + " INTO CartItems (cartId, upc, quantity) VALUES (" + cartId + ", '" + upc + "', " + quantity + ")";
    st.executeUpdate(query);
    System.out.println("added successfully");
}

public int findCartItem(int cartID, String upc) throws SQLException{
    List<CartItem> container = this.getCartItems(cartID);
    for (CartItem c : container){
        if (c.getUPC().equalsIgnoreCase(upc)){
            return c.getItemId();
        }
    }
    return 0;
}

public List<CartItem> getCartItems(int cartID) throws SQLException{
        List<CartItem> cartItemsList = new ArrayList<>();

        String update = "DELETE" + " FROM CartItems WHERE quantity <= 0";
        st.executeUpdate(update);

        String query = "SELECT" + " * FROM CartItems WHERE CartID =" + cartID;
        ResultSet result = st.executeQuery(query);
        while (result.next()){
            int itemID = result.getInt("cartItemID");
            String upc = result.getString("upc");
            int quantity = result.getInt("quantity");

            Product product = this.productManager.findProduct(upc);

            CartItem p = new CartItem(itemID, cartID, product, quantity);
            cartItemsList.add(p);
            System.out.println("Total products loaded: " + cartItemsList.size());
        }

        return cartItemsList;
    
}

public void updateCartItem(int cartID, int itemID, String upc, int quantity) throws SQLException{
    String query = "UPDATE" + " CartItems SET cartId =" + cartID + ", upc = " + upc + ", quantity =" + quantity + " WHERE cartItemID = " + itemID;
    st.executeUpdate(query);
    System.out.println("update succesfully");
}

public void removeCartItem(int cartID, String upc) throws SQLException{
    String query = "DELETE" + " FROM CartItems WHERE upc = " + upc + " and cartID = " + cartID;
    st.executeUpdate(query);
    System.out.println("remove succesfully");
}

public void removeAllItem(int cartID) throws SQLException{
    String query = "DELETE" + " FROM CartItems WHERE cartID = " + cartID;
    st.executeUpdate(query);
    System.out.println("Cart cleared");
}

public void updateStock(int cartID, String upc, String symbol) throws SQLException {  
        //code for add-operation 
        String plus = "plus";
        String remove = "remove";
        String sql;
        System.out.println(cartID + ": " + upc + "; " + symbol);
        if (symbol.equals(plus)){
            sql = "UPDATE" + " CartItems SET quantity = quantity + 1 WHERE upc = '" + upc + "' AND cartID = " + cartID ;
        } else if (symbol.equals(remove)) {
            sql = "DELETE" + " FROM CartItems WHERE upc = '" + upc + "' AND cartID = " + cartID ;
        } else {
            sql = "UPDATE" + " CartItems SET quantity = quantity - 1 WHERE upc = '" + upc + "' AND cartID = " + cartID ;
        }      
        st.executeUpdate(sql);
        System.out.println(sql);
    }

}