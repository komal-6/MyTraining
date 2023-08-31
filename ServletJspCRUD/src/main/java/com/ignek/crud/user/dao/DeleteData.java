package com.ignek.crud.user.dao;

import com.ignek.crud.user.bean.*;
import com.ignek.crud.db.connection.*;
import com.ignek.crud.servlet.*;
import java.sql.PreparedStatement;

public class DeleteData {
	public static void deleteData(UserBean details) {
		try {
			DBConnection.getDbConnection();
			String query = "DELETE FROM CRUD_data WHERE ID = ?";
			PreparedStatement pstmt = DBConnection.con.prepareStatement(query);
			pstmt.setInt(1, InsertServlet.details.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
