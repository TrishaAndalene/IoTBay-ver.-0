package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.StoreCartItem;

public class StorePurchaseItemsDAO {
   private Statement st;
private Connection conn;
   
public StorePurchaseItemsDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}

public void updateStock(int cartID, String upc, String symbol) throws SQLException {  
        //code for add-operation 
        String pos = "+";
        String remove = "remove";
        String sql;
        System.out.println(cartID + ": " + upc + "; " + symbol);
        if (symbol.equals(pos)){
            sql = "UPDATE" + " StoreCartItems SET quantity = quantity + 1 WHERE upc = '" + upc + "' AND cartID = " + cartID ;
        } else if (symbol.equals(remove)) {
            sql = "DELETE" + " FROM StoreCartItems WHERE upc = '" + upc + "' AND cartID = " + cartID ;
        } else {
            sql = "UPDATE" + " StoreCartItems SET quantity = quantity - 1 WHERE upc = '" + upc + "' AND cartID = " + cartID ;
        }      
        st.executeUpdate(sql);
        System.out.println(sql);
    }



public List<StoreCartItem> getCartItems(int cartID) throws SQLException{
        List<StoreCartItem> cartItemsList = new ArrayList<>();
        String update = "DELETE" + " FROM StoreCartItems WHERE quantity <= 0";
        st.executeUpdate(update);

        String query = "SELECT" + " * FROM StoreCartItems WHERE cartID =" + cartID;
        ResultSet result = st.executeQuery(query);
        while (result.next()){
            int itemID = result.getInt("cartItemID");
            String upc = result.getString("upc");
            int quantity = result.getInt("quantity");
            StoreCartItem p = new StoreCartItem(itemID, cartID, upc, quantity);
                cartItemsList.add(p);
            System.out.println("Total products loaded: " + cartItemsList.size());}

        return cartItemsList;   
    }
}
