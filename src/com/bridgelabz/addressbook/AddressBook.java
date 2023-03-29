package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBook extends Contact{
	
	public void addContact() {
		
		Scanner sc = new Scanner(System.in);
		Contact contact = new Contact();
		System.out.println("Enter the FirstName: ");
		String firstName = sc.nextLine();
		contact.setFirstName(firstName);
		
		System.out.println("Enter the lastName: ");
		String lastName = sc.nextLine();
		contact.setLastName(lastName);
		
		System.out.println("Enter the Address: ");
		String address = sc.nextLine();
		contact.setAddress(address);
		
		System.out.println("Enter the cityName: ");
		String city=sc.nextLine();
		contact.setCity(city);
		
		System.out.println("Enter the StateName");
		String state = sc.nextLine();
		contact.setState(state);
		
		System.out.println("Enter the ZipCode: ");
		String zip=sc.nextLine();
		contact.setZip(zip);
		
		System.out.println("Enter the PhoneNumber: ");
		String phoneNumber=sc.nextLine();
		contact.setPhoneNumber(phoneNumber);
		
		System.out.println("Enter the EmailId: ");
		String email=sc.nextLine();
		contact.setEmail(email);
		
		System.out.println("FirstName: "+contact.getFirstName());
		System.out.println("LastName: "+contact.getLastName());
		System.out.println("Address: "+contact.getAddress());
		System.out.println("CityName: "+contact.getCity());
		System.out.println("StateName: "+contact.getState());
		System.out.println("ZipCode: "+contact.getZip());
		System.out.println("PhoneNumber: "+contact.getPhoneNumber());
		System.out.println("EmailId: "+contact.getEmail());
		sc.close();
	}
}
