package com.example.springmvcCRUD.rest;

import com.example.springmvcCRUD.entity.Employee;
import com.example.springmvcCRUD.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee deleteById(int id);
}
