package com.ignek.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignek.ecommerce.model.Address;

@Repository("AddressRepo")
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
