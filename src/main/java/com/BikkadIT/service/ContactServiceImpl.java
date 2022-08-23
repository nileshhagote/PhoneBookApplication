package com.BikkadIT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Repository.ContactRepository;
import com.BikkadIT.model.Contact;

@Service
public class ContactServiceImpl implements ContactServiceI{

	@Autowired
	private ContactRepository contactRepository;
	
	
	@Override
	public boolean saveContact(Contact contact) {
		// TODO Auto-generated method stub
		Contact save=contactRepository.save(contact);
		
		if(save !=null) {
			return true;
		}
		else {
			
		return false;
	}
	}
}
