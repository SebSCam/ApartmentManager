package views;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import models.Apartment;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private Header header;
        private MenuBar menuBar;
        private Content content;
        private Footer footer;

        public PanelPrincipal(Controller controller) {
                this.setLayout(new BorderLayout());
                header = new Header();
                content = new Content(controller);
                menuBar = new MenuBar(content);
                footer = new Footer();
                initComponents();
        }

        private void initComponents() {
                this.add(header, BorderLayout.NORTH);
                this.add(menuBar, BorderLayout.WEST);
                this.add(content, BorderLayout.CENTER);
                this.add(footer, BorderLayout.SOUTH);
        }

        public int getSelectedRow() {
                return content.getSelectedRow();
        }

        public void addLineToTable(Object[] objects) {
                content.addLineToTable(objects);
        }

        public void deletePersonTable() {
                content.deletePersonTable();
        }

        public void createApartments(ArrayList<Apartment> apartmentList) {
                content.createApartments(apartmentList);
        }

        public JButton getSelectedButton() {
                return content.getSelectedButton();
        }

        public void addLineToRegistTable(Object[] objects) {
                content.addLineToRegistTable(objects);
        }

        public int getSelectedRegist() {
                return content.getSelectedRegist();
        }

        public void deleteRegistTable() {
                content.deleteRegistTable();
        }
}
