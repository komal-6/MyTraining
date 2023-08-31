package com.ignek.springbootCRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ignek.springbootCRUD.Userrepo.UserRepo;
import com.ignek.springbootCRUD.model.User;

@RestController
public class UserController {
    @Autowired
    UserRepo repo;
    
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
    
    @PostMapping(path="adduser")
    public String adduser(User user) {
    	repo.save(user);
    	return "index";
    }
	
    @GetMapping(path="/getusers")
	public List<User> getstudents() {
		return (List<User>) repo.findAll();
	}
    
    @GetMapping("/user/{uid}")
	public Optional<User> getstudent(@PathVariable("uid") int uid) {
		return repo.findById(uid);
	}
	
   @DeleteMapping("/user/{uid}")
   public String deleteuser(@PathVariable int uid) {
	   User u = repo.getOne(uid);
	   repo.delete(u);
	   return "deleted";
   }
   @PutMapping(path="/user")
   public User saveOrUpdate(@RequestBody User user) {
	   repo.save(user);
	   return user;
   }

}
