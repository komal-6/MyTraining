package com.ignek.Jpademo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
		@Id
		private int sid;
		private String sname;
		private String technology;
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getTechnology() {
			return technology;
		}
		public void setTechnology(String technology) {
			this.technology = technology;
		}
		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + ", technology=" + technology + "]";
		}
}
