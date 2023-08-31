package com.ignek.Hibernateexample;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Student {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	//@Transient 
	private StudentName sname;
	//@Column(name="student_color")
	private String color;
	  
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public StudentName getSname() {
		return sname;
	}
	public void setSname(StudentName sname) {
		this.sname = sname;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", color=" + color + "]";
	}
	
	
}
