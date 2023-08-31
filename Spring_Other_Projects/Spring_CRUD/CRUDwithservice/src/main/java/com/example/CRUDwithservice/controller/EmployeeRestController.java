package com.example.CRUDwithservice.controller;

import com.example.CRUDwithservice.entity.Employee;
import com.example.CRUDwithservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmpById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee not found: "+ id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        Employee saveEmp = employeeService.save(employee);
        return saveEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updateEmp = employeeService.save(employee);
        return updateEmp;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee is not exists "+id);
        }
        employeeService.deleteById(id);
        return "Employee deleted successfully";
    }
}




