package views;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import controller.Controller;
import java.awt.BorderLayout;

public class InformationDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Header header;
	private JPanelPerson content;
	private Footer footer;

	public InformationDialog(Controller controller) {
		header = new Header();
		header.setText("APARTAMENTO");
		content = new JPanelPerson(controller);
		footer = new Footer();
		this.setSize(600, 400);
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
}