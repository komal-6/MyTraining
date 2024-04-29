package com.example.departmentservice.controller;

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

import com.example.departmentservice.model.Department;
import com.example.departmentservice.serviceimpl.DepartmentServiceImpl;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	@PostMapping("/savedepartment")
	private ResponseEntity<Department> saveDepartment(@RequestBody Department department){
		Department department2 = departmentServiceImpl.saveDepartment(department);
		return new ResponseEntity<Department>(department2, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getdepartment/{dept_id}")
	private ResponseEntity<Department> getDepartmentById(@PathVariable("dept_id") int dept_id){
		Department department =  departmentServiceImpl.getDepartmentById(dept_id);
		return ResponseEntity.ok(department);
		
	}
	
	@GetMapping("/getdepartments")
	private List<Department> getDepartments(){
		List<Department> departments = departmentServiceImpl.getDepartments();
		return departments;
	}
	
	@PutMapping("/updateDepartment")
	private ResponseEntity<Department> updateDepartment(@RequestBody Department department){
		Department department2 = departmentServiceImpl.saveDepartment(department);
		return new ResponseEntity<Department>(department2, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletedepartment/{dept_id}")
	private String deleteDepartment(@PathVariable("dept_id") int dept_id) {
		Department department = departmentServiceImpl.deleteDepartment(dept_id);
		return "Deleted";
	}
}

