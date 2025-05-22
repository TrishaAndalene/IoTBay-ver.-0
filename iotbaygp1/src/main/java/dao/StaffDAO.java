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
import model.Staff;

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
        int staffID = rs.getInt("id");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String phoneNum = rs.getString("phoneNum");

        return new Staff(staffID, firstName, lastName, email, phoneNum, password);

   }
    return null;
  }

  //Find user by email and password in the database   
public Staff findStaffByID(int staffID) throws SQLException {   
    //setup the select sql query string
    String query = "SELECT * FROM Staff WHERE id = " + staffID;

    //execute this query using the statement field 
    //add the results to a ResultSet 
    ResultSet rs = st.executeQuery(query);

   //search the ResultSet for a user using the parameters 
   if (rs.next()){
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String phoneNum = rs.getString("phoneNum");
        String email = rs.getString("email");
        String password = rs.getString("password");

        return new Staff(staffID, firstName, lastName, email, phoneNum, password);
   }
    return null;
  }



public int addStaff(Staff staff) throws SQLException{
        String firstName = staff.getFirstName();
        String lastName = staff.getLastName();
        String email = staff.getEmail();
        String phoneNum = staff.getPhoneNum();
        String password = staff.getPassword();

        String query = "INSERT" + " INTO Staff (firstName, lastName, email, phoneNum, password) VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNum + "', '" + password + "');";

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

public void addUserWithID(int id, String email, String name, String password, String gender, String favcol) throws SQLException {                   //code for add-operation       
  st.executeUpdate("sql query");   

}

  public int updateStaff(int id, String firstName, String lastName, String email, String phoneNum, String password) throws SQLException{
        String query = "UPDATE Staff SET firstName='"+firstName+"', lastName='"+lastName+"', email='"+email+"', phoneNum='"+phoneNum+"', password='"+password+"' WHERE id='"+id+"'";

        int success = st.executeUpdate(query);

        return success;
    }      

public int getStaffID(String email) throws SQLException {
        String query = "SELECT" + " id FROM Staff WHERE email = '" + email  + "' ";
        //find the user ID from the db
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs.getInt("id");
        } else {
            throw new SQLException("No staff under email: " + email );
        }
    }

  public List<Staff> getAllStaff() throws SQLException{
        List<Staff> staffList = new ArrayList<>();

        String query = "SELECT" + " * FROM Staff";

        ResultSet result = st.executeQuery(query);

        while (result.next()){
          int id= result.getInt("id");
          String firstName = result.getString("firstName");
          String lastName = result.getString("lastName");
          String phoneNum = result.getString("phoneNum");
          String email = result.getString("email");
          String password = result.getString("password");
            

            Staff staff = new Staff(id, firstName, lastName, email, phoneNum, password);
            staffList.add(staff);
            System.out.println("Total staff loaded: " + staffList.size());
        }

        return staffList;
    }


    public int deleteStaff(Staff staff, String password) throws SQLException{
        int id = staff.getID();

        String query = "DELETE FROM Staff where id='"+id+"'";

        System.out.println("Delete query >>> " + query);

        int success = st.executeUpdate(query);

        return success;
    }

    public int addAccessStaffLog(Staff staff) throws SQLException{
        int staff_id = staff.getID();
        String email = staff.getEmail();

        String query = "INSERT INTO StaffAccessLog (staff_id, staff_email, login) VALUES (?, ?, DATETIME('now'))";

        PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, staff_id);
        pst.setString(2, email);

        pst.executeUpdate();
        System.out.println("Staff log add success!");

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
        String query = "UPDATE StaffAccessLog SET logout=DATETIME('now') WHERE id='"+logID+"'";

        st.executeUpdate(query);
        System.out.println("success");
    }

    public ArrayList<AccessLog> getAccessLog(String email) throws SQLException{
        ArrayList<AccessLog> accessLogSet = new ArrayList<>();

        String query = "SELECT * FROM StaffAccessLog WHERE staff_email='"+email+"'";

        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            int accessID = rs.getInt("id");
            int staffID = rs.getInt("staff_id");
            String staffEmail = rs.getString("staff_email");
            Timestamp loginTime = rs.getTimestamp("login");
            Timestamp logoutTime = rs.getTimestamp("logout");

            AccessLog accessLog = new AccessLog(accessID, staffID, staffEmail, loginTime.toLocalDateTime(), logoutTime != null ? logoutTime.toLocalDateTime() : null);

            accessLogSet.add(accessLog);
        }

        rs.close();

        return accessLogSet;
    }

 

}
