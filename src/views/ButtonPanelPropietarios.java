package views;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ButtonPanelPropietarios extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonModel buttonAdd;
    private ButtonModel buttonEdit;
    private ButtonModel buttonDelete;
    private JComboBox<TableOptions> tableSelector;

    public ButtonPanelPropietarios() {
        this.setLayout(new FlowLayout());
        buttonAdd = new ButtonModel(ConstantsGUI.NAME_BUTTON_AGREGAR, ConstantsGUI.PATH_IMAGE_ADD);
        buttonEdit = new ButtonModel(ConstantsGUI.NAME_BUTTON_EDIT, ConstantsGUI.PATH_IMAGE_EDIT);
        buttonDelete = new ButtonModel(ConstantsGUI.NAME_BUTTON_DELETE, ConstantsGUI.PATH_IMAGE_DELETE);
        tableSelector = new JComboBox<TableOptions>();
        initComponents();
    }

    private void initComponents() {
        this.add(buttonAdd);
        this.add(buttonEdit);
        this.add(buttonDelete);
        addComboBoxOptions();
        tableSelector.setPreferredSize(buttonAdd.getPreferredSize());
        this.add(tableSelector);
    }

    private void addComboBoxOptions() {
        int count = 0;
        for (TableOptions option : TableOptions.values()) {
			tableSelector.insertItemAt(option, count++);
        }
        tableSelector.setSelectedItem(TableOptions.PROPIETARIOS);
    }
}
