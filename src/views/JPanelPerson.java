package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import models.IDType;

import java.awt.Color;
import java.awt.GridLayout;

public class JPanelPerson extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private TextFieldModel name;
    private TextFieldModel lastName;
    private JComboBox<IDType> idType;
    private TextFieldModel idNumber;
    private TextFieldModel cellPhoneNumber;
    private JButton add;
    private JButton cancel;

    public JPanelPerson() {
        this.setLayout(new GridLayout(0,1,0,5));
        name = new TextFieldModel(ConstantsGUI.BORDER_NAME_NAME);
        lastName = new TextFieldModel(ConstantsGUI.BORDER_NAME_LASTNAME);
        idType = new JComboBox<>();
        idType.setBackground(Color.WHITE);
        idType.setBorder(BorderFactory.createTitledBorder(ConstantsGUI.BORDER_NAME_TYPE));
        idNumber = new TextFieldModel(ConstantsGUI.BORDER_NAME_ID);
        cellPhoneNumber = new TextFieldModel(ConstantsGUI.BORDER_NAME_NUMBER);
        add = new JButton(ConstantsGUI.NAME_BUTTON_AGREGAR);
        cancel = new JButton(ConstantsGUI.NAME_BUTTON_CANCELAR);
        this.setBackground(Color.WHITE);
        initComponents();
    }

    private void initComponents() {
        this.add(name);
        this.add(lastName);
        this.add(idType);
        this.add(idNumber);
        this.add(cellPhoneNumber);
        this.add(add);
        this.add(cancel);


    }
}