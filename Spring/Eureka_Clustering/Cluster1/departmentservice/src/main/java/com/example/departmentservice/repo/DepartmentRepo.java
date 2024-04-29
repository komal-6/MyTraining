package com.example.departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentservice.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
