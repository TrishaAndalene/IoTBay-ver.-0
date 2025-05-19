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


public void createPurchase(int customerID, int cartID, int salespersonID, double totalCost) throws SQLException {
    try {
        String q1 = "INSERT" + " INTO StorePurchases (customerID, salespersonID, purchaseDate, totalCost) VALUES (" + customerID + ", " + salespersonID + ", CURRENT_TIMESTAMP, " + totalCost + ")";
        st.executeUpdate(q1);
        
        ResultSet rs = st.executeQuery("SELECT" + " last_insert_rowid()");
        int purchaseID = rs.next() ? rs.getInt(1) : 0;

        st.executeUpdate("INSERT" + " INTO StorePurchaseItems (purchaseID, upc, quantity) " + "SELECT" + " " + purchaseID + ", upc, quantity FROM StoreCartItems WHERE cartID = " + cartID);

        String q2 = "SELECT" + " * FROM StoreCartItems WHERE cartID = " + cartID;
        ResultSet rs2 = st.executeQuery(q2);
        while (rs2.next()){
            String upc = rs2.getString("upc");
            int qty = rs2.getInt("quantity");
            
            String sql = "UPDATE" + " Products SET quantity = quantity - " + qty + " WHERE upc = '" + upc + "'";
            st.executeUpdate(sql);
            System.out.println(sql);  
        }

        st.executeUpdate("DELETE" + " FROM StoreCartItems WHERE cartID = " + cartID);
        st.executeUpdate("DELETE" + " FROM StoreCarts WHERE cartID = " + cartID);
    
    } catch (SQLException e) {
        throw new SQLException("Failed to create cart.");
    }
    } 

    public List<StorePurchase> getStorePurchases() throws SQLException{

        List<StorePurchase> storePurchaseList = new ArrayList<>();
            String query = "SELECT" + " * FROM StorePurchases";

            ResultSet result = st.executeQuery(query);
            while (result.next()){
            int salespersonID = result.getInt("salespersonID");
            int purchaseID = result.getInt("purchaseID");
            int customerID = result.getInt("customerID");
            String transType = result.getString("transType");


            StorePurchase p = new StorePurchase(salespersonID, purchaseID, customerID, transType);
            storePurchaseList.add(p);
            System.out.println("Total products loaded: " + storePurchaseList.size());
            }    
        return storePurchaseList;
    }


    }


