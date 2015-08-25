package com.example.phonebook.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {

	private String name, phone;
	private String id;

	public Contact() {}
	public Contact(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.getName()+" \t"+ this.getPhone(); 
	}

	
}
