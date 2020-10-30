package views;

import javax.swing.JPanel;

import controller.Controller;

import java.awt.BorderLayout;

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
}
