package com.Kuo_Lin.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/Kuo_Lin_PP5?useSSL=false";
		String user = "root";
		String pass = "0000";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}




