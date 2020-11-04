package controller;

import models.Administration;
import models.Apartment;
import views.Command;
import views.InformationDialog;
import views.MainWindow;
import views.Messages;
import views.PersonDialog;
import views.RegistryDialog;
import views.TableOptions;
import views.ApartmentDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

public class Controller implements ActionListener, MouseInputListener {

	private Administration manager;
	private MainWindow window;
	private PersonDialog personDialog;
	private ApartmentDialog apartmentDialog;
	private InformationDialog informationDialog;
	private RegistryDialog registryDialog;

	public Controller() {
		manager = new Administration();
		// manager.addApartment(new Person("Esteban", "Torres", IDType.CC, "21458963", "3114587965"), "1-1");
		// manager.addApartment(new Person("Ivan", "Fernanza", IDType.CC, "43435", "3114587965"), "1-2");
		// manager.addApartment(new Person("Sebastian", "Puerto", IDType.CC, "453445", "3114587965"), "1-3");
		// manager.addApartment(new Person("Daniel", "Luis", IDType.CC, "87678", "3114587965"), "1-4");
		// manager.addApartment(new Person("Carlos", "Torres", IDType.CC, "945345", "3114587965"), "1-5");
		// manager.addApartment(new Person("Esteban", "Torres", IDType.CC, "21458963", "3114587965"), "1-1");
		// manager.addApartment(new Person("Ivan", "Fernanza", IDType.CC, "43435", "3114587965"), "1-2");
		// manager.addApartment(new Person("Sebastian", "Puerto", IDType.CC, "453445", "3114587965"), "1-3");
		// manager.addApartment(new Person("Daniel", "Luis", IDType.CC, "87678", "3114587965"), "1-4");
		// manager.addApartment(new Person("Carlos", "Torres", IDType.CC, "945345", "3114587965"), "1-5");
		// manager.addApartment(new Person("Esteban", "Torres", IDType.CC, "21458963", "3114587965"), "1-1");
		// manager.addApartment(new Person("Ivan", "Fernanza", IDType.CC, "43435", "3114587965"), "1-2");
		// manager.addApartment(new Person("Sebastian", "Puerto", IDType.CC, "453445", "3114587965"), "1-3");
		// manager.addApartment(new Person("Daniel", "Luis", IDType.CC, "87678", "3114587965"), "1-4");
		// manager.addApartment(new Person("Carlos", "Torres", IDType.CC, "945345", "3114587965"), "1-5");
		manager.generatePersonList();

		window = new MainWindow(this);
		personDialog = new PersonDialog(this);
		apartmentDialog = new ApartmentDialog(this, manager.getPersonList());
		informationDialog = new InformationDialog(this);
		registryDialog = new RegistryDialog(this);
		update();
		init();
	}

	private void manageRegistTale(ArrayList<Object[]> registList) {
		ArrayList<Object[]> datasList = registList;
		for (Object[] objects : datasList) {
			window.addLineToRegistTable(objects);
		}
	}

	private void managePersonTable(ArrayList<Object[]> personList) {
		ArrayList<Object[]> datasList = personList;
		for (Object[] objects : datasList) {
			window.addLineToTable(objects);
		}
	}

	private void managePersonDueTable(ArrayList<Object[]> personList) {
		ArrayList<Object[]> dataList = personList;
		for (Object[] objects : dataList) {
			window.addLineToMora(objects);
		}
	}

	private void init() {
		window.setVisible(true);
	}

	private void update() {
		window.deletePersonTable();
		managePersonTable(manager.getPersonListVector(manager.getPersonList()));
		apartmentDialog.uptatePerson(manager.getPersonList());
		window.createApartments(manager.getApartmentList());
		window.deleteRegistTable();
		manageRegistTale(manager.getRegistListVector());
		window.deleteDueTable();
		managePersonDueTable(manager.getPersonListVector(manager.getPersonDueList()));
	}

	public void getPersonList() {
		manager.getPersonList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Command.valueOf(e.getActionCommand())) {
			case ADD_APARTMENT:
				apartmentDialog.setVisible(true);
				update();
				break;
			case REMOVE_APARTMENT:
				manager.removeApartment(informationDialog.getApartmentNumber());
				informationDialog.setVisible(false);
				update();
				break;
			case CREATE_APARTMENT:
				manager.addApartment(apartmentDialog.getPerson(), apartmentDialog.getNumber());
				apartmentDialog.setVisible(false);
				update();
				break;
			case CANCEL_APARTMENT:
				apartmentDialog.setVisible(false);
				break;
			case CANCEL_APARTMENT_VIEW:
				informationDialog.setVisible(false);
				break;
			case SHOW_BILLS:
				Messages.showBills(manager.searchApartment(informationDialog.getApartmentNumber()).getBillList(),
						informationDialog);
				break;
			case ADD_REGISTRY:
				registryDialog.setVisible(true);
				break;

			case CREATE_REGISTRY:
				try {
					manager.addRegist(registryDialog.getRegist());
					registryDialog.setVisible(false);
					update();
				} catch (NullPointerException eX) {
					Messages.showError("Formato de Fecha Incorrecto DD-MM-YYYY");
				} catch (NumberFormatException e1) {
					Messages.showError("Complete todos los campos y verifique el formato");
				}
				break;
			case REMOVE_REGISTRY:
				try {
					manager.getRegistList().remove(window.getSelectedRegist());
					registryDialog.setVisible(false);
					update();
				} catch (Exception exa) {
					Messages.showError("Debes seleccionar un registro a eliminar");
				}
				break;
			case CANCEL_REGISTRY:
				registryDialog.setVisible(false);
				break;
			case SHOW_PAY_DIALOG:
				try {
					manager.payment(Messages
							.getBill(manager.searchApartment(informationDialog.getApartmentNumber()).getBillList()));
					update();
				} catch (Exception sade) {
					JOptionPane.showMessageDialog(null, "No hay facturas por pagar", "Pagos al Dia",
							JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case ADD_PERSON:
				personDialog.setVisible(true);
				break;
			case VIEW_APARTMENT:
				informationDialog.setVisible(true);
				break;
			case EDIT_PERSON:
				try {
					personDialog.setPerson(manager.getPersonList().get(window.getSelectedRow()));
					personDialog.changeButton();
					personDialog.setVisible(true);
				} catch (IndexOutOfBoundsException exception) {
					Messages.showError("Por favor seleccione un Propietario");
				}
				break;
			case CHANGE_PERSON:
				personDialog.setVisible(false);
				manager.editPerson(window.getSelectedRow(), personDialog.getPerson());
				personDialog.revert();
				update();
				break;
			case REMOVE_PERSON:
				try {
					manager.getPersonList().remove(window.getSelectedRow());
					update();

				} catch (IndexOutOfBoundsException e2) {
					Messages.showError("Por favor seleccione un Propietario");
				}
				break;
			case CREATE_PERSON:
				personDialog.setVisible(false);
				manager.addPerson(personDialog.getPerson());
				update();
				break;
			case CANCEL_PERSON:
				personDialog.setVisible(false);
				break;
			case CHANGE_TABLE_APARTMENTS:
				changeApartmentTableContent(window.getApartmentTableOption());
				break;
			default:
				break;
		}
	}

	private void changeApartmentTableContent(TableOptions option) {
		window.createApartments(manager.getFilteredApartmentList(option));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton selectedButton = window.getSelectedButton();
		Apartment apartment = manager.searchApartment(selectedButton.getText());
		informationDialog.setInformation(selectedButton.getText(), apartment.getOwner().toString(),
				String.valueOf(apartment.getBillTotal()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}