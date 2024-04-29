package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.User;
import com.example.userservice.servicesimpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/saveuser")
	private ResponseEntity<User> saveUser(@RequestBody User user){
		User users = userServiceImpl.saveUser(user);
		return new ResponseEntity<User>(users, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getuser/{userId}")
	private ResponseEntity<User> getUserById(@PathVariable("userId") int userId){
		User user = userServiceImpl.getUserById(userId);
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/getusers")
	private List<User> getAllUsers(){
		List<User> users = userServiceImpl.getAllUsers();
		return users;
	}
	
	@PutMapping("/updateuser")
	private ResponseEntity<User> updateUser(@RequestBody User user){
		User users = userServiceImpl.saveUser(user);
		return new ResponseEntity<User>(users, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	private String deleteUser(@PathVariable("userId") int userId) {
		User user = userServiceImpl.deleteUser(userId);
		return "Deleted";
	}
}
