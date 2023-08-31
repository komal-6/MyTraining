package com.ignek.crud.user.dao;

import com.ignek.crud.servlet.*;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ignek.crud.db.connection.*;

public class SelectData {
	public static ResultSet rs;

	public static void fetchAllDataForTable() {
		try {
			DBConnection.getDbConnection();
			String query = "SELECT * FROM CRUD_data";
			Statement stmt = DBConnection.con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fetchData(int id) {
		try {
			DBConnection.getDbConnection();
			String query = "SELECT * FROM CRUD_data WHERE id='"+id+"'";
			Statement stmt = DBConnection.con.createStatement();
			rs = stmt.executeQuery(query);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
