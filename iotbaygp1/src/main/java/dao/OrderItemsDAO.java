package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.OrderItem;
import model.Product;

public class OrderItemsDAO {

private Statement st;
private Connection conn;
private ProductDAO productManager;
   
public OrderItemsDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
    this.productManager = new ProductDAO(conn);
}


public void addItemToOrder(String orderCode, String upcCode, int quantityValue) throws SQLException {
    String query = "INSERT INTO OrderItems(orderID, upc, quantity) VALUES (?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, orderCode);
    ps.setString(2, upcCode);
    ps.setInt(3, quantityValue);
    ps.executeUpdate();
    System.out.println("added successfully");
}

public List<OrderItem> getOrderItems(String orderCode) throws SQLException{
        List<OrderItem> OrderItemsList = new ArrayList<>();
        System.out.println("I am here 3");
        String query = "SELECT * FROM OrderItems WHERE orderID = ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, orderCode);

        System.out.println("here 567");

        ResultSet result = ps.executeQuery();

        System.out.println("here 0998766");

        while (result.next()){
            int itemID = result.getInt("OrderItemID");
            String upc = result.getString("upc");
            int quantity = result.getInt("quantity");

            Product product = this.productManager.findProduct(upc);

            OrderItem p = new OrderItem(itemID, orderCode, product, quantity);
            OrderItemsList.add(p);
            System.out.println("Total products loaded: " + OrderItemsList.size());
        }

        return OrderItemsList;
    
}
public void removeAllItem(String orderID) throws SQLException{
    String query = "DELETE FROM OrderItems WHERE orderID = ? ";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, orderID);
    ps.executeUpdate();
    System.out.println("Order items deleted");
}
}