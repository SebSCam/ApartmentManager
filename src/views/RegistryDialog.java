package views;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import controller.Controller;
import models.Bill;

import java.awt.BorderLayout;

public class RegistryDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Header header;
	private PanelRegistry content;
	private Footer footer;

	public RegistryDialog(Controller controller) {
		header = new Header();
		header.setText("Registrar");
		content = new PanelRegistry(controller);
		footer = new Footer();
		this.setSize(400, 500);
		this.setTitle(ConstantsGUI.DIALOG_TITLE_REGISTRY);
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

	public Bill getRegist() throws NullPointerException, NumberFormatException {
		return content.getRegistry();
	}
}