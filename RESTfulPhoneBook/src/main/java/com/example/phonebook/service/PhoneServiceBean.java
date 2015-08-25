package com.example.phonebook.service;

import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import com.example.phonebook.domain.Contact;
import com.example.phonebook.domain.ContactRepository;
import com.example.phonebook.domain.ContactTable;

@Named
public class PhoneServiceBean implements PhoneService {
	private ContactRepository repository;
	private Logger logger = Logger.getLogger("PhoneBookApplication");
	
	public PhoneServiceBean() {
		repository = new ContactTable();
	}

	public PhoneServiceBean(ContactRepository repository){
		this.repository = repository;
	}

	@Override
	public Map<String, Contact> getAllContacts() {
		return repository.getAllContacts();
	}

	@Override
	public Contact findContact(String id) {
		return repository.findContact(id);
	}

	@Override
	public void deleteContact(String id){
		repository.deleteContact(id);
	}

	@Override
	public Contact addContact(String id, String name, String phone){
		repository.addContact(id, name, phone);
		return repository.findContact(id);
	}

	@Override
	public Contact updateContact(String id, String name, String phone){
		Contact c = new Contact(id, name, phone);
		repository.updateContact(c);
		Contact temp = repository.findContact(id);
		return temp;
	}
	
	@PostConstruct
	public void setup(){
		logger.info("*** PhoneServiceBean.setup: @PostConstruct has run ***");
	}

}