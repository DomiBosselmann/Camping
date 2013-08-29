package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import model.Employee_Model;

import org.joda.time.LocalDate;

import Util.ApplicationCore;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

import entities.Address;
import entities.AdminEmployee;
import entities.Employee;
import entities.IdentityCard;
import entities.JobTitle;
import entities.Phonenumber;
import entities.ReceptionEmployee;
import entities.TechnicalEmployee;

public class Employee_View extends JFrame implements ViewForm_Intf {

	private int currentMode;

	private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	private JLabel lbl_firstName, lbl_lastName, lbl_jobTitle, lbl_streetName,
			lbl_phonenumber, lbl_houseNo, lbl_City, lbl_zipCode, lbl_password,
			lbl_insuranceNumber, lbl_country, lbl_birthdate, lbl_IdNumber,
			lbl_headline, lbl_orgUnit;
	private JTextField tf_firstName, tf_lastName, tf_streetName,
			tf_phonenumber, tf_orgUnit, tf_houseNo, tf_city, tf_country,
			tf_IdNumber, tf_insuranceNumber;
	private JFormattedTextField tf_zipCode, tf_birthdate;
	private JPasswordField pf_password;
	private JComboBox dd_jobTitle;
	private JButton btn_exec, btn_delete;
	private JToggleButton btn_modify;

	public Employee_View() {
		super();
		init();
		this.setSize(420, 420);
		this.setVisible(true);
	}

	public void addConfirmationtionListener(ActionListener al) {
		btn_exec.addActionListener(al);
		pf_password.addActionListener(al);
	}

	public void addChangeModeListener(ItemListener il) {
		btn_modify.addItemListener(il);
	}

