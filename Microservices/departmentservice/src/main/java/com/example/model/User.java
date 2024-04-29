package com.example.model;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPOJOBuilder
public class User {
	public int userId;
	public String userName;
	public String email;
	public int dept_id;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String email, int dept_id) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.dept_id = dept_id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", dept_id=" + dept_id
				+ ", getUserId()=" + getUserId() + ", getUserName()=" + getUserName() + ", getEmail()=" + getEmail()
				+ ", getDept_id()=" + getDept_id() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
