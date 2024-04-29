package com.example.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.User;
import com.example.userservices.servicesimpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}
	
	@GetMapping("/getuser/{dept_id}")
	private ResponseEntity<User> getUser(@PathVariable("dept_id") int dept_id){
		User users = userServiceImpl.getUserById(dept_id);
		return ResponseEntity.ok(users);
	}
	
	@PostMapping("/saveuser")
	private ResponseEntity<User> saveUser(@RequestBody User user){
		User saveUser = userServiceImpl.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
		
	}
	
	
}
