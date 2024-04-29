package com.example.departmentservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.repo.DepartmentRepo;
import com.example.departmentservice.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public Department getDepartmentById(int dept_id) {
		return departmentRepo.findById(dept_id).get();
	}

	@Override
	public List<Department> getDepartments() {
		return departmentRepo.findAll();
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public Department deleteDepartment(int dept_id) {
		departmentRepo.deleteById(dept_id);
		return null;
	}

}
