package views;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextFieldModel extends JTextField {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public TextFieldModel(String border) {
        this.setPreferredSize(new Dimension(400, 50));
        this.setBorder(BorderFactory.createTitledBorder(border));
        initComponents();
    }

    private void initComponents() {

    }
}