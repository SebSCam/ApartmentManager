package views;

import javax.swing.JFrame;

import controller.Controller;

import java.awt.Toolkit;

public class MainWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private PanelPrincipal panelPrincipal;

    public MainWindow(Controller controller) {
        this.setTitle("Administrador y Finanzas Soft");
        // this.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
        this.setLocationRelativeTo(null);
        this.setSize(600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        panelPrincipal = new PanelPrincipal(controller);
        initComponents();
    }

    private void initComponents() {
        this.add(panelPrincipal);
    }
}