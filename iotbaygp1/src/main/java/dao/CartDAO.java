package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;
import model.Purchase;

public class CartDAO {

private Statement st;
private Connection conn;
private ProductDAO productManager;
   
public CartDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
    this.productManager = new ProductDAO(conn);
}

  public int getCreateCart(Integer customerID) throws SQLException {
    String q1 = "SELECT" + " cartID from Carts WHERE userID = " + customerID;
    ResultSet rs1= st.executeQuery(q1); 
    if (rs1.next()) {
        System.out.println("Retrieving cart with customerID " + customerID);
        return rs1.getInt("cartID"); // returns generated cart ID
    }
    else {
        String q2 = "INSERT" + " INTO Carts (userID) VALUES (" + customerID + ")";
        st.executeUpdate(q2);

        String q3 = "SELECT" +" last_insert_rowid() AS cartID";
        ResultSet rs2 = st.executeQuery(q3);
        if (rs2.next()) {
            System.out.println("Creating cart with customerID " + customerID);
            return rs2.getInt("cartID"); // returns generated cart ID
        } else {
            throw new SQLException("Failed to create cart.");
        }
    }   
  }

    public ArrayList<Purchase> getList(Integer customerID) throws SQLException{
        
        int cartCode = this.getCreateCart(customerID);
        ArrayList<Purchase> placeholder = new ArrayList<>();

        String q3 = "SELECT upc FROM CartItems where cartID =" + cartCode;

        ResultSet rs3 = st.executeQuery(q3);
        while (rs3.next()){
            Product item = this.productManager.findProduct(rs3.getString("upc"));
            Purchase p = new Purchase(item, rs3.getInt("quantity"));
            placeholder.add(p);
    }
    return placeholder;
  }

}
