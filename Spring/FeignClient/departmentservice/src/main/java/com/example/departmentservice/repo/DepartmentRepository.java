package com.example.departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.model.User;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	User save(User user);

}
