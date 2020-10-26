package window;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JMenuItem menuApartamentos;
    private JMenuItem menuFinanzas;
    private JMenuItem menuCartera;
    private JMenuItem menuMora;
    private JMenuItem menuAjustes;

    public MenuBar(ActionListener l) {
        this.setLayout(new GridLayout(0, 1));
        menuApartamentos = new JMenuItem(ConstantsGUI.NAME_MENU_APARTAMENTOS);
        menuFinanzas = new JMenuItem(ConstantsGUI.NAME_MENU_FINANZAS);
        menuCartera = new JMenuItem(ConstantsGUI.NAME_MENU_CARTERA);
        menuMora = new JMenuItem(ConstantsGUI.NAME_MENU_MORA);
        menuAjustes = new JMenuItem(ConstantsGUI.NAME_MENU_AJUSTES);
        initComponents(l);
    }

    private void initComponents(ActionListener l) {
        menuApartamentos.addActionListener(l);
        menuApartamentos.setActionCommand(Command.PROPIETARIOS.name());
        this.add(menuApartamentos);

        menuFinanzas.addActionListener(l);
        menuFinanzas.setActionCommand(Command.FINANZAS.name());
        this.add(menuFinanzas);

        menuCartera.addActionListener(l);
        menuCartera.setActionCommand(Command.CARTERA.name());
        this.add(menuCartera);

        menuMora.addActionListener(l);
        menuMora.setActionCommand(Command.MORA.name());
        this.add(menuMora);

        menuAjustes.addActionListener(l);
        menuAjustes.setActionCommand(Command.AJUSTES.name());
        this.add(menuAjustes);
    }
}
