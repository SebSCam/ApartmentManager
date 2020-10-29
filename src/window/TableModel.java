package window;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;

public class TableModel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private DefaultTableModel dtmElements;
    private JTable table;
    private JScrollPane scroll;

    public TableModel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.decode("#30373D"));
        this.setPreferredSize(new Dimension(900, 570));
        initComponents();
    }

    private void initComponents() {
        dtmElements = new DefaultTableModel() {
            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dtmElements.setColumnIdentifiers(ConstantsGUI.HEADERS_PROPIETARIOS);

        table = new JTable();
        table.setGridColor(Color.decode("#30373D"));
        table.setModel(dtmElements);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setBackground(Color.decode(ConstantsGUI.COLOR_AZUL_PROFUNDO));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(50);
        table.setBackground(Color.WHITE);
        table.setFillsViewportHeight(true);
        scroll = new JScrollPane(table);
        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(scroll, BorderLayout.PAGE_END);
        this.setBorder(null);
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public void addRow(Object[] row) {
        dtmElements.addRow(row);
    }

    public void changeTableHeader(String[] headersRace) {
        dtmElements.setColumnIdentifiers(headersRace);
    }

    public void deleteTable() {
        dtmElements.setRowCount(0);
    }

}