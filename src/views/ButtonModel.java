package views;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonModel extends JButton{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ButtonModel(String name, String path) {
        super(name);
        initComponents(path);
    }

    private void initComponents(String path) {
        this.setIcon(new ImageIcon(getClass().getResource(path)));
    }
}