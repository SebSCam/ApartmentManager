package models;

public class Person {

	private String name;
	private String lastName;
	private IDType idType;
	private int cellPhoneNumber;

	public Person(String name, String lastName, IDType idType, int cellPhoneNumber) {
		this.name = name;
		this.lastName = lastName;
		this.idType = idType;
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public IDType getIdType() {
		return idType;
	}

	public int getCellPhoneNumber() {
		return cellPhoneNumber;
	}
}