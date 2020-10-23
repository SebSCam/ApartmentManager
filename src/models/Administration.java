package models;

import java.util.ArrayList;

public class Administration {

	private ArrayList<Person> personList;
	private ArrayList<Apartment> aparmentList;

	public void addPerson(String name, String lastName, IDType idType, String idNumber, String cellPhoneNumber) {
		personList.add(new Person(name, lastName, idType, idNumber, cellPhoneNumber));
	}

	public void addApartment(Person owner, String number) {
		aparmentList.add(new Apartment(owner, number));
	}

	public void editPerson(Person owner, String name, String lastName, IDType idType, String phoneNumber) {
		for (Apartment apartment : aparmentList) {
			if (apartment.getOwner().equals(owner)){
				apartment.getOwner().setName(name);
				apartment.getOwner().setLastName(lastName);
				apartment.getOwner().setIdType(idType);
				apartment.getOwner().setCellPhoneNumber(phoneNumber);
			}
		}
	}

	public double calculateSmallerBox() {
		return 0;
	}
}