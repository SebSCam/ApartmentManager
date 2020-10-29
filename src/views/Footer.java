package views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Footer extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel description;

    public Footer() {
        description = new JLabel();
        this.setAlignmentX(CENTER_ALIGNMENT);
        initComponents();
    }

    private void initComponents() {
        this.setBackground(Color.decode(ConstantsGUI.COLOR_GRIS_OSCURO));
        description.setText(ConstantsGUI.DESCRIPTION_FOOTER);
        description.setForeground(Color.WHITE);
        this.add(description);
    }
}
