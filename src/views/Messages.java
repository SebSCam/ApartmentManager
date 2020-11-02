package views;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Bill;

public class Messages {

	public static void showBills(ArrayList<Bill> arrayList, Component parentComponent) {
		String message = "";
		for (Bill bill : arrayList) {
			message += bill + "\n";
		}
		JOptionPane.showMessageDialog(parentComponent, message, "Bills", JOptionPane.PLAIN_MESSAGE);
	}
}