package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import models.Administration;
import window.MainWindow;

public class Controller implements MouseInputListener {

	private Administration manager;
	private MainWindow window;

	public Controller() {
		manager = new Administration();
		window = new MainWindow(this);
		init();
	}

	private void init() {
		window.setVisible(true);
	}

	public void getPersonList() {
		manager.getPersonList();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}