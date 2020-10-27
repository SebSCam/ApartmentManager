package window;

import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelPropietarios extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonPanelPropietarios buttonPanelPropietarios;
    private TablePropietarios table;

    public PanelPropietarios(MouseListener mouseListener) {
        this.setName(ConstantsGUI.NAME_MENU_APARTAMENTOS);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents(mouseListener);
    }

    private void initComponents(MouseListener mouseListener) {
        buttonPanelPropietarios = new ButtonPanelPropietarios();
        table = new TablePropietarios(mouseListener);

        this.add(buttonPanelPropietarios);
        this.add(table);
    }
}
