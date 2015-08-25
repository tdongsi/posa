package com.example.phonebook.service;

import java.util.Map;

import com.example.phonebook.domain.Contact;

public interface PhoneService {

	public abstract Map<String, Contact> getAllContacts();

	public abstract Contact findContact(String id);

	public abstract void deleteContact(String id);

	public abstract Contact addContact(String id, String name, String phone);

	public abstract Contact updateContact(String id, String name, String phone);

}