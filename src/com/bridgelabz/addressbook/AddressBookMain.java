package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nAddress Book Options:");
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Display All Contacts");
			System.out.println("4. Delete Contacts");
			System.out.println("5. view City");
			System.out.println("6. view State");
			System.out.println("7. view zip");
			System.out.println("8. Exit");
			System.out.print("Enter option: ");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.displayContact();
				break;
			case 4:
				addressBook.deleteContact();
				break;
			case 5:
				System.out.print("Enter city name: ");
				String city = sc.next();
				addressBook.viewContactsByCity(city);
				break;
			case 6:
				System.out.print("Enter state name: ");
				String state = sc.next();
				addressBook.viewContactsByState(state);
				break;
			case 7:
				System.out.println("Enter the zip Code: ");
				String zip = sc.next();
				addressBook.viewContactsByZip(zip);
				break;
			case 8:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option!");
				break;
			}
			sc.close();
		}
	}
}
