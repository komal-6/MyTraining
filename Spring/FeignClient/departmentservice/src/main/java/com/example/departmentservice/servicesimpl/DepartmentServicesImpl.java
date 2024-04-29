package com.example.departmentservice.servicesimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.departmentservice.external.UserServiceExternal;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.model.User;
import com.example.departmentservice.repo.DepartmentRepository;
import com.example.departmentservice.services.DepartmentServices;

@Service
public class DepartmentServicesImpl implements DepartmentServices{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private UserServiceExternal userServiceExternal;
	
	@Autowired
	private User user;
	
	private Logger logger = LoggerFactory.getLogger(DepartmentServicesImpl.class);

	@Override
	public Department getDepartmentById(int dept_id) {
		Department department = departmentRepository.findById(dept_id).get();
		if(department != null) {
			ResponseEntity<User> responseEntity = userServiceExternal.getUser(dept_id);
			if(responseEntity.getStatusCode().is2xxSuccessful()) {
				User userBody = responseEntity.getBody();
				List<User> userList = Arrays.asList(userBody);
				department.setUsers(userList);
			}
		}
		return department;
	}

	@Override
	public Department saveDepartment(Department department) {
		Department department2 = departmentRepository.save(department);
		if(department2.getUsers() != null) {
			for(User userId: department2.getUsers()) {
				User user = new User();
				user.setDept_id(2);
				user.setEmail("mahesh32@gmail.com");
				user.setUserName("Mahesh");
				User users = departmentRepository.save(user);
				userServiceExternal.saveUser(users);
			}
		}
		
		return department2;
		
	}

}

