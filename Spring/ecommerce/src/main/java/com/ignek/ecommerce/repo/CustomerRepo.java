package com.ignek.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignek.ecommerce.model.Customer;

@Repository("CustomerRepo")
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
}
