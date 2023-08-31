package com.ignek.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignek.ecommerce.model.Customer;
import com.ignek.ecommerce.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	//Adding Customer
	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	//GetAll Customers
	public List<Customer> getCustomers(){
		List<Customer> customer = new ArrayList<Customer>();
		customerRepo.findAll().forEach(customers -> customer.add(customers));
		return customer;
	}
	
	//Get Customer findById
	public Customer getCustomerById(int customerId) {
		return customerRepo.findById(customerId).get();
	}
	
	
	//Update Customer
	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	//Delete Customer
	public void deleteCustomer(int customerId) {
		Customer c = customerRepo.getReferenceById(customerId);
		customerRepo.delete(c);
	}
}
