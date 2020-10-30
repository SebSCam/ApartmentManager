package controller;

import models.Administration;
import views.Command;
import views.MainWindow;
import views.PersonDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

	private Administration manager;
	private MainWindow window;
	private PersonDialog personDialog;

	public Controller() {
		manager = new Administration();
		window = new MainWindow(this);
		personDialog = new PersonDialog(manager.getPersonList(), this);
		managePersonTable();
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
				manager.addApartment(personDialog.getPerson(), personDialog.getNumber());
				break;
			case ADD_PERSON:
				personDialog.setVisible(true);
				break;
			case EDIT_APARTMENT:
				break;
			case EDIT_PERSON:
				try {
					personDialog.setPerson(manager.getPersonList().get(window.getSelectedRow()));
					personDialog.setVisible(true);
				} catch (IndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Por favor seleccione un elemento de la lista", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case REMOVE_APARTMENT:

				break;
			case REMOVE_PERSON:
				try {
					manager.getPersonList().remove(window.getSelectedRow());
					window.deletePersonTable();
					managePersonTable();
				} catch (IndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "Por favor seleccione un elemento de la lista", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case CREATE_PERSON:
				personDialog.setVisible(false);
				manager.addPerson(personDialog.getPerson());
				window.deletePersonTable();
				managePersonTable();
				break;
			case CANCEL_PERSON:
				personDialog.setVisible(false);
				break;
			default:
				break;
		}
	}
}