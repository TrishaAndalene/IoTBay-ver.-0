package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CartDAO {

private Statement st;
private Connection conn;
   
public CartDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}

  public int getCreateCart(Integer customerID) throws SQLException {
    

    String q1 = "SELECT" + " cartID from Carts WHERE userID = " + customerID;
    ResultSet rs1= st.executeQuery(q1);
    
    if (rs1.next()) {
        return rs1.getInt("cartID"); // returns generated cart ID
    }
    else {
        String q2 = "INSERT" + " INTO Carts (userId) VALUES (" + customerID + ")";
        st.executeUpdate(q2);

        String q3 = "SELECT" +" last_insert_rowid() AS cartID";
        ResultSet rs2 = st.executeQuery(q3);
        if (rs2.next()) {
            return rs2.getInt("cartID"); // returns generated cart ID
        } else {
            throw new SQLException("Failed to create cart.");
        }
    }   
  }

}
