package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	private ArrayList<Contact> contacts = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void addContact() {
		boolean addMoreContacts = true;
		while (addMoreContacts) {
			Contact contact = new Contact(); // create new Contact object
			System.out.println("Enter the FirstName");
			String firstName = sc.nextLine();
			System.out.println("Enter the LastName");
			String lastName = sc.nextLine();
			if (isContactExists(firstName, lastName)) {
				System.out.println("Contact with same name already exists!");
				continue;
			}
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
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

			System.out.println("Do you want to add another contact? (Y/N)");
			String choice = sc.nextLine();
			addMoreContacts = choice.equalsIgnoreCase("Y");
		}
	}

	public boolean isContactExists(String firstName, String lastName) {
		for (Contact contact : contacts) {
			if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public ArrayList<Contact> searchByCity(String cityName) { ArrayList<Contact>
	 * results = new ArrayList<>(); for (int i = 0; i < contacts.size(); i++) {
	 * Contact contact = contacts.get(i); if
	 * (contact.getCity().equalsIgnoreCase(cityName)) { results.add(contact); } } if
	 * (results.isEmpty()) {
	 * System.out.println("No contacts found in the given city."); } return results;
	 * }
	 * 
	 * public ArrayList<Contact> searchByState(String stateName) {
	 * ArrayList<Contact> results = new ArrayList<>(); for (int i = 0; i <
	 * contacts.size(); i++) { Contact contact = contacts.get(i); if
	 * (contact.getState().equalsIgnoreCase(stateName)) { results.add(contact); } }
	 * if (results.isEmpty()) {
	 * System.out.println("No contacts found in the given state."); } return
	 * results; }
	 */

	public ArrayList<Contact> viewContactsByCity(String cityName) {
		ArrayList<Contact> results = new ArrayList<>();
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getCity().equalsIgnoreCase(cityName)) {
				results.add(contact);
			}
		}
		if (results.isEmpty()) {
			System.out.println("No contacts found in the given city.");
		} else {
			System.out.println("Contacts in the city of " + cityName + ":");
			for (Contact contact : results) {
				System.out.println("First Name: " + contact.getFirstName() + " " + "Last Name: " + contact.getLastName()+" "+ "Mobile Number: "+contact.getPhoneNumber());
			}
		}
		return results;
	}

	public ArrayList<Contact> viewContactsByState(String stateName) {
		ArrayList<Contact> results = new ArrayList<>();
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getState().equalsIgnoreCase(stateName)) {
				results.add(contact);
			}
		}
		if (results.isEmpty()) {
			System.out.println("No contacts found in the given state.");
		} else {
			System.out.println("Contacts in the state of " + stateName + ":");
			for (Contact contact : results) {
				System.out.println("First Name: " + contact.getFirstName() + " " + "Last Name: " + contact.getLastName()+" "+"Mobile Number: "+contact.getPhoneNumber());
			}
		}
		return results;
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

	public void editContact() {
		System.out.println("Enter the first name of the contact you want to edit:");
		String firstName = sc.nextLine();
		System.out.println("Enter the last name of the contact you want to edit:");
		String lastName = sc.nextLine();
		boolean found = false;
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
				found = true;
				System.out.println("Enter the new Address:");
				contact.setAddress(sc.nextLine());
				System.out.println("Enter the new City:");
				contact.setCity(sc.nextLine());
				System.out.println("Enter the new State:");
				contact.setState(sc.nextLine());
				System.out.println("Enter the new Zip:");
				contact.setZip(sc.nextLine());
				System.out.println("Enter the new PhoneNumber:");
				contact.setPhoneNumber(sc.nextLine());
				System.out.println("Enter the new EmailId:");
				contact.setEmail(sc.nextLine());
				System.out.println("Contact updated successfully!");
				break;
			}
		}

		if (!found) {
			System.out.println("No contact found with the given name!");
		}
	}

	public void deleteContact() {
		System.out.println("Enter the first name of the contact you want to delete:");
		String firstName = sc.nextLine();
		System.out.println("Enter the last name of the contact you want to delete:");
		String lastName = sc.nextLine();
		boolean found = false;
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
				found = true;
				contacts.remove(i);
				System.out.println("Contact deleted successfully!");
				break;
			}
		}
		if (!found) {
			System.out.println("No contact found with the given name!");
		}
	}

}