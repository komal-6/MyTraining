package com.example.CRUDwithJPA.service;

import com.example.CRUDwithJPA.entity.Employee;
import com.example.CRUDwithJPA.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee deleteById(int id);
}
