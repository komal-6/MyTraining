package com.ignek.SpringBootJPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ignek.SpringBootJPA.dao.Studentdao;
import com.ignek.SpringBootJPA.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	Studentdao dao;
	
	
	 @RequestMapping("/") 
	 public String home() { 
		 return "home.jsp"; 
		 }
	 
	@PostMapping(path="/student",consumes= {"application/json"})
	public Student addstudent(@RequestBody Student student) 
	{
		dao.save(student);
		return student;
	}
	
	@GetMapping(path="/students")
	public List<Student> getstudents() {
		return dao.findAll();
	}
	
	@RequestMapping("/student/{sid}")
	public Optional<Student> getstudent(@PathVariable("sid") int sid) {

		return dao.findById(sid);
	}
	
	@DeleteMapping("/student/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		Student s = dao.getOne(sid);
		dao.delete(s);
		return "deleted";
	}
	
	@PutMapping(path="/student",consumes= {"application/json"})
	public Student saveOrUpdateuser(@RequestBody Student student) 
	{
		dao.save(student);
		return student;
	}
}
 