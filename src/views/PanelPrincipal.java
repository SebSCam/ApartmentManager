package views;

import javax.swing.JPanel;
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

    public PanelPrincipal() {
        this.setLayout(new BorderLayout());
        header = new Header();
        content = new Content();
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
}
