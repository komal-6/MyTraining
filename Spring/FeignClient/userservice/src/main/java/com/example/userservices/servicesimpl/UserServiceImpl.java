package com.example.userservices.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.model.User;
import com.example.userservices.repo.UserRepository;
import com.example.userservices.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserById(int dept_id) {
		return userRepository.findById(dept_id).get();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
