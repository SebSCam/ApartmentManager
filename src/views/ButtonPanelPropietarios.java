package views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ButtonPanelPropietarios extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonModel buttonAdd;
    private ButtonModel buttonEdit;
    private ButtonModel buttonDelete;

    public ButtonPanelPropietarios(ActionListener l) {
        this.setLayout(new FlowLayout());
        buttonAdd = new ButtonModel(ConstantsGUI.NAME_BUTTON_AGREGAR, ConstantsGUI.PATH_IMAGE_ADD);
        buttonEdit = new ButtonModel(ConstantsGUI.NAME_BUTTON_EDIT, ConstantsGUI.PATH_IMAGE_EDIT);
        buttonDelete = new ButtonModel(ConstantsGUI.NAME_BUTTON_DELETE, ConstantsGUI.PATH_IMAGE_DELETE);
        initComponents(l);
    }

    private void initComponents(ActionListener l) {
        buttonAdd.setActionCommand(Command.ADD_PERSON.name());
        buttonAdd.addActionListener(l);
        this.add(buttonAdd);

        buttonEdit.setActionCommand(Command.EDIT_PERSON.name());
        buttonEdit.addActionListener(l);
        this.add(buttonEdit);

        buttonDelete.setActionCommand(Command.REMOVE_PERSON.name());
        buttonDelete.addActionListener(l);
        this.add(buttonDelete);

    }

}
