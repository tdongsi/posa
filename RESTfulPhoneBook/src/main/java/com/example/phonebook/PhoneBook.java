package com.example.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.phonebook.domain.Contact;
import com.example.phonebook.service.PhoneService;
import com.example.phonebook.service.PhoneServiceBean;
@Path("contacts")
public class PhoneBook {

	private PhoneService service = new PhoneServiceBean();

	@GET
	public  List<Contact> getAllContacts() {
		Map<String,Contact> contacts1= service.getAllContacts();
		Set<Map.Entry<String,Contact>> contacts2 = contacts1.entrySet();
		List<Contact> contactList = new ArrayList<Contact>();
		for (Map.Entry<String, Contact> contact : contacts2){
			contactList.add(contact.getValue());
		}
		
		return contactList;
	}

	@GET
	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
	public Contact findContact(@PathParam("id") String id) {
		return service.findContact(id);
	}

	@DELETE
	@Path("/{id}")
	public void deleteContact(@PathParam("id") String id){
		service.deleteContact(id);
	}
	
	@POST
	public Contact addContact(@QueryParam("id")String id, @QueryParam("name") String name, @QueryParam("phone")String phone){
		service.addContact(id, name, phone);
		return service.findContact(id);
	}

	@PUT
	public void updateContact(@QueryParam("id")String id, @QueryParam("name")String name, @QueryParam("phone")String phone){
		service.updateContact(id, name, phone);

	}
}
