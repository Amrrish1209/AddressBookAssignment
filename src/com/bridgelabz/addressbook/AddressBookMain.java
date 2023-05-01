package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();

		boolean isRunning = true;
		while (isRunning) {
			System.out.println("Select an option:\n" + "1. Add a new contact\n" + "2. Update an existing contact\n"
					+ "3. Delete a contact\n" + "4. View all contacts\n" + "5. View contacts by city\n"
					+ "6. View contacts by state\n" + "7. Write contacts to CSV\n" + "8. Read contacts from CSV\n"
					+ "9. Exit");
			int choice = addressBook.sc.nextInt();
			addressBook.sc.nextLine(); // Consume newline left-over

			switch (choice) {
			case 1:
				System.out.println("Enter the first Name:");
				String firstName = addressBook.sc.nextLine();
				System.out.println("Enter the Last Name:");
				String lastName = addressBook.sc.nextLine();
				System.out.println("Enter the Address");
				String address = addressBook.sc.nextLine();
				System.out.println("Enter the CityName");
				String city = addressBook.sc.nextLine();
				System.out.println("Enter the StateName");
				String state = addressBook.sc.nextLine();
				System.out.println("Enter the Zip");
				String zip = addressBook.sc.nextLine();
				System.out.println("Enter the PhoneNumber");
				String phoneNumber = addressBook.sc.nextLine();
				System.out.println("Enter the EmailId");
				String email = addressBook.sc.nextLine();
				Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
				addressBook.addContact(newContact);
				System.out.println("Contact added successfully.");
				break;

			case 2:
				System.out.println("Enter the First Name of the contact you want to update:");
				firstName = addressBook.sc.nextLine();
				System.out.println("Enter the Last Name of the contact you want to update:");
				lastName = addressBook.sc.nextLine();
				addressBook.updateContact(firstName, lastName);
				break;

			case 3:
				System.out.println("Enter the First Name of the contact you want to delete:");
				firstName = addressBook.sc.nextLine();
				System.out.println("Enter the Last Name of the contact you want to delete:");
				lastName = addressBook.sc.nextLine();
				addressBook.deleteContact(firstName, lastName);
				break;

			case 4:
				addressBook.viewAllContacts();
				break;

			case 5:
				System.out.println("Enter the city name:");
				city = addressBook.sc.nextLine();
				List<Contact> contactsInCity = addressBook.viewContactsByCity(city);
				if (contactsInCity.isEmpty()) {
					System.out.println("No contacts found in the city: " + city);
				} else {
					System.out.println("Contacts in the city: " + city);
					for (Contact contact : contactsInCity) {
						System.out.println(contact);
					}
				}
				break;

			case 6:
				System.out.println("Enter the state name:");
				state = addressBook.sc.nextLine();
				List<Contact> contactsInState = addressBook.viewContactsByState(state);
				if (contactsInState.isEmpty()) {
					System.out.println("No contacts found in the state: " + state);
				} else {
					System.out.println("Contacts in the state: " + state);
					for (Contact contact : contactsInState) {
						System.out.println(contact);
					}
				}
				break;

			case 7:
				System.out.println("Enter the file path to write contacts to:");
				String filePath = addressBook.sc.nextLine();
				File outputFile = new File(filePath);
				try {
					addressBook.writeContactsToCSV(outputFile);
				} catch (IOException e) {
					System.out.println("Error writing contacts to CSV file: " + e.getMessage());
				}
				break;

			case 8:
				System.out.println("Enter the file path to read contacts from:");
				filePath = addressBook.sc.nextLine();
				File inputFile = new File(filePath);
				try {
					addressBook.readContactsFromCSV(inputFile);
				} catch (FileNotFoundException e) {
					System.out.println("File not found: " + e.getMessage());
				}
				break;

			case 9:
				System.out.println("Exiting the program.");
				isRunning = false;
				break;

			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}
}
