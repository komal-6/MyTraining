package com.example1.usercontroller;

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
import com.example1.model.User;
import com.example1.userserviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}

	@PostMapping("/saveuser")
	private ResponseEntity<User> saveUser(@RequestBody User user){
		User saveUser = userServiceImpl.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getuser/{userId}")
	private ResponseEntity<User> getUser(@PathVariable("userId") int userId){
		User users = userServiceImpl.getUserById(userId);
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/getusers")
	private List<User> getAllUsers(){
		List<User> departments = userServiceImpl.getAllUsers();
		return departments;
	}
	
	@PutMapping("/updateuser")
	private ResponseEntity<User> updateUser(@RequestBody User user){
		User user2 = userServiceImpl.updateUser(user);
		return new ResponseEntity<User>(user2, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	private String deleteDepartment(@PathVariable int dept_id) {
		User user = userServiceImpl.deleteUser(dept_id);
		return "Deleted";
		
	}
	
}
