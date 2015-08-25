package com.example.phonebook;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * 
 * @author marnie
 *
 */

@ApplicationPath("/webservice")
public class ApplicationConfiguration extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}
	
	private void addRestResourceClasses(Set<Class<?>> resources){
		resources.add(com.example.phonebook.PhoneBook.class);
		resources.add(com.example.phonebook.domain.Contact.class);
	}

}
