package com.example.departmentservicesimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import com.example.departmentrepository.DepartmentRepository;
import com.example.departmentservices.DepartmentServices;
import com.example.model.Department;
import com.example.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DepartmentServicesImpl implements DepartmentServices{

	@Autowired
	public DepartmentRepository departmentRepository;
	
	@Autowired
	public RestTemplate restTemplate;


	private Logger logger = LoggerFactory.getLogger(DepartmentServicesImpl.class);
	

	@Override
	public Department saveDepartment(Department department) {
		Department saveDepartment = departmentRepository.save(department);
		List<User> users = department.getUsers();
		if(users!=null && !users.isEmpty()) {
			for(User user: users) {
				User userResponse = restTemplate.postForObject("http://localhost:8081/users/saveuser", user , User.class);
			}
		}
		return saveDepartment;
	}
	

	@Override
	public Department getDepartmentById(int dept_id) {
		Department department = departmentRepository.findById(dept_id).get();
		
		//Get user for above Department
		ResponseEntity<User> userResponse = restTemplate.getForEntity("http://localhost:8081/users/getuser/"+ dept_id , User.class);
		if(userResponse.getStatusCode() == HttpStatus.OK) {
			User userBody = userResponse.getBody();
			List<User> userList = Arrays.asList(userBody);
			department.setUsers(userList);
		}
		else {
			logger.error("Error fetching id: {}",dept_id);
		}

		return department;
	}
	

	@Override
	public Department updateDepartment(Department department) {
		Department department2 = departmentRepository.save(department);
		
		List<User> users = department.getUsers();
		
		if(users!=null && !users.isEmpty()) {
			for(User user:users) {
				restTemplate.put("http://localhost:8081/users/updateuser", users, User.class);
			}
		}
		return department2;
	}

	@Override
	public Department deleteDepartment(int dept_id) {
	    Department department = departmentRepository.findById(dept_id).get();
	    List<User> users = department.getUsers();
		
		if(users!=null && !users.isEmpty()) {
			for(User user:users) {
				restTemplate.put("http://localhost:8081/users/deleteuser" + dept_id, users, User.class);
			}
		}
	    departmentRepository.deleteById(dept_id);
		return department;
		
	}


	@Override
	public List<Department> getDepartments() {
		List<Department> department = (List<Department>) departmentRepository.findAll();
		
		Department department2 = new Department();
		 List<User> users = department2.getUsers();
			
			if(users!=null && !users.isEmpty()) {
				for(User user:users) {
				  restTemplate.getForObject("http://localhost:8081/users/getusers", User.class);
				}	
			}
		return (List<Department>) department;
	}
}
