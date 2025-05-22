package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.AccessLog;
import model.Customer;

public class CustomerDAO {
    private Connection conn;
    private Statement st;

    public CustomerDAO(Connection conn) throws SQLException{
        this.conn = conn;
        st = conn.createStatement();
    }

    public Customer findCustomer(String email, String password) throws SQLException{

        String query = "SELECT" + " * FROM Customers WHERE email = '" + email + "' AND password = '" + password + "'" ;

        ResultSet rs = st.executeQuery(query);

        if(rs.next()){
            int customerID = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String phoneNum = rs.getString("phoneNum");

            return new Customer(customerID, firstName, lastName, email, phoneNum, password);
        }

        return null;
    }

    public Customer findCustomerbyPh(String phoneNum) throws SQLException{
      String query = "SELECT" + " * FROM Customers WHERE phoneNum = '" + phoneNum + "'";

      ResultSet rs = st.executeQuery(query);

        if(rs.next()){
            int id = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            String password = rs.getString("password");

            return new Customer(id, firstName, lastName, phoneNum, email, password);
      }

      return null;
  }

    public int getCustomerID(String email) throws SQLException {
        String query = "SELECT" + " id FROM Customers WHERE email = '" + email  + "' ";
        //find the user ID from the db
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs.getInt("id");
        } else {
            throw new SQLException("No customer under email: " + email );
        }
    }

    public int addCustomer(Customer customer) throws SQLException{
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String email = customer.getEmail();
        String phoneNum = customer.getPhoneNum();
        String password = customer.getPassword();

        String query = "INSERT" + " INTO Customers (firstName, lastName, email, phoneNum, password) VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNum + "', '" + password + "');";

        st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        System.out.println("Customer Added!");
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("id retrived");
            return rs.getInt("id");
        } else {
            throw new SQLException("Could not get ID.");
        }
        
    }

    public List<Customer> getAllCustomers() throws SQLException{
        List<Customer> customerList = new ArrayList<>();

        String query = "SELECT" + " * FROM Customers";

        ResultSet result = st.executeQuery(query);

        while (result.next()){
          int id= result.getInt("id");
          String firstName = result.getString("firstName");
          String lastName = result.getString("lastName");
          String phoneNum = result.getString("phoneNum");
          String email = result.getString("email");
          String password = result.getString("password");
            

            Customer customer = new Customer(id, firstName, lastName, email, phoneNum, password);
            customerList.add(customer);
            System.out.println("Total customers loaded: " + customerList.size());
        }

        return customerList;
    }

        public int updateCustomer(int id, String firstName, String lastName, String email, String phoneNum, String password) throws SQLException{
        String query = "UPDATE Customers SET firstName='"+firstName+"', lastName='"+lastName+"', email='"+email+"', phoneNum='"+phoneNum+"', password='"+password+"' WHERE id='"+id+"'";

        int success = st.executeUpdate(query);

        return success;
    }

    public int deleteCustomer(Customer customer, String password) throws SQLException{
        int id = customer.getID();

        String query = "DELETE FROM Customers where id='"+id+"'";

        System.out.println("Delete query >>> " + query);

        int success = st.executeUpdate(query);

        return success;
    }

        public int addAccessCustomerLog(Customer customer) throws SQLException{
        int customer_id = customer.getID();
        String email = customer.getEmail();

        String query = "INSERT INTO CustomerAccessLog (customer_id, customer_email, login) VALUES (?, ?, DATETIME('now'))";

        PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, customer_id);
        pst.setString(2, email);

        pst.executeUpdate();
        System.out.println("Customer log add success!");

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            System.out.println("ID retrieved: " + id);
            return id;
        } else {
            throw new SQLException("Could not get ID.");
        }
    }

    public void addAccessCustomerLogout(int logID) throws SQLException{
        String query = "UPDATE CustomerAccessLog SET logout=DATETIME('now') WHERE id='"+logID+"'";

        st.executeUpdate(query);
        System.out.println("success");
    }

    public ArrayList<AccessLog> getAccessLog(String email) throws SQLException{
        ArrayList<AccessLog> accessLogSet = new ArrayList<>();

        String query = "SELECT * FROM CustomerAccessLog WHERE customer_email='"+email+"'";

        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            int accessID = rs.getInt("id");
            int customerID = rs.getInt("customer_id");
            String customerEmail = rs.getString("customer_email");
            Timestamp loginTime = rs.getTimestamp("login");
            Timestamp logoutTime = rs.getTimestamp("logout");

            AccessLog accessLog = new AccessLog(accessID, customerID, customerEmail, loginTime.toLocalDateTime(), logoutTime != null ? logoutTime.toLocalDateTime() : null);
            
            accessLogSet.add(accessLog);
        }

        rs.close();

        return accessLogSet;
    }
}
