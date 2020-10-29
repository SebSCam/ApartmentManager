package window;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Finanzas extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private PanelNorthFinanzas panelNorth;
    private ButtonPanelFinanzas buttonPanel;
    private CenterPanelFinanzas centerPanel;

    public Finanzas() {
        panelNorth = new PanelNorthFinanzas();
        buttonPanel = new ButtonPanelFinanzas();
        centerPanel = new CenterPanelFinanzas();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.EAST);
        this.add(centerPanel, BorderLayout.CENTER);
    }
}