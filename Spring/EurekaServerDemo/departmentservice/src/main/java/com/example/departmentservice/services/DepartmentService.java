package com.example.departmentservice.services;

import java.util.List;

import com.example.departmentservice.model.Department;

public interface DepartmentService {
	Department saveDepartment(Department department);
	Department getDepartmentById(int dept_id);
	List<Department> getDepartments();
	Department updateDepartment(Department department);
	Department deleteDepartment(int dept_id);
}
