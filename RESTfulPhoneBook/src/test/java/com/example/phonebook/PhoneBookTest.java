package com.example.phonebook;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PhoneBookTest {
	
	private Client client;
	private WebTarget base;
	
	@Test
	public void testGetAll() {
		WebTarget target = base.path("contacts");
		Response resp = target.request().get();
		Object list = resp.getEntity();
		
		Assert.assertNotNull(list);
		Assert.assertEquals(resp.getStatus(), 200);
	}

	@BeforeClass
	public void beforeClass() {
		client = ClientBuilder.newClient();
		base = client.target("http://localhost:8080/RESTfulPhoneBook/webservice");
	}

	@AfterClass
	public void afterClass() {
		client.close();
	}

}
