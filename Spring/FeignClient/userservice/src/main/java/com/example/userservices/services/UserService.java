package com.example.userservices.services;

import com.example.userservice.model.User;

public interface UserService {
	User getUserById(int dept_id);
	User saveUser(User user);
}
