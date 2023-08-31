package com.example.springmvcCRUD.controller;

import com.example.springmvcCRUD.entity.Employee;
import com.example.springmvcCRUD.rest.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService1){
		employeeService = employeeService1;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {

		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String addFormForAdd(Model model){
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveData(@ModelAttribute("employee") Employee employee){
		employeeService.save(employee);
		return "redirect:/employees/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeID") int id, Model model){
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("employeeID") int id){
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}









