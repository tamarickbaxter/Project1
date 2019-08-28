package com.java.ers.utility;

import java.sql.*; 

/**
 * Class to provide a Utility to connect with the database. 
 * 
 * @author
 *
 */

public class ConnectionUtil {

	// Database constants: as this is web based application
	// database connection details are hard coded here. 
	//private static final String DB_USER = "System";
	//private static String DB_PASS = "1234";
	//private static String DB_URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
	private static Connection connection;
	
	private static final String DB_URL = "jdbc:oracle:thin:@db0715java.cllcq2zmfq5y.us-east-1.rds.amazonaws.com:1521:orcl";
	private static final String DB_USER = "chinook";
	private static final String DB_PASS = "p4ssw0rd";
	
	/**
	 * Singleton pattern to get the database connection. 
	 * 
	 * @return connection to the database. 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		// only create the database connection if it is closed or not 
		// yet created. 
		if(connection == null || connection.isClosed()) {
			try {
				Class.forName ("oracle.jdbc.OracleDriver");
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
}
