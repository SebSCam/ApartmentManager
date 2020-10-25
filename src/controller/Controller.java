package controller;

import models.Administration;
import window.MainWindow;

public class Controller {
	
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

	public void getPersonList(){
		manager.getPersonList();
	}
}