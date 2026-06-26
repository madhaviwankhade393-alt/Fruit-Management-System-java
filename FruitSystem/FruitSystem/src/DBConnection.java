package com.acc.db;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	public static Connection getDBConnection() 
	{ 
Connection con=null; 
	try { 
Class.forName("com.mysql.cj.jdbc.Driver"); /*Driver Registration   */
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false","root","300805");/* Create connection*/
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	} catch(SQLException e) {
			e.printStackTrace();
		}
return con;
} 
}
