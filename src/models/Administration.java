package models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Properties;

public class Administration {

	private static final double PRICE = 75000;
	private static final double LATEPAYMENTAX = 5000;
	private Month actualMonth;
	private ArrayList<Person> personList;
	private ArrayList<Apartment> aparmentList;
	private double totalMoney;
	private Properties properties;
	private IOBinary ioBinary;

	public Administration() {
		initProperties();
		ioBinary = new IOBinary();
		personList = new ArrayList<>();
		aparmentList = new ArrayList<>();
		this.actualMonth = LocalDate.now().getMonth();
		this.totalMoney = Double.parseDouble(properties.getProperty("TotalMoney"));
	}

	private void initProperties() {
		properties = new Properties();
		try {
			properties.load(new FileReader("src/resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addPerson(String name, String lastName, IDType idType, String idNumber, String cellPhoneNumber) {
		Person person = new Person(name, lastName, idType, idNumber, cellPhoneNumber);
		// for (int i = 0; i < personList.size(); i++) {
		// if (personList.get(i).getIdNumber() == person.getIdNumber()) {
		// personList.remove(i);
		// personList.add(person);
		// }else{
		if (personList.size() == 0) {
			personList.add(person);
		} else {
			for (Person persona : personList) {
				if (persona.getIdNumber() == person.getIdNumber()) {
					personList.remove(persona);
					personList.add(person);
				} else {
					personList.add(person);
				}
			}
		}
	}

	// }
	// }

	public void addApartment(Person owner, String number) {
		Apartment apartment = new Apartment(owner, number);
		aparmentList.add(apartment);
		ioBinary.writeApartment(apartment);
	}

	public void editPerson(Person owner, String name, String lastName, IDType idType, String phoneNumber) {
		for (Apartment apartment : aparmentList) {
			if (apartment.getOwner().equals(owner)) {
				apartment.getOwner().setName(name);
				apartment.getOwner().setLastName(lastName);
				apartment.getOwner().setIdType(idType);
				apartment.getOwner().setCellPhoneNumber(phoneNumber);
			}
		}
	}

	public void deletePerson(Person owner) {
		personList.remove(owner);
	}

	/**
	 * Metodo que se encarga de realizar el pago de una factura
	 * 
	 * @param bill factura del mes que se quiere realizar el pago
	 */
	public void payment(Bill bill) {
		loadPayment(totalMoney + calculatePaymentMonth(bill));
	}

	/**
	 * Metodo que se encarga de hacer calculo sobre los servicios extras que tiene
	 * la administracion. Sumando los costos de estos servicios dependiendo cual se
	 * escoja
	 * 
	 * @param typeService Enum de tipo de servicio
	 * @param price       Valor del servicio
	 */
	public void payServices(ExtraServices typeService, double price) {
		switch (typeService) {
			case POOL_SERVICE:
				loadPayment(totalMoney + price);
				break;
			case SCYTHE_SERVICE:
				loadPayment(totalMoney - price);
				break;
		}
	}

	/**
	 * Metodo que calcula el pago de un mes dependiendo la fecha
	 * 
	 * @param bill Factura a pagar
	 * @return retorna el valor del pago que se debe realizar
	 */
	private double calculatePaymentMonth(Bill bill) {
		if (bill.getIsPayment() == false && bill.getConcept().equals(actualMonth)) {
			return PRICE;
		} else {
			return generateInterest();
		}
	}

	/**
	 * Metodo que genera el interes, cuando el pago se realiza despues del mes
	 * establecido
	 * 
	 * @return Valor definido + intereses
	 */
	private double generateInterest() {
		return PRICE + LATEPAYMENTAX;
	}

	private void loadPayment(double money) {
		properties.setProperty("TotalMoney", String.valueOf(money));
		totalMoney = Double.parseDouble(properties.getProperty("TotalMoney"));
		try {
			properties.store(new FileWriter("src/sources/config.properties"), "Caja menor se ha modificado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void readPersonList() {
		ioBinary.readPerson();
	}

	public ArrayList<Apartment> getApartmentList() {
		return aparmentList;
	}

	public void readApartmentList() {
		ioBinary.readApartment();
		;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void addPerson(Person person) {
		// for (int i = 0; i < personList.size(); i++) {
		// if (personList.get(i).getIdNumber() == person.getIdNumber()) {
		// personList.remove(i);
		// personList.add(person);
		// }else{
		personList.add(person);
		// }
		// }
	}

	public ArrayList<Object[]> getPersonListVector() {
		ArrayList<Object[]> datasList = new ArrayList<>();
		for (int i = 0; i < personList.size(); i++) {
			datasList.add(personList.get(i).toObjectVector());
		}
		return datasList;
	}
}