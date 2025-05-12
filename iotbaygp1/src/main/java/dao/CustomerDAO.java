package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}

/*

    public Customer findCustomerbyId(int code) throws SQLException{
        String query = "SELECT * FROM Customers WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, code);

        ResultSet rs = ps.executeQuery(query);

        if(rs.next()){
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String phoneNum = rs.getString("phoneNum");
            String email = rs.getString("email");
            String password = rs.getString("password");

            return new Customer(firstName, lastName, phoneNum, email, password);
        }

        return null;
    }


 */