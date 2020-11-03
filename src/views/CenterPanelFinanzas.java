package views;

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
       
        initComponents();
    }

    private void initComponents() {
        registros.changeTableHeader(ConstantsGUI.HEADERS_FINANZAS);
        this.add(registros);
    }
}
