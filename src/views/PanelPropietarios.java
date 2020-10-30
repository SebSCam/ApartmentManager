package views;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import controller.Controller;

public class PanelPropietarios extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonPanelPropietarios buttonPanelPropietarios;
    private TableModel table;

    public PanelPropietarios(Controller l) {
        this.setName(ConstantsGUI.NAME_MENU_APARTAMENTOS);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents(l);
    }

    private void initComponents(Controller l) {
        buttonPanelPropietarios = new ButtonPanelPropietarios(l);
        table = new TableModel();

        this.add(buttonPanelPropietarios);
        this.add(table);
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public void addLineToTable(Object[] objects) {
        table.addRow(objects);
    }

    public void deleteTable() {
        table.deleteTable();
    }
}
