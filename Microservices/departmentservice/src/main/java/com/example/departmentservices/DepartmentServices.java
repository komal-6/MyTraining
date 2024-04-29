package com.example.departmentservices;

import java.util.List;

import com.example.model.Department;

public interface DepartmentServices {

	Department saveDepartment(Department department);
	Department getDepartmentById(int dept_id);
	Department updateDepartment(Department department);
	Department deleteDepartment(int dept_id);
	List<Department> getDepartments();
}
