package com.user.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.user.user_service.entity.User;
import com.user.user_service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable("userId") Long userId)  {
		User user = userService.getUser(userId);

		List contacts = restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);	
		user.setContacts(contacts);
		
		return user;
	}
}
