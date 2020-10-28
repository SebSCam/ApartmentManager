package window;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelApartamentos extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonPanelPropietarios panelPropietarios;
    private PanelButtonApartamentos panelApartamentos;

    public PanelApartamentos() {
        this.setName(ConstantsGUI.NAME_PANEL_APARTAMENTOS);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        panelPropietarios = new ButtonPanelPropietarios();
        panelApartamentos = new PanelButtonApartamentos();

        this.add(panelPropietarios);
        this.add(panelApartamentos);
    }
}
