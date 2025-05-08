package dao;

import java.sql.Connection;


/** 
* Super class of DAO classes that stores the database information 
*  
*/

public abstract class DB {   

protected String URL = "jdbc:sqlite:/Users/elle/Documents/ISD/IoTBay-ver.-0/iotbaygp1/database/iotbay.db";
protected String driver = "org.sqlite.JDBC"; //connection null-instance to be initialized in sub-classes
protected Connection conn;
}
