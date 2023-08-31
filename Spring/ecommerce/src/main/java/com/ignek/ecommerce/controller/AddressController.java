package com.ignek.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ignek.ecommerce.model.Address;
import com.ignek.ecommerce.repo.AddressRepo;
import com.ignek.ecommerce.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/addAddress")
	public int addAddress(Address address) {
		addressService.addAdress(address);
		return address.getAddressId();
	}
	
	@GetMapping("/getAddresses")
	public List<Address> getAddresses(){
		return addressService.getAddresses();
	}
	
	@GetMapping("/getAddress/{addressId}")
	public Address getAddress(@PathVariable("addressId") int addressId) {
		return addressService.getAddressById(addressId);
	}
	
	@PutMapping("/updateAddress")
	public Address saveOrUpdate(@RequestBody Address address) {
		addressService.updateAddress(address);
		return address;
	}
	
	@DeleteMapping("/deleteAddress/{addressId}")
	public String deleteAddress(@PathVariable("addressId") int addressId) {
		addressService.deleteAddress(addressId);
		return "deleted";
	}
}
