package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Apartment implements Serializable{
	
	private static final long serialVersionUID = -5039101338305804761L;
	private Person owner;
	private String idNumber;	
	private ArrayList<Bill> billList;

	public Apartment(Person owner, String idNumber){
		billList = new ArrayList<>();
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

	public ArrayList<Bill> getBill() {
		return billList;
	}

	public void uploadBillMonth(Bill bill){
		billList.add(bill);
	}

	public ArrayList<Bill> getBillList() {
		return billList;
	}
}