package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.joda.time.LocalDate;

import entities.Address;
import entities.AdminEmployee;
import entities.Employee;
import entities.IdentityCard;
import entities.JobTitle;
import entities.Phonenumber;
import entities.ReceptionEmployee;
import entities.TechnicalEmployee;

import model.Employee_Model;
import view.Employee_View;

public class Employee_Ctrl {

	private Employee_View view;
	private Employee_Model model;

	public Employee_Ctrl() {
		super();
		model = new Employee_Model();
		// AdminEmployee ad = new AdminEmployee();
		// ad.setFirstName("Marius");
		// ad.setLastName("Obert");
		// ad.setJobTitle(new JobTitle("Admin"));
		// IdentityCard p = new IdentityCard("MO2409", "Germany");
		// Address a = new Address("Rankach", "30", 77709, "Oberwolfach");
		// ad.setAddress(a);
		// ad.setId(p);
		// showStaff(ad);
	}

	/**
	 * Create a new UI and a new model for creating a new Staff object
	 */
	public void createNewEmployee() {

		String[] possibilities = { "Empfangspersonal",
				"Technischer Angestellter", "Administrator" };
		int createID = JOptionPane.showOptionDialog(null,
				"Welche Mitarbeiterart möchten sie einstellen?",
				"Mitarbeiter anlegen", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, new ImageIcon(), possibilities,
				"Empfangspersonal");
		switch (createID) {
		case 0:
			model.setEmployee(new ReceptionEmployee());
			break;
		case 1:
			model.setEmployee(new TechnicalEmployee());
			break;
		case 2:
			model.setEmployee(new AdminEmployee());
			break;
		default:
			// return without continuing
			return;
		}

		init(Employee_View.MODE_CREATE);
		view.addConfirmationtionListener(new CreateListener());
	}

	/**
	 * Create a new UI and a new model for modifying a existing Staff object
	 * 
	 * @param id
	 *            the ID of the existing object
	 */
	public void modifyEmployee(Employee entity) {
		model.setEmployee(entity);

		init(Employee_View.MODE_MODIFY);

		view.addConfirmationtionListener(new ModifyListener());
		view.addDeleteListener(new DeleteListener());
		view.addChangeModeListener(new ChangeModeListener());
	}

	public void showEmployee(Employee entity) {
		this.modifyEmployee(entity);
		view.changeMode(Employee_View.MODE_SHOW);
	}

	private void init(int mode) {
		view = new Employee_View();
		view.changeMode(mode);
		model.addObserver(view);
		view.update(model, null);
	}

	class CreateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			JobTitle jobTitle = view.getJobTitle();
			String password = view.getPassword();
			LocalDate birthday = view.getBirthdate();
			Address address = view.getAddress();
			IdentityCard id = view.getId();
			Phonenumber number = view.getPhonenumber();
			String insuranceNumber = view.getInsuranceNumber();

			// if one or more values aren't set.
			// in this version the validation of the strength of a chosen
			// password doesn't take place
			if (firstName == null || lastName == null || jobTitle == null
					|| password == null || birthday == null || address == null
					|| id == null || insuranceNumber == null || number == null) {
				return;
			}
			System.out.println("Create action triggered");
			model.setFirstName(firstName);
			model.setLastName(lastName);
			model.setAddress(address);
			model.setBirthdate(birthday);
			model.setId(id);
			model.setPhonenumber(number);
			model.setJobTitle(jobTitle);
			model.setPassword(password);
			model.setInsuranceNumber(insuranceNumber);

			model.notifyObservers();

		}
	}

	class ModifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			JobTitle jobTitle = view.getJobTitle();
			String password = view.getPassword();
			LocalDate birthday = view.getBirthdate();
			Address address = view.getAddress();
			IdentityCard id = view.getId();

			// if one or more values aren't set
			if (firstName == null || lastName == null || jobTitle == null
					|| password == null || birthday == null || address == null
					|| id == null) {
				return;
			}
			System.out.println("Modify action triggered");
			model.setFirstName(firstName);
			model.setLastName(lastName);
			model.setAddress(address);
			model.setBirthdate(birthday);
			model.setId(id);
			model.setJobTitle(jobTitle);
			model.setPassword(password);

			model.notifyObservers();

		}

	}

	class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Delete this entity now");
		}
	}

	class ChangeModeListener implements ItemListener {

		public void itemStateChanged(ItemEvent ev) {
		      if(ev.getStateChange()==ItemEvent.SELECTED){
		        view.changeMode(view.MODE_MODIFY);
		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
		    	  view.changeMode(view.MODE_SHOW);
		      }
		   }

	}
}
