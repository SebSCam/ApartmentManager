package models;

public class Apartment {
	
	private Person owner;
	private String idNumber;	
	private Bill bill;

	public Apartment(Person owner, String idNumber){
		this.owner = owner;
		this.idNumber = idNumber;
	}

	public Person getOwner() {
		return owner;
	}

	public String getIdNumber(){
		return idNumber;
	}

	public void setOwner(Person owner){
		this.owner = owner;
	} 

	public void setIdNumber(String idNumber){
		this.idNumber = idNumber;
	}
}