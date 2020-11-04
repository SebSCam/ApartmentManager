package views;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Mora extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel title;
    private TableModel table;

    public Mora() {
        title = new JLabel(ConstantsGUI.LABEL_TITLE_MORA);
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        table = new TableModel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        title.setFont(new Font("Segoe", Font.BOLD, 25));
        title.setForeground(Color.black);
        this.add(title);
        this.add(table);
    }

    public void addLineToMora(Object[] objects) {
        table.addRow(objects);
    }

    public void deleteDueTable() {
        table.deleteTable();
    }
}
