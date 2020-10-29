package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.event.MouseInputListener;

public class MenuItemModel extends JMenuItem implements MouseInputListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MenuItemModel(String nameMenuApartamentos, String path) {
        super(nameMenuApartamentos);
        this.setHorizontalAlignment(CENTER);
        this.setLayout(new GridLayout(1, 0));
        this.addMouseListener(this);
        initComponents(path);
    }

    private void initComponents(String path) {
        this.setIcon(new ImageIcon(getClass().getResource(path)));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode(ConstantsGUI.COLOR_AZUL_PROFUNDO)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.decode(ConstantsGUI.COLOR_AZUL_CLARO));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}