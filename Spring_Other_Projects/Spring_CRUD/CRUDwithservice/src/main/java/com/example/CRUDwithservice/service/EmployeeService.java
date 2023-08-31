package com.example.CRUDwithservice.service;

import com.example.CRUDwithservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee deleteById(int id);
}
