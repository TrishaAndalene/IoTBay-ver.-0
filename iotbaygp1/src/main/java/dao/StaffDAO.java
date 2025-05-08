package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Staff;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class StaffDAO {
private Connection conn;
private Statement st;
   
public StaffDAO(Connection conn) throws SQLException {       
   this.conn = conn;
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public Staff findStaff(String email, String password) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Staff WHERE email = '" + email + "' AND password = '" + password + "'" ;

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String phoneNum = rs.getString("phoneNum");

        return new Staff(firstName, lastName, email, phoneNum, password);

   }
    return null;
  }



//Add a user-data into the database   
public void addUser(String email, String name, String password, String gender, String favcol) throws SQLException {                   //code for add-operation       
  st.executeUpdate("sql query");   

}

//update a user details in the database   
public void updateUser( String email, String name, String password, String gender, String favcol) throws SQLException {       
   //code for update-operation   

}       

//delete a user from the database   
public void deleteUser(String email) throws SQLException{       
   //code for delete-operation   

}


 

}
