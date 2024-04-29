package com.example.departmentservice.external;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.model.User;

@FeignClient(name = "USER-SERVICE", url="http://localhost:8081",path="/users")
public interface UserServiceExternal {
	
	@GetMapping("/getuser/{dept_id}")
	ResponseEntity<User> getUser(@PathVariable("dept_id") int dept_id);
	
//	@PostMapping("/saveuser")
//	ResponseEntity<User> saveUser(@RequestBody User user);
//		
}
 