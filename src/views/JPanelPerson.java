package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import controller.Controller;
import models.IDType;
import models.Person;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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

    public JPanelPerson(Controller listener) {
        this.setLayout(new GridLayout(0, 1, 0, 5));
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
        initComponents(listener);
    }

    private void initComponents(ActionListener l) {
        this.add(name);
        this.add(lastName);
        this.add(idType);
        this.add(idNumber);
        this.add(cellPhoneNumber);

        add.setActionCommand(Command.CREATE_PERSON.name());
        add.addActionListener(l);
        this.add(add);

        cancel.setActionCommand(Command.CANCEL_PERSON.name());
        cancel.addActionListener(l);
        this.add(cancel);

    }

    public void setPerson(Person person) {
        name.setText(person.getName());
        lastName.setText(person.getLastName());
        idType.setSelectedItem(person.getIdType());
        idNumber.setText(person.getIdNumber());
        cellPhoneNumber.setText(person.getCellPhoneNumber());
    }

    public Person getPerson() {
        return new Person(name.getText(), lastName.getText(), (IDType) idType.getSelectedItem(), idNumber.getText(),
                cellPhoneNumber.getText());
    }
}