package views;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JDialog;

import controller.Controller;
import models.Person;
import java.awt.BorderLayout;

public class PersonDialog extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Header header;
	private JPanelPerson content;
	private Footer footer;

	public PersonDialog(ArrayList<Person> arrayList, Controller controller) {
		header = new Header();
		header.setText("PROPIETARIO");
		content = new JPanelPerson(controller);
		footer = new Footer();
		this.setSize(300, 500);
		this.setTitle(ConstantsGUI.DIALOG_TITLE);
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

	public Person getPerson() {
		return content.getPerson();
	}

	public String getNumber() {
		return null;
	}

	public void setPerson(Person person) {
		content.setPerson(person);
	}
}