package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Header extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel description;

    public Header() {
        description = new JLabel();
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setBackground(Color.decode(ConstantsGUI.COLOR_AZUL_PROFUNDO));
        description.setText(ConstantsGUI.DESCRIPTION_HEADER);
        description.setForeground(Color.WHITE);
        this.add(description);
    }

	public void setText(String string) {
        description.setText(string);
	}
}