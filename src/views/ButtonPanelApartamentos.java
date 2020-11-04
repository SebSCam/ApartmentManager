package views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import controller.Controller;

public class ButtonPanelApartamentos extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonModel buttonAdd;
    private JComboBox<TableOptions> tableSelector;

    public ButtonPanelApartamentos(Controller listener) {
        this.setLayout(new FlowLayout());
        buttonAdd = new ButtonModel(ConstantsGUI.NAME_BUTTON_AGREGAR, ConstantsGUI.PATH_IMAGE_ADD_APARTAMENTO);
        tableSelector = new JComboBox<TableOptions>();
        initComponents(listener);
    }

    private void initComponents(ActionListener l) {
        buttonAdd.setActionCommand(Command.ADD_APARTMENT.name());
        buttonAdd.addActionListener(l);
        this.add(buttonAdd);

        addComboBoxOptions();
        tableSelector.setPreferredSize(buttonAdd.getPreferredSize());
        tableSelector.addActionListener(l);
        tableSelector.setActionCommand(Command.CHANGE_TABLE_APARTMENTS.name());
        this.add(tableSelector);
    }

    private void addComboBoxOptions() {
        int count = 0;
        for (TableOptions option : TableOptions.values()) {
            tableSelector.insertItemAt(option, count++);
        }
        tableSelector.setSelectedItem(TableOptions.PROPIETARIOS);
    }

    public TableOptions getApartmentTableOption() {
        return (TableOptions) tableSelector.getSelectedItem();
    }
}
