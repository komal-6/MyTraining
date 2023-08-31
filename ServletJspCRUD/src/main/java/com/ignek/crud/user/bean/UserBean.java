package com.ignek.crud.user.bean;

public class UserBean {
	public int id;
	public String name;
	public String email;
	public String phoneno;
	public String[] hobbies;
	public String gender;

	public int getId() // Get Id
	{
		return id;
	}

	public void setId(int id) // set Id{
	{
		this.id = id;
	}

	public String getName() // Get Name
	{
		return name;
	}

	public void setName(String name) // Set Name
	{
		this.name = name;
	}

	public String getEmail() // Get Email
	{
		return email;
	}

	public void setEmail(String email) // Set Email
	{
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) // Get Phoneno
	{
		this.phoneno = phoneno;
	}

	public String[] getHobby() // Get Hobby
	{
		return hobbies;
	}

	public void setHobby(String[] checkboxvalue) // Set Hobby
	{
		this.hobbies = checkboxvalue;
	}

	public String getGender() // Get Gender
	{
		return gender;
	}

	public void setGender(String gender) // Set Gender
	{
		this.gender = gender;
	}
}
