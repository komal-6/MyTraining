package com.ignek.crud.user.dao;

import com.ignek.crud.user.bean.*;

import com.ignek.crud.servlet.*;
import com.ignek.crud.db.connection.*;
import java.sql.PreparedStatement;

public class EditData {
	public static void updateData(UserBean details){
		try {
			DBConnection.getDbConnection();
			String query = "UPDATE CRUD_data SET Name=?,Email=?,Phoneno=?,Hobbies=?,Gender=? WHERE ID=?";
			PreparedStatement pstmt = DBConnection.con.prepareStatement(query);
			pstmt.setString(1, InsertServlet.details.getName());
			pstmt.setString(2, InsertServlet.details.getEmail());
			pstmt.setString(3, InsertServlet.details.getPhoneno());
			String hobby_value = "";
			for (int i = 0; i < InsertServlet.checkboxvalue.length; i++) {
				hobby_value += InsertServlet.checkboxvalue[i] + ",";
			}
			pstmt.setString(4, hobby_value);
			pstmt.setString(5, InsertServlet.details.getGender());
			pstmt.setInt(6, InsertServlet.details.getId());
			pstmt.executeUpdate();
			System.out.println("Value updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
