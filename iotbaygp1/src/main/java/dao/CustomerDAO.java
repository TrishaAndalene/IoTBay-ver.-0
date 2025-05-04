package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class CustomerDAO {
private Connection conn;
private Statement st;
   
public CustomerDAO(Connection conn) throws SQLException {       
   this.conn = conn;
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public Customer findCustomer(String email, String password) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Customers WHERE email = '" + email + "' AND password = '" + password + "'" ;

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String phoneNum = rs.getString("phoneNum");

        return new Customer(firstName, lastName, email, phoneNum, password);

   }


    return null;
  }

  public Customer findCustomerbyId(int code){
    //setup the select sql query string
    String query = "SELECT * FROM Customers WHERE id = '" + code  + "'";

    //execute this query using the statement field 
    //add the results to a ResultSet 

    try{
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
    
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String phoneNum = rs.getString("phoneNum");

        String email = rs.getString("email");
        String password = rs.getString("password");

        return new Customer(firstName, lastName, email, phoneNum, password);
    }}catch (SQLException s){
        return null;
    }
    return null;
   
  }
}