package com.ignek.crud.user.dao;

import com.ignek.crud.db.connection.DBConnection;

import com.ignek.crud.servlet.*;
import com.ignek.crud.user.bean.*;
import java.sql.PreparedStatement;

public class InsertData {
	public static void insertData(UserBean details) {
		try {
			DBConnection.getDbConnection();

			String query = "INSERT INTO CRUD_data(Name,Email,Phoneno,Hobbies,Gender) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = DBConnection.con.prepareStatement(query);
			pstmt.setString(1, details.getName());
			pstmt.setString(2, details.getEmail());
			pstmt.setString(3, details.getPhoneno());
			String hobby_value = "";
			for (int i = 0; i < InsertServlet.checkboxvalue.length; i++) {
				hobby_value += InsertServlet.checkboxvalue[i] + ",";
				System.out.println(hobby_value);
			}
			pstmt.setString(4, hobby_value);
			pstmt.setString(5, details.getGender());
			pstmt.execute();
			System.out.println("Detail inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