	public void changeMode(int mode) {
		currentMode = mode;
		switch (mode) {
		case MODE_SHOW:
			btn_exec.setVisible(false);
			btn_delete.setVisible(true);
			btn_modify.setVisible(true);
			btn_modify.setSelected(false);
			btn_modify.setText("Mitarbeiter bearbeiten");
			lbl_headline.setVisible(true);
			this.setTitle("Mitarbeiter anzeigen");

			tf_orgUnit.setEditable(false);
			tf_insuranceNumber.setEditable(false);
			tf_firstName.setEditable(false);
			tf_lastName.setEditable(false);
			tf_phonenumber.setEditable(false);
			tf_streetName.setEditable(false);
			tf_houseNo.setEditable(false);
			tf_city.setEditable(false);
			tf_country.setEditable(false);
			tf_IdNumber.setEditable(false);
			tf_zipCode.setEditable(false);
			tf_birthdate.setEditable(false);
			pf_password.setEditable(false);
			break;
		case MODE_MODIFY:
			btn_exec.setVisible(true);
			btn_exec.setText("Änderungen speichern");
			btn_delete.setVisible(true);
			btn_modify.setVisible(true);
			btn_modify.setSelected(true);
			btn_modify.setText("Mitarbeiter anzeigen");
			lbl_headline.setVisible(true);
			this.setTitle("Mitarbeiter bearbeiten");

			tf_orgUnit.setEditable(false);
			tf_insuranceNumber.setEditable(true);
			tf_firstName.setEditable(true);
			tf_lastName.setEditable(true);
			tf_phonenumber.setEditable(true);
			tf_streetName.setEditable(true);
			tf_houseNo.setEditable(true);
			tf_city.setEditable(true);
			tf_country.setEditable(true);
			tf_IdNumber.setEditable(true);
			tf_zipCode.setEditable(true);
			tf_birthdate.setEditable(true);
			pf_password.setEditable(true);
			break;
		case MODE_CREATE:
			btn_exec.setVisible(true);
			btn_exec.setText("Mitarbeiter einstellen");
			btn_delete.setVisible(false);
			btn_modify.setVisible(false);
			lbl_headline.setVisible(false);
			this.setTitle("Mitarbeiter einstellen");

			tf_firstName.setEditable(true);
			tf_insuranceNumber.setEditable(true);
			tf_orgUnit.setEditable(false);
			tf_lastName.setEditable(true);
			tf_phonenumber.setEditable(true);
			tf_streetName.setEditable(true);
			tf_houseNo.setEditable(true);
			tf_city.setEditable(true);
			tf_country.setEditable(true);
			tf_IdNumber.setEditable(true);
			tf_zipCode.setEditable(true);
			tf_birthdate.setEditable(true);
			pf_password.setEditable(true);
			break;
		default:
			throw new RuntimeException("Undefined integer value");
		}
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setGroupingUsed(false);

		// instantiate all panels and layouts
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JPanel categoryHeader = new JPanel();
		categoryHeader.setLayout(new GridLayout(0, 2));
		JPanel categoryID = new JPanel();
		categoryID.setLayout(new GridLayout(0, 2));
		JPanel categoryJob = new JPanel();
		categoryJob.setLayout(new GridLayout(0, 2));
		JPanel categoryPerson = new JPanel();
		categoryPerson.setLayout(new GridLayout(0, 2));
		this.setLayout(new BorderLayout());

		// instantiate all controls
		lbl_firstName = new JLabel("Vorname:");
		lbl_lastName = new JLabel("Nachname:");
		lbl_jobTitle = new JLabel("Berufsbezeichnung:");
		lbl_insuranceNumber = new JLabel("Sozialversicherungsnummer:");
		lbl_phonenumber = new JLabel("Telefonnummer:");
		lbl_streetName = new JLabel("Straße:");
		lbl_houseNo = new JLabel("Hausnummer:");
		lbl_orgUnit = new JLabel("Organisationseinheit:");
		lbl_City = new JLabel("Stadt:");
		lbl_zipCode = new JLabel("PLZ:");
		lbl_password = new JLabel("Passwort:");
		lbl_country = new JLabel("Ausstellungsland:");
		lbl_birthdate = new JLabel("Geburtsdatum:");
		lbl_IdNumber = new JLabel("Personalausweisnummer:");
		lbl_headline = new JLabel();
		tf_firstName = new JTextField();
		tf_lastName = new JTextField();
		dd_jobTitle = new JComboBox();
		tf_insuranceNumber = new JTextField();
		tf_orgUnit = new JTextField();
		tf_streetName = new JTextField();
		tf_houseNo = new JTextField();
		tf_city = new JTextField();
		tf_zipCode = new JFormattedTextField(nf);
		pf_password = new JPasswordField();
		tf_country = new JTextField();
		tf_birthdate = new JFormattedTextField(dateFormat);
		tf_phonenumber = new JTextField();
		tf_IdNumber = new JTextField();
		btn_exec = new JButton();
		btn_delete = new JButton("Mitarbeiter löschen");
		btn_modify = new JToggleButton();

		// modify the attributes of the controls
		Font curFont = lbl_headline.getFont();
		lbl_headline.setFont(new Font(curFont.getFontName(),
				curFont.getStyle(), 20));
		lbl_headline.setHorizontalAlignment(SwingConstants.CENTER);
		btn_modify.setMnemonic(KeyEvent.VK_E);
		btn_delete.setMnemonic(KeyEvent.VK_L);
		btn_exec.setMnemonic(KeyEvent.VK_S);
		dd_jobTitle.setEditable(false);

		// map the controls to the panels
		categoryHeader.add(btn_delete);
		categoryHeader.add(btn_modify);

		centerPanel.add(categoryHeader);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		categoryJob.add(lbl_orgUnit);
		categoryJob.add(tf_orgUnit);
		categoryJob.add(lbl_jobTitle);
		categoryJob.add(dd_jobTitle);

		centerPanel.add(categoryJob);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		categoryID.add(lbl_IdNumber);
		categoryID.add(tf_IdNumber);
		categoryID.add(lbl_country);
		categoryID.add(tf_country);
		categoryID.add(lbl_insuranceNumber);
		categoryID.add(tf_insuranceNumber);

		centerPanel.add(categoryID);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		categoryPerson.add(lbl_firstName);
		categoryPerson.add(tf_firstName);
		categoryPerson.add(lbl_lastName);
		categoryPerson.add(tf_lastName);
		categoryPerson.add(lbl_birthdate);
		categoryPerson.add(tf_birthdate);
		categoryPerson.add(lbl_phonenumber);
		categoryPerson.add(tf_phonenumber);
		categoryPerson.add(lbl_streetName);
		categoryPerson.add(tf_streetName);
		categoryPerson.add(lbl_houseNo);
		categoryPerson.add(tf_houseNo);
		categoryPerson.add(lbl_zipCode);
		categoryPerson.add(tf_zipCode);
		categoryPerson.add(lbl_City);
		categoryPerson.add(tf_city);
		categoryPerson.add(lbl_password);
		categoryPerson.add(pf_password);

		centerPanel.add(categoryPerson);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		this.add(lbl_headline, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(btn_exec, BorderLayout.SOUTH);
	}

	public JobTitle getJobTitle() {
		return (JobTitle) dd_jobTitle.getSelectedItem();
	}

	public String getPassword() {
		String ret = pf_password.getPassword().toString();
		return (ret.equals("")) ? null : ret;
	}

	public String getInsuranceNumber() {
		String ret = tf_insuranceNumber.getText();
		return (ret.equals("")) ? null : ret;
	}

	public Address getAddress() {
		String street = tf_streetName.getText();
		String houseNo = tf_houseNo.getText();
		String city = tf_city.getText();
		int zipCode = -1;
		try {
			zipCode = Integer.parseInt(tf_zipCode.getText());
		} catch (NumberFormatException e) {
			return null;
		}
		// all values are set an the zipCode has between 4 and 7 digits
		return (street.equals("") || houseNo.equals("") || city.equals("")
				|| zipCode < 1000 || zipCode > 9999999) ? null : new Address(
				street, houseNo, zipCode, city);
	}

	public IdentityCard getId() {
		String IdNum = tf_IdNumber.getText();
		String country = tf_country.getText();

		return (IdNum.equals("") || country.equals("")) ? null
				: new IdentityCard(IdNum, country);
	}

	public Phonenumber getPhonenumber() {
		Phonenumber myNumber = null;
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

		try {
			PhoneNumber number = phoneUtil
					.parse(tf_phonenumber.getText(), "DE");
			myNumber = new Phonenumber();
			myNumber.setCountry(number.getCountryCode());
			myNumber.setNationalNumber(number.getNationalNumber());
			if (number.getCountryCodeSource().equals(
					CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN)) {
				myNumber.setBeginningWithPlusSign(true);
			}
		} catch (NumberParseException e) {
			System.err.println("NumberParseException was thrown: "
					+ e.toString());
		}
		return myNumber;
	}

	public String getFirstName() {
		String ret = tf_firstName.getText();
		return (ret.equals("")) ? null : ret;
	}

	public String getLastName() {
		String ret = tf_lastName.getText();
		return (ret.equals("")) ? null : ret;
	}

	public LocalDate getBirthdate() {
		String date = tf_birthdate.getText();
		try {
			return new LocalDate(dateFormat.parse(date));
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public void showFeedback(int feedback) {
		switch (feedback) {
		case SAVE_SUCCESS:
			if (currentMode == MODE_CREATE) {
				JOptionPane
						.showMessageDialog(this,
								"Der neue Angestellte konnte erfolgreich angelegt werden.");
			} else {
				JOptionPane
						.showMessageDialog(this,
								"Die Mitarbeiterdaten konnten erfolgreich geändert werden.");
			}

			break;
		case SAVE_INCOMPLETE:
			JOptionPane.showMessageDialog(this,
					"Ihre Daten sind leider nicht valide/vollständig.",
					"Warnung", JOptionPane.WARNING_MESSAGE);
			break;
		case SAVE_FAILURE:
			JOptionPane.showMessageDialog(this,
					"Der Mitarbeiter konnte leider nicht gespeichert werden.",
					"Speicherfehler", JOptionPane.ERROR_MESSAGE);
			break;
		case DELETE_SUCCESS:
			JOptionPane.showMessageDialog(this,
					"Der Mitarbeiter konnten erfolgreich gelöscht werden.");
			break;
		case DELETE_FAILURE:
			JOptionPane.showMessageDialog(this,
					"Der Mitarbeiter konnte leider nicht gelöscht werden.",
					"Löschfehler", JOptionPane.ERROR_MESSAGE);
			break;
		default:
			throw new RuntimeException("Undefined integer value");
		}
	}

	@Override
	public void update(Observable modelObservable, Object arg) {
		if (modelObservable instanceof Employee_Model) {
			Employee_Model model = (Employee_Model) modelObservable;

			String birthdate = null;
			if (model.getBirthdate() != null) {
				birthdate = dateFormat.format(model.getBirthdate());
			}
			if (currentMode != this.MODE_CREATE) {
				lbl_headline.setText(model.toString());
				tf_firstName.setText(model.getFirstName());
				tf_lastName.setText(model.getLastName());
				pf_password.setText(model.getPassword());
				tf_birthdate.setText(birthdate);
				if (model.getPhonenumber().isBeginningWithPlusSign()) {
					tf_phonenumber.setText("+"
							+ model.getPhonenumber().getCountry() + ""
							+ model.getPhonenumber().getNationalNumber());
				} else {
					tf_phonenumber.setText(model.getPhonenumber().getCountry()
							+ "" + model.getPhonenumber().getNationalNumber());
				}

				tf_streetName.setText(model.getAdress().getStreetName());
				tf_houseNo.setText(model.getAdress().getHouseNumber());
				tf_city.setText(model.getAdress().getCity());
				tf_zipCode.setText(model.getAdress().getZipCode() + "");
				tf_country.setText(model.getId().getAuthority());
				tf_IdNumber.setText(model.getId().getId());
				tf_insuranceNumber.setText(model.getInsuranceNumber());
			}
			int type = 0;
			if (model.getEmployee() instanceof ReceptionEmployee) {
				tf_orgUnit.setText("Empfang");
				type = Employee.RECEPTION;
			} else if (model.getEmployee() instanceof TechnicalEmployee) {
				tf_orgUnit.setText("Technik");
				type = Employee.TECHNICAL;
			} else if (model.getEmployee() instanceof AdminEmployee) {
				tf_orgUnit.setText("Administration");
				type = Employee.ADMIN;
			}
			List<JobTitle> possibleJobTitles = ApplicationCore.provider
					.getJobTitles(type);
			// new object, because that's the only easy way to set an array as
			// model
			DefaultComboBoxModel jobTitles = new DefaultComboBoxModel(
					possibleJobTitles.toArray());
			dd_jobTitle.setModel(jobTitles);
		} else {
			throw new RuntimeException("Undefined model instance");
		}
	}

	@Override
	public void addDeleteListener(ActionListener al) {
		btn_delete.addActionListener(al);

	}

}
