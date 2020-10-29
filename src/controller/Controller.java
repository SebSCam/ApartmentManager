package controller;

import models.Administration;
import views.Command;
import views.MainWindow;
import views.PersonDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Administration manager;
	private MainWindow window;
	private PersonDialog personDialog;

	public Controller() {
		manager = new Administration();
		window = new MainWindow(this);
		personDialog = new PersonDialog(manager.getPersonList());
		init();
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
				break;
			case REMOVE_APARTMENT:
				break;
			case REMOVE_PERSON:
				break;
			default:
				break;
		}
	}
}