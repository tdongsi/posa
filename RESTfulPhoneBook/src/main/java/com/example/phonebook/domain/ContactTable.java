package com.example.phonebook.domain;

import java.util.HashMap;
import java.util.Map;

public class ContactTable implements ContactRepository{
	private static Map<String, Contact> contacts = new HashMap<String, Contact>();
	static {
		for(Contact x : new Contact[]{
				new Contact("1","Fred Jones", "777-9311"),
				new Contact("2", "Etta James", "842-3089"),
				new Contact("3","Waldo Smith", "853-3937"),
				new Contact("4","Rupi Patel", "606-0842"),
				new Contact("5", "Carmen Santiago", "867-5309")
		}){
			contacts.put(x.getId(),x);
		}
	}

	@Override
	public Map<String, Contact> getAllContacts() {
		return contacts;
	}

	@Override
	public Contact findContact(String id) {
		return contacts.get(id);
	}

	@Override
	public void deleteContact(String id) {
		contacts.remove(id);
	}

	@Override
	public Contact addContact(String id, String name, String phone) {
		Contact c = new Contact(id, name, phone);
		contacts.put(id, c);
		return c;
	}

	@Override
	public Contact updateContact(Contact c) {
		String id = c.getId();
		contacts.remove(id);
		contacts.put(id,c);
		return c;
	}
	
}
