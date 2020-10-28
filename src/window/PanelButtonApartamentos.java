package window;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import models.Apartment;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;

public class PanelButtonApartamentos extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PanelButtonApartamentos() {
        this.setLayout(new GridLayout(0, 8, 20, 10));
        this.setBorder(BorderFactory.createEmptyBorder(0, 35, 25, 35));
        initComponents();
    }

    private void initComponents() {
    }

    public void createApartments(ArrayList<Apartment> apartments) {
        for (Apartment apartment : apartments) {
            this.add(new JButton(apartment.getIdNumber()));
        }
    }
}
