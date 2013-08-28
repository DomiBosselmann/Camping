package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import TestClasses.myClass;

import Entities.Booking_Status;
import Entities.Guest;
import Entities.Reservation;

public class Booking_View extends JFrame implements ViewForm_Intf {

	private int currentMode;
	private DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");

	private JLabel lbl_headline, lbl_startDate, lbl_finishDate, lbl_guest,
			lbl_status, lbl_pitch, lbl_reservation, lbl_generateTasks,
			lbl_numberNights, lbl_pricePerNight, lbl_priceOverAll;
	private JTextField tf_numberNights, tf_pricePerNight, tf_priceOverAll;
	private JFormattedTextField tf_startDate, tf_finishDate;
	private JComboBox dd_guest, dd_pitches, dd_status;
	private JCheckBox cb_generateTasks;
	private JButton btn_exec, btn_delete, btn_reservation;
	private JToggleButton btn_modify;

	public Booking_View() throws HeadlessException {
		super();
		init();
		this.setSize(450, 370);
		this.setVisible(true);
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// instantiate all panels and layouts
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JPanel categoryHeader = new JPanel();
		categoryHeader.setLayout(new GridLayout(0, 2));
		JPanel categoryInput = new JPanel();
		categoryInput.setLayout(new GridLayout(0, 2));
		JPanel categoryOutput = new JPanel();
		categoryOutput.setLayout(new GridLayout(0, 2));
		this.setLayout(new BorderLayout());

		// instantiate all controls
		lbl_startDate = new JLabel("Zeitraum von:");
		lbl_finishDate = new JLabel("Zeitraum bis:");
		lbl_guest = new JLabel("Gast");
		lbl_pitch = new JLabel("Stellplatz");
		lbl_generateTasks = new JLabel("generiere Aufgaben");
		lbl_reservation = new JLabel("zusätzliche Reservierung");
		lbl_numberNights = new JLabel("Anzahl Übernachtungen");
		lbl_pricePerNight = new JLabel("Preis pro Nacht");
		lbl_priceOverAll = new JLabel("Gesamtpreis");
		lbl_status = new JLabel("Status");
		lbl_headline = new JLabel();
		dd_status = new JComboBox();
		dd_guest = new JComboBox();
		dd_pitches = new JComboBox();
		cb_generateTasks = new JCheckBox();
		tf_numberNights = new JTextField();
		tf_pricePerNight = new JTextField();
		tf_priceOverAll = new JTextField();
		tf_startDate = new JFormattedTextField(dateFormat);
		tf_finishDate = new JFormattedTextField(dateFormat);
		btn_exec = new JButton();
		btn_delete = new JButton("Buchung löschen");
		btn_modify = new JToggleButton();
		btn_reservation = new JButton("Neue Reservierung anlegen");

		// modify the attributes of the controls
		Font curFont = lbl_headline.getFont();
		lbl_headline.setFont(new Font(curFont.getFontName(),
				curFont.getStyle(), 20));
		lbl_headline.setHorizontalAlignment(SwingConstants.CENTER);
		tf_numberNights.setEnabled(false);
		tf_priceOverAll.setEnabled(false);
		tf_pricePerNight.setEnabled(false);
		btn_reservation.setEnabled(false);
		btn_modify.setMnemonic(KeyEvent.VK_M);
		btn_delete.setMnemonic(KeyEvent.VK_D);
		btn_exec.setMnemonic(KeyEvent.VK_S);
		// TODO drop downs füllen, besser in update
		// TODO panel für ausgewählte reservierungen

		// map the controls to the panels
		categoryHeader.add(btn_delete);
		categoryHeader.add(btn_modify);

		centerPanel.add(categoryHeader);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		categoryInput.add(lbl_startDate);
		categoryInput.add(tf_startDate);
		categoryInput.add(lbl_finishDate);
		categoryInput.add(tf_finishDate);
		categoryInput.add(lbl_guest);
		categoryInput.add(dd_guest);
		categoryInput.add(lbl_pitch);
		categoryInput.add(dd_pitches);
		categoryInput.add(lbl_reservation);
		categoryInput.add(btn_reservation);
		categoryInput.add(cb_generateTasks);
		categoryInput.add(lbl_generateTasks);
		categoryInput.add(lbl_status);
		categoryInput.add(dd_status);

		centerPanel.add(categoryInput);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		categoryOutput.add(lbl_numberNights);
		categoryOutput.add(tf_numberNights);
		categoryOutput.add(lbl_pricePerNight);
		categoryOutput.add(tf_pricePerNight);
		categoryOutput.add(lbl_priceOverAll);
		categoryOutput.add(tf_priceOverAll);

		centerPanel.add(categoryOutput);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		this.add(lbl_headline, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(btn_exec, BorderLayout.SOUTH);
	}

	@Override
	public void update(Observable modelObservable, Object arg) {
		// if (modelObservable instanceof Booking_Model) {
		// Booking_Model model = (Employee_Model) modelObservable;
		// if (currentMode != this.MODE_CREATE) {
		// lbl_headline.setText(model.toString());
		//
		//
		// }
		// } else {
		// throw new RuntimeException("Undefined model instance");
		// }
	}

	@Override
	public void addConfirmationtionListener(ActionListener al) {
		btn_exec.addActionListener(al);

	}

	@Override
	public void addDeleteListener(ActionListener al) {
		btn_delete.addActionListener(al);

	}

	@Override
	public void addChangeModeListener(ItemListener il) {
		btn_modify.addItemListener(il);
	}

	@Override
	public void changeMode(int mode) {
		currentMode = mode;
		switch (mode) {
		case MODE_SHOW:
			btn_exec.setVisible(false);
			btn_delete.setVisible(true);
			btn_modify.setVisible(true);
			btn_modify.setSelected(false);
			btn_modify.setText("Buchung ändern");
			lbl_headline.setVisible(true);
			this.setTitle("Buchung anzeigen");

			break;
		case MODE_MODIFY:
			btn_exec.setVisible(true);
			btn_exec.setText("Änderungen speichern");
			btn_delete.setVisible(true);
			btn_modify.setVisible(true);
			btn_modify.setSelected(true);
			btn_modify.setText("Buchung anzeigen");
			lbl_headline.setVisible(true);
			this.setTitle("Buchung bearbeiten");
			break;
		case MODE_CREATE:
			btn_exec.setVisible(true);
			btn_exec.setText("Buchung anlegen");
			btn_delete.setVisible(false);
			btn_modify.setVisible(false);
			lbl_headline.setVisible(false);
			this.setTitle("Buchung anlegen");
			break;
		default:
			throw new RuntimeException("Undefined integer value");
		}

	}

	@Override
	public void showFeedback(int feedback) {
		switch (feedback) {
		case SAVE_SUCCESS:
			if (currentMode == MODE_CREATE) {
				JOptionPane.showMessageDialog(this,
						"Die neue Buchung konnte erfolgreich angelegt werden.");
			} else {
				JOptionPane.showMessageDialog(this,
						"Die Buchung konnten erfolgreich geändert werden.");
			}

			break;
		case SAVE_INCOMPLETE:
			JOptionPane.showMessageDialog(this,
					"Ihre Daten sind leider nicht valide/vollständig.",
					"Warnung", JOptionPane.WARNING_MESSAGE);
			break;
		case SAVE_FAILURE:
			JOptionPane.showMessageDialog(this,
					"Die Buchung konnte leider nicht gespeichert werden.",
					"Speicherfehler", JOptionPane.ERROR_MESSAGE);
			break;
		case DELETE_SUCCESS:
			JOptionPane.showMessageDialog(this,
					"Die Buchung konnte erfolgreich gelöscht werden.");
			break;
		case DELETE_FAILURE:
			JOptionPane.showMessageDialog(this,
					"Die Buchung konnte leider nicht gelöscht werden.",
					"Löschfehler", JOptionPane.ERROR_MESSAGE);
			break;
		default:
			throw new RuntimeException("Undefined integer value");
		}
	}

	public ArrayList<Reservation> getReservations() {
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		// TODO Implemetation

		return list;
	}

	public Guest getGuest() {
		Object object = dd_guest.getSelectedItem();
		Guest guest = (Guest) object;
		return guest;
	}

	public Booking_Status getStatus() {
		Object object = dd_status.getSelectedItem();
		Booking_Status status = (Booking_Status) object;
		return status;
	}

	public Date getFinishDate() {
		String date = tf_finishDate.getText();
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public Date getStartDate() {
		String date = tf_startDate.getText();
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public boolean isTaskGenerating() {
		return cb_generateTasks.isSelected();
	}

	public static void main(String[] args) {
		new Booking_View().changeMode(MODE_MODIFY);
	}

}
