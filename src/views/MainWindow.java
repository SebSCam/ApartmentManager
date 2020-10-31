package views;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;
import models.Apartment;

import java.awt.Toolkit;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private PanelPrincipal panelPrincipal;

    public MainWindow(Controller controller) {
        this.setTitle("Administrador y Finanzas Soft");
        // this.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
        this.setLocationRelativeTo(null);
        this.setSize(600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        panelPrincipal = new PanelPrincipal(controller);
        initComponents();
    }

    private void initComponents() {
        this.add(panelPrincipal);
    }

	public int getSelectedRow() {
	    return panelPrincipal.getSelectedRow();
	}

	public void addLineToTable(Object[] objects) {
        panelPrincipal.addLineToTable(objects);
	}

	public void deletePersonTable() {
        panelPrincipal.deletePersonTable();
	}

	public void createApartments(ArrayList<Apartment> apartmentList) {
        panelPrincipal.createApartments(apartmentList);
	}

	public JButton getSelectedButton() {
		return panelPrincipal.getSelectedButton();
	}
}