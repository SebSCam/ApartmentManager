package window;

import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;

public class Propietarios extends JTabbedPane {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private PanelPropietarios panelPropietarios;
    private PanelApartamentos panelApartamentos;

    public Propietarios(MouseListener mouseListener) {
        panelPropietarios= new PanelPropietarios(mouseListener);
        panelApartamentos = new PanelApartamentos();
        initComponents();
    }

    private void initComponents() {
        this.add(panelPropietarios);
        this.add(panelApartamentos);
    }
}