package models;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -6918526085100330157L;
	private String name;
	private String lastName;
	private IDType idType;
	private String idNumber;
	private String cellPhoneNumber;

	public Person(String name, String lastName, IDType idType, String idNumber, String cellPhoneNumber) {
		this.name = name;
		this.lastName = lastName;
		this.idType = idType;
		this.idNumber = idNumber;
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

	public String getIdNumber() {
		return idNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setIdType(IDType idType) {
		this.idType = idType;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public Object[] toObjectVector() {
		return new Object[] { name, lastName, idType, idNumber, cellPhoneNumber };
	}
}