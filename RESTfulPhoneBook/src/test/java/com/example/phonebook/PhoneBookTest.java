package com.example.phonebook;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
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
	
	/**
	 * Use parameter from XML suite file.
	 * 
	 * @param id
	 */
	@Test
	@Parameters("contactId")
	public void testGet(String id) {
		WebTarget target = base.path("contacts/" + id);
		Response resp = target.request().get();
		Object item = resp.getEntity();
		
		Assert.assertNotNull(item);
		Assert.assertEquals(resp.getStatus(), 200);
	}
	
	/**
	 * Use DataProvider
	 * 
	 * @param id
	 */
	@Test(dataProvider="idGenerator")
	public void testAllGet(String id) {
		WebTarget target = base.path("contacts/" + id);
		Response resp = target.request().get();
		Object item = resp.getEntity();
		
		Assert.assertNotNull(item);
		Assert.assertEquals(resp.getStatus(), 200);
	}
	
	@DataProvider(name="idGenerator")
	public Object[][] generator() {
		Object[][] ids = {{"1"}, {"2"}, {"3"} };
		return ids;
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
