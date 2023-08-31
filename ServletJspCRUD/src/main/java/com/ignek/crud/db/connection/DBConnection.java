package com.ignek.crud.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con = null;

	public static void getDbConnection()  {
		String URL = "jdbc:mysql://localhost:3306/CRUD_db"; // Connection URL
		String USER = "Komal"; // Connection USER
		String PASS = "Komal@0611"; // Connection PASS

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Define Driver
			con = DriverManager.getConnection(URL, USER, PASS); // Connection with driver class
			if (con == null) {
				System.out.println("Database connection is not successful");
			} else {
				System.out.println("Database connection is successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
