package com.example1.userservices;

import java.util.List;

import com.example1.model.User;

public interface UserServices {

	User saveUser(User user);
	User getUserById(int dept_id);
	List<User> getAllUsers();
	User updateUser(User user);
	User deleteUser(int user_id);
}
