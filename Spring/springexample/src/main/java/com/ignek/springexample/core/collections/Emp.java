package com.ignek.springexample.core.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Emp {
		private String name;
		private List<String> phones;
		private Set<String> addresses;
		private Map<String, String> courses;
		private Properties property;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<String> getPhones() {
			return phones;
		}
		public void setPhones(List<String> phones) {
			this.phones = phones;
		}
		public Set<String> getAddresses() {
			return addresses;
		}
		public void setAddresses(Set<String> addresses) {
			this.addresses = addresses;
		}
		public Map<String, String> getCourses() {
			return courses;
		}
		public void setCourses(Map<String, String> courses) {
			this.courses = courses;
		}
		
		public Properties getProperty() {
			return property;
		}
		public void setProperty(Properties property) {
			this.property = property;
		}
		@Override
		public String toString() {
			return "Emp [name=" + name + ", phones=" + phones + ", addresses=" + addresses + ", courses=" + courses
					+ ", property=" + property + "]";
		}
		public Emp(String name, List<String> phones, Set<String> addresses, Map<String, String> courses,
				Properties property) {
			super();
			this.name = name;
			this.phones = phones;
			this.addresses = addresses;
			this.courses = courses;
			this.property = property;
		}
		public Emp() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		
	
}
