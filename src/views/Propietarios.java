package views;

import java.util.ArrayList;

import javax.swing.JTabbedPane;
import controller.Controller;
import models.Apartment;

public class Propietarios extends JTabbedPane {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private PanelPropietarios panelPropietarios;
    private PanelApartamentos panelApartamentos;

    public Propietarios(Controller l) {
        panelPropietarios= new PanelPropietarios(l);
        panelApartamentos = new PanelApartamentos(l);
        initComponents();
    }

    private void initComponents() {
        this.add(panelPropietarios);
        this.add(panelApartamentos);
    }

	public int getSelectedRow() {
		return panelPropietarios.getSelectedRow();
	}

	public void addLineToTable(Object[] objects) {
        panelPropietarios.addLineToTable(objects);
	}

	public void deletePersonTable() {
        panelPropietarios.deleteTable();
	}

	public void createApartments(ArrayList<Apartment> apartmentList) {
        panelApartamentos.createApartments(apartmentList);
	}
}