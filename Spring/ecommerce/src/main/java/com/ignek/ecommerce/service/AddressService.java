package com.ignek.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignek.ecommerce.model.Address;
import com.ignek.ecommerce.model.Customer;
import com.ignek.ecommerce.repo.AddressRepo;

@Service
public class AddressService {

	@Autowired
	AddressRepo addressRepo;
	
	
	public void addAdress(Address address) {
		addressRepo.save(address);
	}
	
	//GetAll Address
	public List<Address> getAddresses(){
		List<Address> address = new ArrayList<Address>();
		addressRepo.findAll().forEach(addresses -> address.add(addresses));
		return address;
	}
		
	//Get Address findById
	public Address getAddressById(int addressId) {
		return addressRepo.findById(addressId).get();
	}
		
		
	//Update Address
	public void updateAddress(Address address) {
		addressRepo.save(address);
	}
		
	//Delete Address
	public void deleteAddress(int addressId) {
		Address c = addressRepo.getReferenceById(addressId);
	    addressRepo.delete(c);
	}
}
