package com.test.springbootsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.springbootsecurity.model.User;

@Service
public class UserService {

	List<User> list = new ArrayList<>();
	
	public UserService() {
		list.add(new User("Komal","Komal","komal0611@gmail.com"));
		list.add(new User("Piya","Piya","piya0611@gmail.com"));
	}
	
	
	public List<User> getAllUsers(){
		return this.list;
	}
	
	public User getUserById(String username) {
		return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
