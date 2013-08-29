package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Map_Model;

import org.joda.time.LocalDate;

import entities.Pitch;
import entities.Pitch_Status;


public class MapDetails_View extends JPanel implements Observer {

	private JLabel lbl_pitches, lbl_numberPitches, lbl_usage, lbl_areas,
			lbl_size, lbl_numberPower, lbl_numberWater, lbl_status,
			lbl_pricePerNight;
	private JTextField tf_pitches, tf_numberPitches, tf_usage, tf_areas,
			tf_size, tf_numberPower, tf_numberWater, tf_status,
			tf_pricePerNight;
	private JButton btn_book;

	public MapDetails_View() {
		super();
		init();
	}

	private void init() {
		lbl_pitches = new JLabel("Stellplätze");
		lbl_numberPitches = new JLabel("Anzahl Stellplätze");
		lbl_usage = new JLabel("Art der Nutzung");
		lbl_areas = new JLabel("Oberbereiche");
		lbl_size = new JLabel("Größe");
		lbl_numberPower = new JLabel("Anzahl der Stromanschlüsse");
		lbl_numberWater = new JLabel("Anzahl der Wasseranschlüsse");
		lbl_status = new JLabel("Aktueller Status");
		lbl_pricePerNight = new JLabel("Preis pro Nacht");
		tf_pitches = new JTextField();
		tf_numberPitches = new JTextField();
		tf_usage = new JTextField();
		tf_areas = new JTextField();
		tf_size = new JTextField();
		tf_numberPower = new JTextField();
		tf_numberWater = new JTextField();
		tf_status = new JTextField();
		tf_pricePerNight = new JTextField();
		tf_pricePerNight = new JTextField();
		btn_book = new JButton("Belegung anlegen");

		btn_book.setEnabled(false);

		tf_pitches.setEditable(false);
		tf_numberPitches.setEditable(false);
		tf_usage.setEditable(false);
		tf_areas.setEditable(false);
		tf_size.setEditable(false);
		tf_numberPower.setEditable(false);
		tf_numberWater.setEditable(false);
		tf_status.setEditable(false);
		tf_pricePerNight.setEditable(false);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel pitchPanel = new JPanel();
		pitchPanel.setLayout(new GridLayout(0, 2));
		JPanel featurePanel = new JPanel();
		featurePanel.setLayout(new GridLayout(0, 2));
		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(new GridLayout(0, 2));

		pitchPanel.add(lbl_pitches);
		pitchPanel.add(tf_pitches);
		pitchPanel.add(lbl_numberPitches);
		pitchPanel.add(tf_numberPitches);
		pitchPanel.add(lbl_usage);
		pitchPanel.add(tf_usage);
		pitchPanel.add(lbl_areas);
		pitchPanel.add(tf_areas);

		this.add(pitchPanel);
		this.add(Box.createRigidArea(new Dimension(0, 10)));

		featurePanel.add(lbl_size);
		featurePanel.add(tf_size);
		featurePanel.add(lbl_numberPower);
		featurePanel.add(tf_numberPower);
		featurePanel.add(lbl_numberWater);
		featurePanel.add(tf_numberWater);

		this.add(featurePanel);
		this.add(Box.createRigidArea(new Dimension(0, 10)));

		bookingPanel.add(lbl_status);
		bookingPanel.add(tf_status);
		bookingPanel.add(lbl_pricePerNight);
		bookingPanel.add(tf_pricePerNight);

		this.add(bookingPanel);
		this.add(Box.createRigidArea(new Dimension(0, 10)));

		this.add(btn_book);

	}

	@Override
	public void update(Observable model, Object arg1) {
		LocalDate today = new LocalDate();
		LocalDate tomorrow = new LocalDate().plusDays(1);

		Map_Model mapModel = (Map_Model) model;
		String pitchNames = null, numUsages = null, numAreas = null;
		HashMap<String, Integer> usages = new HashMap<String, Integer>();
		HashMap<String, Integer> areas = new HashMap<String, Integer>();
		int numberPitches = 0, overallSize = 0, numberPowerSupplies = 0, numberWaterSupplies = 0, numberFree = 0;
		float price = 0;

		// read the information, which will be displayed
		for (Pitch pitch : mapModel.getSelectedPitches()) {
			numberPitches++;
			if (pitchNames == null) {
				pitchNames = pitch.getPitchId();
			} else {
				pitchNames += ", " + pitch.getPitchId();
			}
			int num;
			try {
				num = usages.get(pitch.getGroup().getUsage().toString());
			} catch (NullPointerException n) {
				num = 0;
			}
			usages.put(pitch.getGroup().getUsage().toString(), num + 1);

			try {
				num = areas.get(pitch.getGroup().getArea().getLabel());
			} catch (NullPointerException n) {
				num = 0;
			}
			areas.put(pitch.getGroup().getArea().getLabel(), num + 1);

			if (pitch.getStatusForPeriode(today, tomorrow).equals(
					Pitch_Status.Available)) {
				numberFree++;
			}
			if (pitch.isPowerSupplied()) {
				numberPowerSupplies++;
			}
			if (pitch.isWaterSupplied()) {
				numberWaterSupplies++;
			}
			overallSize += pitch.getSize();
			price += pitch.calcPrice(today, tomorrow);
		}
		for (Entry<String, Integer> entry : usages.entrySet()) {
			if (numUsages == null) {
				numUsages = entry.getValue() + "x " + entry.getKey();
			} else {
				numUsages += ", " + entry.getValue() + "x " + entry.getKey();
			}
		}
		for (Entry<String, Integer> entry : areas.entrySet()) {
			if (numAreas == null) {
				numAreas = entry.getValue() + "x " + entry.getKey();
			} else {
				numAreas += ", " + entry.getValue() + "x " + entry.getKey();
			}
		}

		// write the read information
		tf_pitches.setText(pitchNames);
		tf_numberPitches.setText(numberPitches + "");
		tf_usage.setText(numUsages);
		tf_areas.setText(numAreas);
		tf_size.setText(overallSize + " m*m");
		tf_numberPower.setText(numberPowerSupplies + " x vorhanden");
		tf_numberWater.setText(numberWaterSupplies + " x vorhanden");
		tf_status.setText(numberFree + " Stellplätze verfügbar");
		tf_pricePerNight.setText(price + " €");

		// check if it's possible to create a booking
		if (numberPitches == numberFree && numberFree > 0) {
			btn_book.setEnabled(true);
		} else {
			btn_book.setEnabled(false);
		}

	}

	public void addBookingListener(ActionListener al) {
		btn_book.addActionListener(al);
	}
}
