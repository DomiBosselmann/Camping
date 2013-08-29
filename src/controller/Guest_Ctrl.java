package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Guest_Model;

import org.joda.time.LocalDate;

import entities.Address;
import entities.Guest;
import entities.IdentityCard;
import entities.Phonenumber;

import view.Guest_View;

public class Guest_Ctrl {

	private Guest_View view;
	private Guest_Model model;

	public Guest_Ctrl() {
		super();
		model = new Guest_Model();
		// Guest ad = new Guest();
		// ad.setFirstName("Marius");
		// ad.setLastName("Obert");
		// IdentityCard p = new IdentityCard("MO2409", "Germany");
		// Address a = new Address("Rankach", "30", 77709, "Oberwolfach");
		// ad.setAddress(a);
		// ad.setId(p);
		// modifyGuest(ad);
	}

	/**
	 * Create a new UI and a new model for creating a new Guest object
	 */
	public void createNewGuest() {

		model.setGuest(new Guest());
		init(Guest_View.MODE_CREATE);
		view.addConfirmationtionListener(new CreateListener());
	}

	/**
	 * Create a new UI and a new model for modifying a existing Guest object
	 * 
	 * @param id
	 *            the ID of the existing object
	 */
	public void modifyGuest(Guest entity) {

		model.setGuest(entity);

		init(Guest_View.MODE_MODIFY);

		view.addConfirmationtionListener(new ModifyListener());
		view.addDeleteListener(new DeleteListener());
		view.addChangeModeListener(new ChangeModeListener());
	}

	public void showGuest(Guest entity) {
		this.modifyGuest(entity);
		view.changeMode(Guest_View.MODE_SHOW);
	}

	private void init(int mode) {
		view = new Guest_View();
		view.changeMode(mode);
		model.addObserver(view);
		view.update(model, null);
	}

	class CreateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			LocalDate birthday = view.getBirthdate();
			Address address = view.getAddress();
			IdentityCard id = view.getId();
			Phonenumber number = view.getPhonenumber();

			// if one or more values aren't set
			if (firstName == null || lastName == null || birthday == null
					|| address == null || id == null || number == null) {
				return;
			}
			System.out.println("Create action triggered");
			model.setFirstName(firstName);
			model.setLastName(lastName);
			model.setAddress(address);
			model.setBirthdate(birthday);
			model.setPhonenumber(number);
			model.setId(id);

			model.notifyObservers();

		}
	}

	class ModifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			LocalDate birthday = view.getBirthdate();
			Address address = view.getAddress();
			IdentityCard id = view.getId();

			// if one or more values aren't set
			if (firstName == null || lastName == null || birthday == null
					|| address == null || id == null) {
				return;
			}
			System.out.println("Modify action triggered");
			model.setFirstName(firstName);
			model.setLastName(lastName);
			model.setAddress(address);
			model.setBirthdate(birthday);
			model.setId(id);

			model.notifyObservers();
		}

	}

	class ChangeModeListener implements ItemListener {

		public void itemStateChanged(ItemEvent ev) {
			if (ev.getStateChange() == ItemEvent.SELECTED) {
				view.changeMode(view.MODE_MODIFY);
			} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
				view.changeMode(view.MODE_SHOW);
			}
		}

	}

	class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Delete this entity now");

		}
	}

	class createEquipmentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Create a new Equipment entity now");

		}
	}

}
