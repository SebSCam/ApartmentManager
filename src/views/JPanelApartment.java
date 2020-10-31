package views;

import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import controller.Controller;
import models.Person;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class JPanelApartment extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TextFieldModel apartmentNumber;
    private JComboBox<Person> personList;
    private JButton newPerson;
    private ButtonModel add;
    private ButtonModel cancel;

    public JPanelApartment(Controller listener, ArrayList<Person> arrayList) {
        this.setLayout(new GridLayout(7, 1, 0, 5));
        this.setBackground(Color.WHITE);
        apartmentNumber = new TextFieldModel(ConstantsGUI.BORDER_NAME_NUMERO_APARTAMENTO);
        personList = new JComboBox<>();
        setPersonList(arrayList);
        personList.setBorder(BorderFactory.createTitledBorder(ConstantsGUI.BORDER_NAME_PERSON));
        personList.setBackground(Color.WHITE);
        newPerson = new JButton(ConstantsGUI.NAME_BUTTON_CREATE);
        add = new ButtonModel(ConstantsGUI.NAME_BUTTON_AGREGAR, ConstantsGUI.PATH_IMAGE_ADD_APARTAMENTO);
        cancel = new ButtonModel(ConstantsGUI.NAME_BUTTON_CANCELAR, ConstantsGUI.PATH_IMAGE_DELETE);
        initComponents(listener);
    }

    private void setPersonList(ArrayList<Person> arrayList) {
        personList.removeAllItems();
        for (Person person : arrayList) {
            personList.addItem(person);
        }
    }

    private void initComponents(ActionListener l) {
        this.add(apartmentNumber);
        this.add(personList);

        newPerson.addActionListener(l);
        newPerson.setActionCommand(Command.ADD_PERSON.name());
        this.add(newPerson);

        this.add(Box.createRigidArea(new Dimension(this.getPreferredSize())));
        this.add(Box.createRigidArea(new Dimension(this.getPreferredSize())));

        add.addActionListener(l);
        add.setActionCommand(Command.CREATE_APARTMENT.name());
        this.add(add);

        cancel.addActionListener(l);
        cancel.setActionCommand(Command.CANCEL_APARTMENT.name());
        this.add(cancel);
    }

    public void updatePerson(ArrayList<Person> arrayList) {
        setPersonList(arrayList);
    }

    public Person getPerson() {
        return (Person) personList.getSelectedItem();
    }

    public String getNumber() {
        return apartmentNumber.getText();
    }
}
