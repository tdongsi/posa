package com.example.phonebook.main;


public class XMLApplication {
	public static void main(String arg[]){
		/*ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		PhoneService service = (PhoneService)(context.getBean("phoneService"));
		System.out.println("/// getAllContacts ///");
		printAllContacts(service);
		
		System.out.println("/// findContact ///");
		Contact oneContact = service.findContact("3");
		System.out.println("The contact with the ID of 3 is: " + oneContact);
		
		System.out.println("/// updateContact ///");
		oneContact.setName("Torai Spaniel");
		oneContact = service.findContact("3");
		System.out.println("The updated contact is now: " + oneContact);
		
		System.out.println("/// addContact ///");
		Contact newContact = service.addContact("13", "Gru", "646-4667");
		System.out.println("The added contact is: " + service.findContact("13"));
		
		System.out.println("/// deleteContact ///");
		service.deleteContact("3");
		System.out.println("The contact with the ID of 3 should be missing from the following list");
		Map<String, Contact> list = service.getAllContacts();
		printAllContacts(service);*/

	}
	
	/*private static void printAllContacts(PhoneService service) {
		Map<String, Contact> list = service.getAllContacts();
		Set setOfContacts = list.entrySet();
		for(Object c : setOfContacts){
			System.out.println(c);
		}
	}*/
}
