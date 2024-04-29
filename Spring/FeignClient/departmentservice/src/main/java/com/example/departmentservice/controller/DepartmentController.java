package com.example.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.servicesimpl.DepartmentServicesImpl;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentServicesImpl departmentServicesImpl;
	
	@GetMapping("/getdepartment/{dept_id}")
	private ResponseEntity<Department> 	getDepartmentById(@PathVariable("dept_id") int dept_id){
		Department department = departmentServicesImpl.getDepartmentById(dept_id);
		return ResponseEntity.ok(department);
	}
	
//	@PostMapping("/savedepartment")
//	private ResponseEntity<Department> saveDepartment(@RequestBody Department department){
//		Department departmentEntity = departmentServicesImpl.saveDepartment(department);
//		return new ResponseEntity<Department>(departmentEntity, HttpStatus.CREATED);
//		
//	}
}
