package controller;

import models.Administration;
import views.MainWindow;

public class Controller{

	private Administration manager;
	private MainWindow window;

	public Controller() {
		manager = new Administration();
		window = new MainWindow();
		init();
	}

	private void init() {
		window.setVisible(true);
	}

	private void addData(){

		

	}

	public void getPersonList() {
		manager.getPersonList();
	}
}