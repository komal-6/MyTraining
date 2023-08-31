package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee deleteById(int id);
}
