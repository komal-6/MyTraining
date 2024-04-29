package com.example.userservice.services;

import java.util.List;

import com.example.userservice.model.User;

public interface UserService {
	User saveUser(User user);
	User getUserById(int user_id);
	List<User> getAllUsers();
	User updateUser(User user);
	User deleteUser(int user_id);
}
