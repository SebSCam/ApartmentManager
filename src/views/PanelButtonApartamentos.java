package views;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controller.Controller;
import models.Apartment;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;

public class PanelButtonApartamentos extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Controller l;

    public PanelButtonApartamentos(Controller listener) {
        l = listener;
        this.setLayout(new GridLayout(0, 8, 20, 10));
        this.setBorder(BorderFactory.createEmptyBorder(0, 35, 25, 35));
        initComponents();
    }

    private void initComponents() {
    }

    public void createApartments(ArrayList<Apartment> apartments) {
        this.removeAll();
        for (Apartment apartment : apartments) {
            JButton button = new JButton();
            button.setText(apartment.getIdNumber());
            button.addActionListener(l);
            button.setActionCommand(Command.VIEW_APARTMENT.name());
            button.addMouseListener(l);
            this.add(button);
        }
    }

    public JButton getSelectedButton() {
        return (JButton) this.getComponentAt(getMousePosition());
    }
}
