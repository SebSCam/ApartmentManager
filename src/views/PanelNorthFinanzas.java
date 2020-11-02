package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNorthFinanzas extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel title;

    public PanelNorthFinanzas() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        initComponents();
    }

    private void initComponents() {
        title = new JLabel(ConstantsGUI.LABEL_TITLE);
        title.setFont(new Font("Segoe", Font.BOLD, 25));
        title.setForeground(Color.black);
        this.add(title);
    }
}
