package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import entities.Booking;
import entities.Booking_Status;
import entities.Guest;
import entities.Pitch;
import entities.Reservation;


public class Booking_Model extends Observable {

	private Booking booking;

	public Booking_Model() {
		super();
	}

	public boolean isTaskGenerating() {
		return booking.isTaskGenerating();
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
		this.setChanged();
	}

	public void setTaskGenerating(boolean taskGenerating) {
		booking.setTaskGenerating(taskGenerating);
		this.setChanged();
	}

	public LocalDate getStartDate() {
		return booking.getStartDate();
	}

	public void setStartDate(LocalDate startDate) {
		booking.setStartDate(startDate);
		this.setChanged();
	}

	public LocalDate getFinishDate() {
		return booking.getFinishDate();
	}

	public void calcDate() {
		// TODO
	}

	public void setStatus(Booking_Status status) {
		booking.setStatus(status);
		this.setChanged();
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
		this.setChanged();
	}

	public Booking_Status getStatus() {
		return booking.getStatus();
	}

	public void setFinishDate(LocalDate finishDate) {
		booking.setFinishDate(finishDate);
		this.setChanged();
	}

	public ArrayList<Reservation> getReservations() {
		return booking.getReservations();
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		booking.setReservations(reservations);
		this.setChanged();
	}

	public void addReservation(LocalDate startDate, LocalDate finishDate,
			Pitch pitch) {
		boolean found = false;
		if (booking.getReservations() != null) {
			for (Reservation reservation : booking.getReservations()) {
				if (reservation.getPitch() == pitch) {
					found = true;
					reservation.setStartDate(startDate);
					reservation.setFinishDate(finishDate);
					this.setChanged();
				}
			}
		}
		if (!found) {
			Reservation res = new Reservation(0, startDate, finishDate, pitch,
					booking);
			this.setChanged();
		}
	}

	public boolean removeReservation(Reservation reservation) {
		this.setChanged();
		return booking.removeReservation(reservation);
	}

	public void removeAllReservations() {
		booking.setReservations(new ArrayList<Reservation>());
	}

	@Override
	public String toString() {
		return booking.toString();
	}

}
