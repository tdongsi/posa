package com.example.phonebook.domain;

import java.util.Map;

public interface ContactRepository {

	public abstract Map<String, Contact> getAllContacts();

	public abstract Contact findContact(String id);

	public abstract void deleteContact(String id);

	public abstract Contact addContact(String id, String name, String phone);

	public abstract Contact updateContact(Contact c);

}