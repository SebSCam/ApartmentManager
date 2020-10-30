package views;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import controller.Controller;
import models.Apartment;

public class PanelApartamentos extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonPanelApartamentos panelPropietarios;
    private PanelButtonApartamentos panelApartamentos;

    public PanelApartamentos(Controller listener) {
        this.setName(ConstantsGUI.NAME_PANEL_APARTAMENTOS);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents(listener);
    }

    private void initComponents(Controller listener) {
        panelPropietarios = new ButtonPanelApartamentos(listener);
        panelApartamentos = new PanelButtonApartamentos();

        this.add(panelPropietarios);
        this.add(panelApartamentos);
    }

    public void createApartments(ArrayList<Apartment> apartmentList) {
        panelApartamentos.createApartments(apartmentList);
    }
}
