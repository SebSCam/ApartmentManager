package views;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.Bill;

public class Messages {

	public static void showBills(ArrayList<Bill> arrayList, Component parentComponent) {
		String message = "";
		for (Bill bill : arrayList) {
			message += bill + "\n";
		}
		JOptionPane.showMessageDialog(parentComponent, message, "Pagos Pendientes", JOptionPane.PLAIN_MESSAGE);
	}

	public static Bill getBill(ArrayList<Bill> billList) {
		Object[] list = billList.toArray();
		return (Bill) JOptionPane.showInputDialog(null, "Seleccione factura a pagar", "Pagos en mora",
				JOptionPane.QUESTION_MESSAGE, new ImageIcon(), list, list[0]);
	}

	public static void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}