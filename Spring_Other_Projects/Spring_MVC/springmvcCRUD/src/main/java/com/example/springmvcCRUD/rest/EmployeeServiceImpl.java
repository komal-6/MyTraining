package com.example.springmvcCRUD.rest;

import com.example.springmvcCRUD.dao.EmployeeRepository;
import com.example.springmvcCRUD.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo){
        employeeRepository = employeeRepo;
    }
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }
        else {
            throw new RuntimeException("Dis not find employee id "+id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public Employee deleteById(int id) {
        employeeRepository.deleteById(id);
        return null;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
}
