package controller;

import models.Administration;
import models.Apartment;
import models.IDType;
import models.Person;
import views.Command;
import views.InformationDialog;
import views.MainWindow;
import views.Messages;
import views.PersonDialog;
import views.ApartmentDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

public class Controller implements ActionListener, MouseInputListener {

	private Administration manager;
	private MainWindow window;
	private PersonDialog personDialog;
	private ApartmentDialog apartmentDialog;
	private InformationDialog informationDialog;

	public Controller() {
		manager = new Administration();
		manager.addApartment(new Person("Esteban", "Torres", IDType.CC, "21458963", "3114587965"), "1-1");
		manager.addApartment(new Person("Ivan", "Fernanza", IDType.CC, "43435", "3114587965"), "1-2");
		manager.addApartment(new Person("Sebastian", "Puerto", IDType.CC, "453445", "3114587965"), "1-3");
		manager.addApartment(new Person("Daniel", "Luis", IDType.CC, "87678", "3114587965"), "1-4");
		manager.addApartment(new Person("Carlos", "Torres", IDType.CC, "945345", "3114587965"), "1-5");
		manager.addApartment(new Person("Esteban", "Torres", IDType.CC, "21458963", "3114587965"), "1-1");
		manager.addApartment(new Person("Ivan", "Fernanza", IDType.CC, "43435", "3114587965"), "1-2");
		manager.addApartment(new Person("Sebastian", "Puerto", IDType.CC, "453445", "3114587965"), "1-3");
		manager.addApartment(new Person("Daniel", "Luis", IDType.CC, "87678", "3114587965"), "1-4");
		manager.addApartment(new Person("Carlos", "Torres", IDType.CC, "945345", "3114587965"), "1-5");
		manager.addApartment(new Person("Esteban", "Torres", IDType.CC, "21458963", "3114587965"), "1-1");
		manager.addApartment(new Person("Ivan", "Fernanza", IDType.CC, "43435", "3114587965"), "1-2");
		manager.addApartment(new Person("Sebastian", "Puerto", IDType.CC, "453445", "3114587965"), "1-3");
		manager.addApartment(new Person("Daniel", "Luis", IDType.CC, "87678", "3114587965"), "1-4");
		manager.addApartment(new Person("Carlos", "Torres", IDType.CC, "945345", "3114587965"), "1-5");

		manager.generatePersonList();

		window = new MainWindow(this);
		personDialog = new PersonDialog(this);
		apartmentDialog = new ApartmentDialog(this, manager.getPersonList());
		informationDialog = new InformationDialog(this);
		managePersonTable();
		window.createApartments(manager.getApartmentList());
		init();
	}

	private void managePersonTable() {
		ArrayList<Object[]> datasList = manager.getPersonListVector();
		for (Object[] objects : datasList) {
			window.addLineToTable(objects);
		}
	}

	private void init() {
		window.setVisible(true);
	}

	public void getPersonList() {
		manager.getPersonList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Command.valueOf(e.getActionCommand())) {
			case ADD_APARTMENT:
				apartmentDialog.setVisible(true);
				window.createApartments(manager.getApartmentList());
				break;
			case REMOVE_APARTMENT:
				manager.removeApartment(informationDialog.getApartmentNumber());
				informationDialog.setVisible(false);
				window.createApartments(manager.getApartmentList());
				break;
			case CREATE_APARTMENT:
				manager.addApartment(apartmentDialog.getPerson(), apartmentDialog.getNumber());
				apartmentDialog.setVisible(false);
				window.createApartments(manager.getApartmentList());
				break;
			case CANCEL_APARTMENT:
				apartmentDialog.setVisible(false);
				break;
			case CANCEL_APARTMENT_VIEW:
				informationDialog.setVisible(false);
				break;
			case SHOW_BILLS:
				Messages.showBills(manager.searchApartment(informationDialog.getApartmentNumber()).getBillList(),
						informationDialog);
				break;
			case SHOW_PAY_DIALOG:
				break;
			case ADD_PERSON:
				personDialog.setVisible(true);
				break;
			case VIEW_APARTMENT:
				informationDialog.setVisible(true);
				break;
			case EDIT_PERSON:
				try {
					personDialog.setPerson(manager.getPersonList().get(window.getSelectedRow()));
					personDialog.changeButton();
					personDialog.setVisible(true);
				} catch (IndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Por favor seleccione un Propietario", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case CHANGE_PERSON:
				personDialog.setVisible(false);
				manager.editPerson(window.getSelectedRow(), personDialog.getPerson());
				personDialog.revert();
				window.deletePersonTable();
				managePersonTable();
				break;
			case REMOVE_PERSON:
				try {
					manager.getPersonList().remove(window.getSelectedRow());
					window.deletePersonTable();
					managePersonTable();
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "Por favor seleccione un Propietario", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case CREATE_PERSON:
				personDialog.setVisible(false);
				manager.addPerson(personDialog.getPerson());
				System.out.println("Pruebitas");
				window.deletePersonTable();
				managePersonTable();
				apartmentDialog.uptatePerson(manager.getPersonList());
				break;
			case CANCEL_PERSON:
				personDialog.setVisible(false);
				break;
			default:
				break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton selectedButton = window.getSelectedButton();
		Apartment apartment = manager.searchApartment(selectedButton.getText());
		informationDialog.setInformation(selectedButton.getText(), apartment.getOwner().toString(),
				String.valueOf(apartment.getBillTotal()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}