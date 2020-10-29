package controller;

import models.Administration;
import views.MainWindow;
import views.PersonDialog;

public class Controller {

	private Administration manager;
	private MainWindow window;
	private PersonDialog personDialog;

	public Controller() {
		manager = new Administration();
		window = new MainWindow();
		personDialog = new PersonDialog();
		init();
	}

	private void init() {
		window.setVisible(true);
	}

	private void addData() {

	}

	public void getPersonList() {
		manager.getPersonList();
	}
}