package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import Entities.Booking;
import Entities.Booking_Status;
import Entities.Guest;
import Entities.Reservation;

public class Booking_Model extends Observable {

	private Booking booking;
	private boolean taskGenerating;

	public Booking_Model() {
		super();
	}

	public boolean isTaskGenerating() {
		return taskGenerating;
	}

	public float getPricePerNight() {
		List<Reservation> reservations = booking.getReservations();
		float sum = 0;
		for (Reservation reser : reservations) {
			sum += reser.getPitch().calcPrice();
		}
		return sum;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
		this.hasChanged();
	}

	public void setTaskGenerating(boolean taskGenerating) {
		this.taskGenerating = taskGenerating;
		this.hasChanged();
	}

	public int getNumberNights() {
		long result = booking.getFinishDate().getTime()
				- booking.getStartDate().getTime();
		result = result / (24 * 60 * 60 * 1000);
		// TODO check if necessary
		return (int) Math.ceil(result);
	}

	public Date getStartDate() {
		return booking.getStartDate();
	}

	public void setStartDate(Date startDate) {
		booking.setStartDate(startDate);
		this.hasChanged();
	}

	public Date getFinishDate() {
		return booking.getFinishDate();
	}

	public void calcDate() {
		// TODO
	}

	public void setStatus(Booking_Status status) {
		booking.setStatus(status);
		this.hasChanged();
	}

	private void checkFollowUpTasks() {
		// TODO
	}

	private void settle() {
		// TODO
	}

	public void checkout() {
		// TODO call the private methods
	}

	public Guest getGuest() {
		return booking.getGuest();
	}

	public void setGuest(Guest guest) {
		booking.setGuest(guest);
		this.hasChanged();
	}

	public Booking_Status getStatus() {
		return booking.getStatus();
	}

	public void setFinishDate(Date finishDate) {
		booking.setFinishDate(finishDate);
		this.hasChanged();
	}

	public ArrayList<Reservation> getReservations() {
		return booking.getReservations();
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		booking.setReservations(reservations);
		this.hasChanged();
	}

	public boolean addReservation(Reservation reservation) {
		this.hasChanged();
		return booking.addReservation(reservation);
	}

	public boolean removeReservation(Reservation reservation) {
		this.hasChanged();
		return booking.removeReservation(reservation);

	}

}
