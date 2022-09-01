package com.BikkadIT.controller;

import java.util.List;
import java.util.Map;

import org.jboss.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Contact;
import com.BikkadIT.service.ContactServiceI;
import com.BikkadIT.util.AppConstants;
import com.BikkadIT.util.AppProps;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	
	//inject
	@Autowired
	private AppProps appProps;
	
	
	//save
	@PostMapping(value="/saveContact" ,consumes="application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
		
		boolean saveContact=contactServiceI.saveContact(contact);
		Map<String,String> messages=appProps.getMessages();
		System.out.println(messages);
		
		if(saveContact==true) {
			
			String msg=messages.get(AppConstants.SAVE_SUCCESS);
		//	String msg="Contact Saved Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg=messages.get(AppConstants.SAVE_FAIL);
			// String msg="Contact Not Saved Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}
	}
		
		//getAll
		
	    @GetMapping(value="/getAllContact", produces="application/json")
		public ResponseEntity<List<Contact>> getAllContact() {
			List<Contact> allContact=contactServiceI.getAllContact();
			
			if(allContact != null) {
				return new ResponseEntity<List<Contact>>(allContact, HttpStatus.OK);
			}else {
				String msg="Data not found";
			
			return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
			
		}
		}
	    
	    //particular id create
	    
	    @GetMapping(value="/getContactById/{cid}",produces="application/json")
	    public ResponseEntity<Contact> getContactById(@PathVariable Integer cid) {
	    	Contact contactById=contactServiceI.getContactById(cid);
			return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
	    	
	    	
	    }
	    
	    //upadte
	    
	    @PutMapping(value="/UpdateContact" ,consumes="application/json")
		public ResponseEntity<String> UpdateContact(@RequestBody Contact contact) {
			
			boolean saveContact=contactServiceI.updateContact(contact);
			
			Map<String,String> messages=appProps.getMessages();
			
			if(saveContact==true) {
				String msg=messages.get(AppConstants.UPDATE_SUCCESS);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}else {
				String msg=messages.get(AppConstants.UPDATE_FAIL);
				return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
				
			}
	    }	
			
			
			//delete hard
			
			@DeleteMapping(value="/deleteContactById/{cid}")
			public ResponseEntity<String> deleteContactById(@PathVariable Integer cid) {
				
				boolean deleteById=contactServiceI.deleteById(cid);
				
				Map<String,String> messages=appProps.getMessages();
				
				if(deleteById) {
					return new ResponseEntity<String>(messages.get(AppConstants.DELETE_SUCCESS),HttpStatus.OK);
					
				}else {
					return new ResponseEntity<String>(messages.get(AppConstants.DELETE_FAIL),HttpStatus.BAD_REQUEST);
			}
			
			}	
	}


