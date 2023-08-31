package com.ignek.springbootCRUD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private int uid;
	private String uname;
	private String uemail;
	private String ucontact;

	/*
	 * private String[] hobbies; private String gender;
	 */
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUcontact() {
		return ucontact;
	}
	public void setUcontact(String ucontact) {
		this.ucontact = ucontact;
	}

	/*
	 * public String[] getHobbies() { return hobbies; } public void
	 * setHobbies(String[] hobbies) { this.hobbies = hobbies; } public String
	 * getGender() { return gender; } public void setGender(String gender) {
	 * this.gender = gender; }
	 */

	
	
}
