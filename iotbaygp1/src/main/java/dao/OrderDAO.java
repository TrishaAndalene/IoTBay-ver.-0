package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Order;

public class OrderDAO {

private Statement st;
private Connection conn;
private ProductDAO productManager;
   
// init function
public OrderDAO(Connection conn) throws SQLException {       
    st = conn.createStatement();
    this.conn = conn;
    this.productManager = new ProductDAO(conn);
}

// function to get a specific Order
  public Order getOrder(String orderID) throws SQLException {
    

    String q1 = "SELECT * from Orders WHERE orderID = ?";
    PreparedStatement ps = conn.prepareStatement(q1);
    ps.setString(1, orderID);
    ResultSet rs1 = ps.executeQuery();
    
    if (rs1.next()) {
        String date = rs1.getString("datePlaced");
        double cost = rs1.getDouble("totalCost");
        String status = rs1.getString("status");
        int userID = rs1.getInt("userID");

        Order order = new Order(orderID, userID, date, cost, status);

        System.out.println(order.getStatus());

        return order;
    } 
    return null;
  }

  // function to get all Order code for listing
  public ArrayList<String> getOrders(int userID) throws SQLException{
    String q1 = "SELECT" + " * from Orders WHERE userID = " + userID;
    ResultSet rs1= st.executeQuery(q1);
    
    ArrayList<String> container = new ArrayList<>();

    while (rs1.next()) {
        String orderID = rs1.getString("orderID");
        container.add(orderID);
    } 
    return container;
  }

  // function to get Order code for listing with date filter
  public List<String> getOrdersByDate(int userID, String filter) throws SQLException{
    List<String> orderList = new ArrayList<>();
    System.out.print(filter);

    String query = "SELECT" + " * FROM Orders WHERE datePlaced = '" + filter + "' AND userID = " + userID;
     
    ResultSet result = st.executeQuery(query);

        while (result.next()){
          String orderID = result.getString("orderID");
          orderList.add(orderID);;
        }
        return orderList;
  }

  // function to get Order code for listing with status filter
  public List<String> getOrdersByStatus(int userID, String filter) throws SQLException{
        List<String> orderList = new ArrayList<>();
        if (filter.equalsIgnoreCase("Received")){
          filter = "RECEIVED";
        } else if (filter.equalsIgnoreCase("On delivery")){
          filter = "On delivery";
        } else if (filter.equalsIgnoreCase("Cancelled")){
          filter = "Cancelled";
        } else if (filter.equalsIgnoreCase("Finished")){
          filter = "Finished";
        } else if (filter.equalsIgnoreCase("Processed")){
          filter = "Processed";
        }
        String query = "SELECT" + " * FROM Orders WHERE status = '" + filter + "' AND userID = " + userID;

        ResultSet result = st.executeQuery(query);

        while (result.next()){
          String orderID = result.getString("orderID");
          orderList.add(orderID);;
        }
        return orderList;
    }

  // function to create an order (Status is automatically received)
  public String createOrder(Integer userID, double cost) throws SQLException{
    String orderID = this.generateRandomStringList(1, 8);
    String query = "INSERT INTO Orders(orderID, userID, datePlaced, totalCost, status) VALUES (?, ?, CURRENT_TIMESTAMP, ?, 'RECEIVED')";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, orderID); 
    ps.setInt(2, userID);  
    ps.setDouble(3, cost);
    ps.executeUpdate();

    return orderID;
  }

  // function to randomise the Ordercode 
  public String generateRandomStringList(int numberOfStrings, int stringLength) {
    List<String> stringList = new ArrayList<>();
    Random random = new Random();
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    String result = "";

    for (int i = 0; i < numberOfStrings; i++) {
        StringBuilder sb = new StringBuilder(stringLength);
        for (int j = 0; j < stringLength; j++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        stringList.add(sb.toString());
    }

    for (int n = 0; n < stringList.size(); n++){
        result += stringList.get(n);
    }

    return result;
  }
  
  // function to delete an specific order
  public void deleteOrder(String orderID) throws SQLException{
    String query = "DELETE FROM Orders where orderID = ?";

    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, orderID);
    ps.executeUpdate();
  }

  // function to update the order status to cancelled
  public void cancelOrder(String orderID) throws SQLException{
    String query = "SELECT status FROM Orders where orderID = ?";

    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, orderID);

    ResultSet rs = ps.executeQuery();

    if (rs.next()){
      String query2 = "UPDATE Orders SET status = 'Cancelled' WHERE orderID = ?";

      PreparedStatement ps2 = conn.prepareStatement(query2);
      ps2.setString(1, orderID);

      ps2.executeUpdate();
    }

  }

}
