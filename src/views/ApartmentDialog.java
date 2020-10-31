package views;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import controller.Controller;
import models.Person;
import java.awt.BorderLayout;

public class ApartmentDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private Header header;
    private JPanelApartment content;
    private Footer footer;

    public ApartmentDialog(Controller controller, ArrayList<Person> arraylist) {
        header = new Header();
        header.setText("APARTAMENTO");
        content = new JPanelApartment(controller, arraylist);
        footer = new Footer();
        this.setSize(500, 400);
        this.setTitle(ConstantsGUI.DIALOG_TITLE_APARTMENT);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        initComponents();
    }

    private void initComponents() {
        header.setBackground(Color.decode(ConstantsGUI.COLOR_AZUL_PROFUNDO));
        this.add(header, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);

        footer.setBackground(Color.decode(ConstantsGUI.COLOR_GRIS_OSCURO));
        this.add(footer, BorderLayout.SOUTH);
    }

	public void uptatePerson(ArrayList<Person> array) {
        content.updatePerson(array);
	}

	public Person getPerson() {
		return content.getPerson();
	}

	public String getNumber() {
		return content.getNumber();
	}
}