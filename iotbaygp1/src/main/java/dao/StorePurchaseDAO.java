package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StorePurchaseDAO {
    private Statement st;
    private Connection conn;
   
public StorePurchaseDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}


public int createPurchase(int cartID) throws SQLException {
    String q1 = "INSERT" + " INTO StorePurchase (cartID) VALUES (" + cartID + ")";
    st.executeUpdate(q1);

    String q3 = "SELECT" +" last_insert_rowid() AS cartID";
    ResultSet rs2 = st.executeQuery(q3);
    if (rs2.next()) {
        return rs2.getInt("cartID"); // returns generated cart ID
    } else {
        throw new SQLException("Failed to create cart.");
    }
    }   

    public int getPurchasesByFilter(String filter){
        return 3;

    }

    }


