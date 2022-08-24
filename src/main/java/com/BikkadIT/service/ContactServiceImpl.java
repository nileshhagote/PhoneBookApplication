package com.BikkadIT.service;

import java.util.List;

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


	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		List<Contact> findAll=contactRepository.findAll();
		return findAll;
	}


	@Override
	public Contact getContactById(Integer cid) {
		// TODO Auto-generated method stub
		Contact findById=contactRepository.findById(cid).get();
		
		return findById;
	}


	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		
		Contact save=contactRepository.save(contact);
		if(save==null) {
			return false;
		}else {
			return true;
		}
	}
		
		
		
		
		
		
		
	
}
