package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
			results.sort(new Comparator<Contact>() {
				public int compare(Contact c1, Contact c2) {
					return c1.getCity().compareToIgnoreCase(c2.getCity());
				}
			});
			for (Contact contact : results) {
				System.out.println(contact);
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
			results.sort(new Comparator<Contact>() {
				public int compare(Contact c1, Contact c2) {
					return c1.getState().compareToIgnoreCase(c2.getState());
				}
			});
			for (Contact contact : results) {
				System.out.println(contact);
			}
		}
		return results;
	}

	public ArrayList<Contact> viewContactsByZip(String zipCode) {
		ArrayList<Contact> results = new ArrayList<>();
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getZip().equalsIgnoreCase(zipCode)) {
				results.add(contact);
			}
		}
		if (results.isEmpty()) {
			System.out.println("No contacts found in the given zip code.");
		} else {
			System.out.println("Contacts in the state of " + zipCode + ":");
			results.sort(new Comparator<Contact>() {
				public int compare(Contact c1, Contact c2) {
					return c1.getZip().compareToIgnoreCase(c2.getZip());
				}
			});
			for (Contact contact : results) {
				System.out.println(contact);
			}
		}
		return results;
	}

	public void displayContact() {
		Collections.sort(contacts, new Comparator<Contact>() {
			public int compare(Contact c1, Contact c2) {
				return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
			}
		});

		System.out.println("All Contacts");
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println("Contact #" + (i + 1));
			System.out.println(contacts.get(i).toString());
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