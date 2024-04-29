package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.departmentservicesimpl.DepartmentServicesImpl;
import com.example.model.Department;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentServicesImpl departmentServicesImpl;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/savedepartment")
	private ResponseEntity<Department> saveDepartement(@RequestBody Department department){
		Department saveDepartment = departmentServicesImpl.saveDepartment(department);
		return new ResponseEntity<Department>(saveDepartment, HttpStatus.CREATED);
	}
	
	//Single Department
	@GetMapping("/getdepartment/{dept_id}")
	private ResponseEntity<Department> 	getDepartmentById(@PathVariable("dept_id") int dept_id){
		Department department = departmentServicesImpl.getDepartmentById(dept_id);
		return ResponseEntity.ok(department);
	}
	
	@GetMapping("/getdepartments")
	private List<Department> getDepartments(){
		List<Department> departments =departmentServicesImpl.getDepartments();
		return departments;
	}
	
	@PutMapping("/updatedepartment")
	private ResponseEntity<Department> updateDepartment(@RequestBody Department department){
		Department department2 = departmentServicesImpl.saveDepartment(department);
		return new ResponseEntity<Department>(department2, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletedepartment/{dept_id}")
	private String deleteDepartment(@PathVariable int dept_id) {
		Department department = departmentServicesImpl.deleteDepartment(dept_id);
		return "Deleted";
		
	}
}
