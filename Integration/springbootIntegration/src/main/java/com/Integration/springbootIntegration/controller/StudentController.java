package com.Integration.springbootIntegration.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Integration.springbootIntegration.model.Student;
import com.Integration.springbootIntegration.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		Student student1 = studentService.addStudent(student);
		return student1;
	}
	
	@GetMapping("/getStudents")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping("/getStudent/{studentId}")
	public Student getStudentById(@PathVariable("studentId") int studentId) {
		return studentService.getStudentById(studentId);
	}
	
	@PutMapping("/updateStudent/{studentId}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("studentId") int studentId) {
		return studentService.saveAndUpdate(studentId, student);
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return "deleted";
	}
}
