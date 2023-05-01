package com.bridgelabz.addressbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AddressBook {

	private ArrayList<Contact> contacts = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void addContact(Contact newContact) {
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
					return c1.getCity().compareToIgnoreCase(c2.getCity());
				}
			});
			for (Contact contact : results) {
				System.out.println(contact);
			}
		}
		return results;
	}

	public void updateContact(String firstName, String lastName) {
		for (Contact contact : contacts) {
			if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
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

				System.out.println("Contact updated successfully.");
				return;
			}
		}
		System.out.println("No contact found with the given name.");
	}

	public void deleteContact(String firstName, String lastName) {
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
				contacts.remove(i);
				System.out.println("Contact deleted successfully.");
				return;
			}
		}
		System.out.println("No contact found with the given name.");
	}

	public void viewAllContacts() {
		if (contacts.isEmpty()) {
			System.out.println("No contacts found!");
			return;
		}
		System.out.println("All Contacts:");
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

	public void writeContactsToCSV(File file) throws IOException {
		FileWriter outputfile = new FileWriter(file);
		CSVWriter writer = new CSVWriter(outputfile);

		String[] header = { "First Name", "Last Name", "Address", "City", "State", "Zip", "Phone Number", "Email" };
		writer.writeNext(header);

		for (Contact contact : contacts) {
			String[] data = { contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getCity(),
					contact.getState(), contact.getZip(), contact.getPhoneNumber(), contact.getEmail() };
			writer.writeNext(data);
		}

		writer.close();
		System.out.println("Contacts written to CSV file successfully.");
	}

	public void readContactsFromCSV(File file) throws FileNotFoundException {
		CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build();
		CsvToBean<Contact> csvToBean = new CsvToBeanBuilder<Contact>(reader).withType(Contact.class).build();

		contacts.clear();
		for (Contact contact : csvToBean) {
			contacts.add(contact);
		}

		System.out.println("Contacts read from CSV file successfully.");
	}

}
