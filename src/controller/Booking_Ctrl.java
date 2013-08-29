package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import model.Booking_Model;

import org.joda.time.LocalDate;

import entities.Booking;
import entities.Booking_Status;
import entities.Guest;
import entities.Pitch;
import entities.Reservation;

import Util.ApplicationCore;

import view.Booking_View;

public class Booking_Ctrl extends JComponent {

	private Booking_Model model;
	private Booking_View view;

	public Booking_Ctrl() {
		super();
		model = new Booking_Model();
	}

	public void createNewBooking() {
		model.setBooking(new Booking());
		init(Booking_View.MODE_CREATE);
		view.addConfirmationtionListener(new CreateListener());
	}

	public void createNewBookingFromTemplate(ArrayList<Pitch> pitches,
			LocalDate startDate, LocalDate finishDate) {
		model.setBooking(new Booking());
		init(Booking_View.MODE_CREATE);
		view.addConfirmationtionListener(new CreateListener());
		view.setTemplate(pitches, startDate, finishDate);
	}

	public void modifyBooking(Booking entity) {
		model.setBooking(entity);

		init(Booking_View.MODE_MODIFY);

		view.addConfirmationtionListener(new ModifyListener());
		view.addDeleteListener(new DeleteListener());
		view.addChangeModeListener(new ChangeModeListener());
	}

	public void showBooking(Booking entity) {
		this.modifyBooking(entity);
		view.changeMode(Booking_View.MODE_SHOW);
	}

	private void init(int mode) {
		view = new Booking_View();
		view.changeMode(mode);
		model.addObserver(view);
		view.update(model, null);
	}

	class CreateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// read the view
			boolean taskGenerating = view.isTaskGenerating();
			LocalDate startDate = view.getStartDate();
			LocalDate finishDate = view.getFinishDate();
			ArrayList<Pitch> freePitches = (ArrayList<Pitch>) ApplicationCore.provider
					.getFreePitchesFromTo(startDate, finishDate);
			Guest guest = view.getGuest();
			Booking_Status status = view.getStatus();
			
			if (freePitches.containsAll(view.getPitches())) {
				for (Pitch pitch : view.getPitches()) {
					model.addReservation(startDate, finishDate, pitch);
				}
			} else {
				return;
			}

			// value validation
			if (startDate == null || finishDate == null || guest == null
					|| status == null || startDate.isAfter(finishDate)
					|| !(status.equals(Booking_Status.Reserved))) {
				return;
			}
			System.out.println("Create action triggered");
			model.setTaskGenerating(taskGenerating);
			model.setStartDate(startDate);
			model.setFinishDate(finishDate);
			model.setGuest(guest);
			model.setStatus(status);

			model.notifyObservers();

		}
	}

	class ModifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean taskGenerating = view.isTaskGenerating();
			LocalDate startDate = view.getStartDate();
			LocalDate finishDate = view.getFinishDate();
			ArrayList<Pitch> freePitches = (ArrayList<Pitch>) ApplicationCore.provider
					.getFreePitchesFromTo(startDate, finishDate);
			Guest guest = view.getGuest();
			Booking_Status status = view.getStatus();

			if (freePitches.containsAll(view.getPitches())) {
				for (Pitch pitch : view.getPitches()) {
					model.addReservation(startDate, finishDate, pitch);
				}
			} else {
				return;
			}

			// if one or more values aren't set
			if (startDate == null || finishDate == null || guest == null
					|| status == null || status.equals(Booking_Status.Reserved)) {
				return;
			}
			System.out.println("Create action triggered");
			model.setTaskGenerating(taskGenerating);
			model.setStartDate(startDate);
			model.setFinishDate(finishDate);
			model.setGuest(guest);
			model.setStatus(status);

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
			// TODO Auto-generated method stub

		}
	}

}
