package views;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import models.Apartment;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class PanelButtonApartamentos extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ActionListener l;

    public PanelButtonApartamentos(ActionListener listener) {
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
            this.add(button);
        }
    }
}
