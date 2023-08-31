package com.ignek.ecommerce.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ignek.ecommerce.model.Customer;
import com.ignek.ecommerce.repo.CustomerRepo;
import com.ignek.ecommerce.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public int addCustomer(Customer customer) {
		customerService.addCustomer(customer);
		return customer.getCustomerId();
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/getCustomer/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") int customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@PutMapping("/updateCustomer")
	public Customer saveOrUpdate(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
		return "deleted";
	}
}
