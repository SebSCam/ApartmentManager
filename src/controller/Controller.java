package controller;

import models.Administration;
import window.MyWindow;

public class Controller {
	
	private Administration myAdministration;
	private MyWindow myWindow;
	
	public Controller() {
		myAdministration = new Administration();
		myWindow = new MyWindow();
	}
}