/* package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Categories;
import model.Order;
import model.Product;
import model.Purchase;

public class OrderDAO {

private Statement st;
   
public OrderDAO(Connection conn) throws SQLException {       
   st = conn.createStatement();
}

public Order findOrder(String code) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Orders WHERE code = '" + code  + "' ";

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String customerName = rs.getString("name"); // to get the customer name
        double cost = rs.getDouble("cost");
        String[] orderList = rs.getString("orderList").split(",");
        String[] quantityList = rs.getString("quantityList").split(",");

        ArrayList<Purchase> lists = new ArrayList<>();

        // need to add another list of count in database
        for (int i = 0; i < orderList.length; i++){ 
          String name = orderList[i];
          String connectQuery = "SELECT * FROM Products WHERE name = '" + name + "'";

          ResultSet rs2 = st.executeQuery(connectQuery);
          
          Product p = new Product(rs2.getString("upc"), rs2.getString("name"), rs2.getDouble("price"), rs2.getString("brand"), rs2.getString("colour"), rs2.getString("size"), rs2.getString("image"), rs2.getInt("quantity"), Categories.ACTIVITY_TRACKERS, rs2.getString("description"));

          String rawValue = quantityList[i].replaceAll("\\[|\\]", "").trim();
          lists.add(new Purchase(p, Integer.parseInt(rawValue)));

        }

        Cart placeholder = new Cart();
        placeholder.addItemToCart(lists);

        Order o = new Order(placeholder, code);
        o.setName(customerName);

        return o;

  }
    return null;
  }

  // overloading for staff and the customer
public List<Order> listAllOrders() throws SQLException{
  List<Order> orderList = new ArrayList<>();

  String query = "SELECT * from Orders";

  ResultSet rs = st.executeQuery(query);

  while (rs.next()){
    String code = rs.getString("code");
    String customerName = rs.getString("name"); // to get the customer name
    double cost = rs.getDouble("cost");
    String[] orderLists = rs.getString("orderList").split(",");
    String[] quantityList = rs.getString("quantityList").split(",");

    ArrayList<Purchase> lists = new ArrayList<>();

    // need to add another list of count in database
    for (int i = 0; i < orderLists.length; i++){ 
      String name = orderLists[i];
      String connectQuery = "SELECT * FROM Products WHERE name = '" + name + "'";

      ResultSet rs2 = st.executeQuery(connectQuery);
      
      Product p = new Product(rs2.getString("upc"), rs2.getString("name"), rs2.getDouble("price"), rs2.getString("brand"), rs2.getString("colour"), rs2.getString("size"), rs2.getString("image"), rs2.getInt("quantity"), Categories.ACTIVITY_TRACKERS, rs2.getString("description"));

      String rawValue = quantityList[i].replaceAll("\\[|\\]", "").trim();
      lists.add(new Purchase(p, Integer.parseInt(rawValue)));

    }

    Cart placeholder = new Cart();
    placeholder.addItemToCart(lists);

    Order o = new Order(placeholder, code);
    o.setName(customerName);

    orderList.add(o);
  }
  return orderList;
}

public List<Order> listAllOrders(int customerID) throws SQLException{
  List<Order> orderList = new ArrayList<>();

  String query = "SELECT * FROM Orders WHERE customerID = '" + customerID  + "' ";

  ResultSet rs = st.executeQuery(query);

  while (rs.next()){
    String code = rs.getString("code");
    String customerName = rs.getString("name"); // to get the customer name
    double cost = rs.getDouble("cost");
    String[] orderLists = rs.getString("orderList").split(",");
    String[] quantityList = rs.getString("quantityList").split(",");

    ArrayList<Purchase> lists = new ArrayList<>();

    // need to add another list of count in database
    for (int i = 0; i < orderLists.length; i++){ 
      String name = orderLists[i];
      String connectQuery = "SELECT * FROM Products WHERE name = '" + name + "'";

      ResultSet rs2 = st.executeQuery(connectQuery);
      
      Product p = new Product(rs2.getString("upc"), rs2.getString("name"), rs2.getDouble("price"), rs2.getString("brand"), rs2.getString("colour"), rs2.getString("size"), rs2.getString("image"), rs2.getInt("quantity"), Categories.ACTIVITY_TRACKERS, rs2.getString("description"));

      String rawValue = quantityList[i].replaceAll("\\[|\\]", "").trim();
          lists.add(new Purchase(p, Integer.parseInt(rawValue)));

    }

    Cart placeholder = new Cart();
    placeholder.addItemToCart(lists);

    Order o = new Order(placeholder, code);
    o.setName(customerName);

    orderList.add(o);
  }
  return orderList;
}

//Add a user-data into the database   
public void addOrder(Cart cart) throws SQLException {                   //code for add-operation       
  Order placeholder = new Order(cart, "");
  String sqlQuery = "INSERT INTO Orders (code, name, orderList, cost, status) VALUES ('" +
                  placeholder.getCode()+ "', '" +
                  placeholder.getName() + "', '" +
                  placeholder.getList() + "', '" +
                  placeholder.getCost() + "', '" +
                  placeholder.getStatus() + "')";
  st.executeUpdate(sqlQuery);
}

// Update order status (Order is unable to be deleted -> business rule)
public void updateOrder(String code, int statusCode){
    //setup the select sql query string

    try {
      Order o = this.findOrder(code);
      
      if (o != null){
        o.updateStatus(statusCode);

        String query = "UPDATE Orders SET status = '" + o.getStatus() + "' WHERE code = '" + code + "'";

        st.executeUpdate(query);

        System.out.println(o.getStatus());
      } else {
        System.out.println("Not found");
      }

      System.err.println("Here");

    }
    catch (SQLException s){};
  
  }

}
*/
