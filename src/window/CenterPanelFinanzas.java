package window;

import javax.swing.JPanel;

public class CenterPanelFinanzas extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TableModel registros;

    public CenterPanelFinanzas() {
        registros = new TableModel();
        // this.setBackground(Color.WHITE);
        this.add(registros);
    }
}
