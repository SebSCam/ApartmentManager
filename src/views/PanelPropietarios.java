package views;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelPropietarios extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonPanelPropietarios buttonPanelPropietarios;
    private TableModel table;

    public PanelPropietarios() {
        this.setName(ConstantsGUI.NAME_MENU_APARTAMENTOS);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        buttonPanelPropietarios = new ButtonPanelPropietarios();
        table = new TableModel();

        this.add(buttonPanelPropietarios);
        this.add(table);
    }
}
