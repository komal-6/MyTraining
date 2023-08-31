package com.example.CRUDwithservice.dao;

import com.example.CRUDwithservice.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee deleteById(int id);
}
