package com.example.springrestsecurity.service;

import com.example.springrestsecurity.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
