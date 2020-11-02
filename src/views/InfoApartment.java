package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import controller.Controller;
import java.awt.GridLayout;
import java.awt.Color;

public class InfoApartment extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TextFieldModel apartmentNumber;
    private TextFieldModel propietario;
    private TextFieldModel deudaTotal;
    private JButton showBills;
    private ButtonModel removeApartment;
    private ButtonModel pay;
    private ButtonModel cancel;

    public InfoApartment(Controller controller) {
        this.setLayout(new GridLayout(7, 1, 0, 5));
        this.setBackground(Color.WHITE);
        apartmentNumber = new TextFieldModel(ConstantsGUI.BORDER_NAME_NUMERO_APARTAMENTO);
        propietario = new TextFieldModel(ConstantsGUI.BORDER_NAME_PROPIETARIO);
        deudaTotal = new TextFieldModel(ConstantsGUI.BORDER_NAME_DEUDA);
        showBills = new JButton(ConstantsGUI.NAME_BUTTON_SHOW_BILL);
        removeApartment = new ButtonModel(ConstantsGUI.NAME_BUTTON_DELETE, ConstantsGUI.PATH_IMAGE_DELETE);
        pay = new ButtonModel(ConstantsGUI.NAME_BUTTON_PAY, ConstantsGUI.PATH_IMAGE_PAY);
        cancel = new ButtonModel(ConstantsGUI.NAME_BUTTON_CANCELAR, ConstantsGUI.PATH_IMAGE_DELETE);
        initComponents(controller);
    }

    private void initComponents(Controller l) {
        apartmentNumber.setEditable(false);
        this.add(apartmentNumber);

        propietario.setEditable(false);
        this.add(propietario);

        deudaTotal.setEditable(false);
        this.add(deudaTotal);

        showBills.addActionListener(l);
        showBills.setActionCommand(Command.SHOW_BILLS.name());
        this.add(showBills);

        removeApartment.addActionListener(l);
        removeApartment.setActionCommand(Command.REMOVE_APARTMENT.name());
        this.add(removeApartment);

        pay.addActionListener(l);
        pay.setActionCommand(Command.SHOW_PAY_DIALOG.name());
        this.add(pay);

        cancel.addActionListener(l);
        cancel.setActionCommand(Command.CANCEL_APARTMENT_VIEW.name());
        this.add(cancel);
    }

    public void setInformation(String text, String propietario, String deuda) {
        this.apartmentNumber.setText(text);
        this.propietario.setText(propietario);
        this.deudaTotal.setText(deuda);
    }

    public String getApartment() {
        return apartmentNumber.getText();
    }
}
