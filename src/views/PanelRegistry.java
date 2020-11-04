package views;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import controller.Controller;
import models.Bill;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;

public class PanelRegistry extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JComboBox<Concept> concept;
    private TextFieldModel name;
    private JDateChooser calendar;
    private TextFieldModel monto;
    private JComboBox<String> registryType;
    private ButtonModel registButton;
    private ButtonModel cancelButton;

    public PanelRegistry(Controller controller) {
        this.setLayout(new GridLayout(7, 1, 0, 5));
        this.setBackground(Color.WHITE);
        concept = new JComboBox<>();

        name = new TextFieldModel(ConstantsGUI.BORDER_NAME_NOMBRE);
        calendar = new JDateChooser();

        monto = new TextFieldModel(ConstantsGUI.BORDER_NAME_MONTO);

        registryType = new JComboBox<>();

        registButton = new ButtonModel(ConstantsGUI.NAME_BUTTON_REGISTRAR, ConstantsGUI.PATH_IMAGE_REGISTRAR);
        cancelButton = new ButtonModel(ConstantsGUI.NAME_BUTTON_CANCELAR, ConstantsGUI.PATH_IMAGE_DELETE);
        initComponents(controller);
    }

    private void initComponents(ActionListener l) {
        this.add(name);
        this.add(monto);

        concept.setBackground(Color.WHITE);
        concept.setBorder(BorderFactory.createTitledBorder(ConstantsGUI.BORDER_NAME_CONCEPT));
        addConceptItems();
        this.add(concept);

        calendar.setBackground(Color.WHITE);
        calendar.setBorder(BorderFactory.createTitledBorder(ConstantsGUI.BORDER_NAME_DATE));
        this.add(calendar);

        registryType.setBackground(Color.WHITE);
        registryType.setBorder(BorderFactory.createTitledBorder(ConstantsGUI.BORDER_NAME_TYPE_REG));
        addTypeItems();
        this.add(registryType);

        registButton.addActionListener(l);
        registButton.setActionCommand(Command.CREATE_REGISTRY.name());
        this.add(registButton);

        cancelButton.addActionListener(l);
        cancelButton.setActionCommand(Command.CANCEL_REGISTRY.name());
        this.add(cancelButton);
    }

    private void addTypeItems() {
        String[] items = new String[] { "Entrada", "Salida" };
        for (int i = 0; i < items.length; i++) {
            String text = items[i];
            registryType.addItem(text);
        }
    }

    private void addConceptItems() {
        for (Concept concepts : Concept.values()) {
            concept.addItem(concepts);
        }
    }

    public Bill getRegistry() throws NullPointerException, NumberFormatException {
        Bill bill = new Bill(getLocalTime(), (Concept) concept.getSelectedItem(), name.getText(),
                String.valueOf(registryType.getSelectedItem()));
        bill.setAmount(Double.parseDouble(monto.getText()));
        return bill;
    }

    private LocalDate getLocalTime() throws NullPointerException {
        Calendar date = calendar.getCalendar();
        return LocalDate.of(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
    }
}