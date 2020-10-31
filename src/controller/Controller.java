package controller;

import models.Administration;
import views.Command;
import views.InformationDialog;
import views.MainWindow;
import views.PersonDialog;
import views.ApartmentDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.ThaiBuddhistDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

	private Administration manager;
	private MainWindow window;
	private PersonDialog personDialog;
	private ApartmentDialog apartmentDialog;
	private InformationDialog informationDialog;

	public Controller() {
		manager = new Administration();
		window = new MainWindow(this);
		personDialog = new PersonDialog(this);
		apartmentDialog = new ApartmentDialog(this, manager.getPersonList(), this);
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
			case CREATE_APARTMENT:
				manager.addApartment(apartmentDialog.getPerson(), apartmentDialog.getNumber());
				apartmentDialog.setVisible(false);
				window.createApartments(manager.getApartmentList());
				break;
			case CANCEL_APARTMENT:
				apartmentDialog.setVisible(false);
				break;
			case ADD_PERSON:
				personDialog.setVisible(true);
				break;
			case VIEW_APARTMENT:
				informationDialog.setVisible(true);
				break;
			case EDIT_APARTMENT:
				// manager.addApartment(owner, number);
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
}