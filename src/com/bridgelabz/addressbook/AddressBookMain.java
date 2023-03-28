package com.bridgelabz.addressbook;

public class AddressBookMain {

	public static void main(String[] args) {
		
		System.out.println("Welcome To Address Book Program");
		System.out.println("");
		System.out.println("New Contact created");
		Contact contact = new Contact();
		contact.setFirstName("Amrrish");
		System.out.println("FirstName: "+contact.getFirstName());
		
		contact.setLastName("Roshan");
		System.out.println("LastName: "+contact.getLastName());
		
		contact.setAddress("Kottar");
		System.out.println("Address: "+contact.getAddress());
		
		contact.setCity("Nagercoil");
		System.out.println("CityName: "+contact.getCity());
		
		contact.setState("TamilNadu");
		System.out.println("StateName: "+contact.getState());
		
		contact.setZip(629002);
		System.out.println("Zip: "+contact.getZip());
		
		contact.setPhoneNumber("8778213740");
		System.out.println("PhoneNumber: "+contact.getPhoneNumber());
		
		contact.setEmail("roshanbabubl@gmail.com");
		System.out.println("EmailId: "+contact.getEmail());
	}
}
