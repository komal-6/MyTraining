package com.contact.contact_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.contact_service.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{

	
	//Fake List of contacts
	List<Contact> list = List.of(
			new Contact(1L, "komal0611@gmail.com", "Komal", 11L),
			new Contact(2L, "piya0611@gmail.com", "Piya", 12L),
			new Contact(3L, "kavya2001@gmail.com", "Kavya", 13L)
			
			);
	@Override
	public List<Contact> getContactOfUser(Long userId) {
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList()); 
	}

}
