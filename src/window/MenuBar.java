package window;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private MenuItemModel menuApartamentos;
    private MenuItemModel menuFinanzas;
    private MenuItemModel menuCartera;
    private MenuItemModel menuMora;
    private MenuItemModel menuAjustes;
    private JPanel panelAzul;

    public MenuBar(ActionListener l) {
        this.setLayout(new GridLayout(6, 1));
        menuApartamentos = new MenuItemModel(ConstantsGUI.NAME_MENU_APARTAMENTOS, ConstantsGUI.PATH_IMAGE_APARTAMENTOS);
        menuFinanzas = new MenuItemModel(ConstantsGUI.NAME_MENU_FINANZAS, ConstantsGUI.PATH_IMAGE_FINANZAS);
        menuCartera = new MenuItemModel(ConstantsGUI.NAME_MENU_CARTERA, ConstantsGUI.PATH_IMAGE_CARTERA);
        menuMora = new MenuItemModel(ConstantsGUI.NAME_MENU_MORA, ConstantsGUI.PATH_IMAGE_MORA);
        menuAjustes = new MenuItemModel(ConstantsGUI.NAME_MENU_AJUSTES, ConstantsGUI.PATH_IMAGE_AJUSTES);
        panelAzul = new JPanel();
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

        panelAzul.setBackground(Color.decode(ConstantsGUI.COLOR_AZUL_PROFUNDO));
        this.add(panelAzul);
    }
}