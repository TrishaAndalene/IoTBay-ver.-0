package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import model.StoreCart;

public class StoreCartDAO {
    private Statement st;
    private Connection conn;
   
public StoreCartDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
}


  public int getCreateCart(int staffID) throws SQLException {
    String q1 = "SELECT" + " cartID from StoreCarts WHERE staffID = " + staffID;
    ResultSet rs1= st.executeQuery(q1);
    
    if (rs1.next()) {
        return rs1.getInt("cartID"); // returns generated cart ID
    }
    else {
        String q2 = "INSERT" + " INTO StoreCarts (staffId) VALUES (" + staffID + ")";
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

  public int addCustomerToCart (int cartID, int customerID) throws SQLException {
    
    String q1 = "UPDATE" + " StoreCarts SET customerID = " + customerID + " where cartID = " + cartID;

        
    int updatedCustomer = st.executeUpdate(q1);
        
        if (updatedCustomer > 0){
            return customerID;
        } else {
            throw new SQLException("Failed to create cart.");
        }
    }

    }

    /*
    public StoreCart getCart(int cartID) throws SQLException {
    String q1 = "SELECT" + " cartID from StoreCarts WHERE cartID = " + cartID;
    ResultSet rs1= st.executeQuery(q1);
    
    if (rs1.next()) {
        int staffID = rs1.getInt("staffID");
        StoreCart storeCart = new StoreCart(staffID, cartID);
        return storeCart;  
    } else {
            throw new SQLException("Failed to retrieve cart.");
    }   
  }
     */


