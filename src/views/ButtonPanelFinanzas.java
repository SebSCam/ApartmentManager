package views;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controller.Controller;
import java.awt.GridLayout;

public class ButtonPanelFinanzas extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonModel registry;
    private ButtonModel delete;

    public ButtonPanelFinanzas(Controller controller) {
        this.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 85));
        ;
        this.setLayout(new GridLayout(10, 1, 50, 20));
        registry = new ButtonModel(ConstantsGUI.NAME_BUTTON_REGISTRAR, ConstantsGUI.PATH_IMAGE_REGISTRAR);
        delete = new ButtonModel(ConstantsGUI.NAME_BUTTON_DELETE, ConstantsGUI.PATH_IMAGE_DELETE);
        initComponents(controller);
    }

    private void initComponents(Controller l) {
        registry.setActionCommand(Command.ADD_REGISTRY.name());
        registry.addActionListener(l);
        this.add(registry);
        this.add(delete);
    }
}