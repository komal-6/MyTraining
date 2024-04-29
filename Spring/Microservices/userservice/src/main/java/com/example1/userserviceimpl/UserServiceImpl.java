package com.example1.userserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example1.model.User;
import com.example1.userrepository.UserRepository;
import com.example1.userservices.UserServices;

@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(int dept_id) {
		return userRepository.findById(dept_id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(int user_id) {
		userRepository.deleteById(user_id);
		return null;
	}

	
}
