package views;

import javax.swing.JPanel;

import controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Color;

public class Content extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Propietarios propietarios;
    private Finanzas finanzas;
    private Cartera cartera;
    private Mora mora;
    private Ajustes ajustes;

    public Content(Controller controller) {
        this.setLayout(new CardLayout());
        this.setBackground(Color.WHITE);
        initComponents(controller);
    }

    private void initComponents(Controller controller) {
        propietarios = new Propietarios(controller);
        finanzas = new Finanzas();
        cartera = new Cartera();
        mora = new Mora();
        ajustes = new Ajustes();

        this.add(ConstantsGUI.NAME_PANEL_PROPIETARIOS, propietarios);
        this.add(ConstantsGUI.NAME_PANEL_FINANZAS, finanzas);
        this.add(ConstantsGUI.NAME_PANEL_CARTERA, cartera);
        this.add(ConstantsGUI.NAME_PANEL_MORA, mora);
        this.add(ajustes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case AJUSTES:
                ((CardLayout) this.getLayout()).last(this);
                break;
            case CARTERA:
                ((CardLayout) this.getLayout()).show(this, ConstantsGUI.NAME_PANEL_CARTERA);
                break;
            case FINANZAS:
                ((CardLayout) this.getLayout()).show(this, ConstantsGUI.NAME_PANEL_FINANZAS);
                break;
            case MORA:
                ((CardLayout) this.getLayout()).show(this, ConstantsGUI.NAME_PANEL_MORA);
                break;
            case PROPIETARIOS:
                ((CardLayout) this.getLayout()).show(this, ConstantsGUI.NAME_PANEL_PROPIETARIOS);
                break;
            default:
                break;
        }
    }

	public int getSelectedRow() {
		return propietarios.getSelectedRow();
	}

	public void addLineToTable(Object[] objects) {
        propietarios.addLineToTable(objects);
	}

	public void deletePersonTable() {
        propietarios.deletePersonTable();
	}
}