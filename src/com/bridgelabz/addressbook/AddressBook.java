package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	private ArrayList<Contact> contacts = new ArrayList<>();

	public void addContact() {

		Scanner sc = new Scanner(System.in);
		Contact contact = new Contact();
		System.out.println("Enter the FirstName");
		contact.setFirstName(sc.nextLine());
		System.out.println("Enter the LastName");
		contact.setLastName(sc.nextLine());
		System.out.println("Enter the Address");
		contact.setAddress(sc.nextLine());
		System.out.println("Enter the CityName");
		contact.setCity(sc.nextLine());
		System.out.println("Enter the StateName");
		contact.setState(sc.nextLine());
		System.out.println("Enter the Zip");
		contact.setZip(sc.nextLine());
		System.out.println("Enter the PhoneNumber");
		contact.setPhoneNumber(sc.nextLine());
		System.out.println("Enter the EmailId");
		contact.setEmail(sc.nextLine());

		contacts.add(contact);
		System.out.println("Contact Added Successfully");
		sc.close();
	}

	public void displayContact() {

		System.out.println("All Contacts");
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println("Contact #" + (i + 1));
			System.out.println("First Name: " + contacts.get(i).getFirstName());
			System.out.println("Last Name: " + contacts.get(i).getLastName());
			System.out.println("Address: " + contacts.get(i).getAddress());
			System.out.println("City: " + contacts.get(i).getCity());
			System.out.println("State: " + contacts.get(i).getState());
			System.out.println("Zip: " + contacts.get(i).getZip());
			System.out.println("PhoneNumber: " + contacts.get(i).getPhoneNumber());
			System.out.println("EmailId: " + contacts.get(i).getEmail());
		}
	}
}
