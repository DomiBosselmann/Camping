package Entities;

import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private Date startDate;
	private Date finishDate;
	private Booking_Status status;
	private Guest guest;
	private ArrayList<Reservation> reservations;

	public Booking() {
		super();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void calcDate() {
		// TODO
	}

	public void setStatus(Booking_Status status) {
		this.status = status;
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
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Booking_Status getStatus() {
		return status;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public boolean addReservation(Reservation reservation) {
		return reservations.add(reservation);
	}

	public boolean removeReservation(Reservation reservation) {
		return reservations.remove(reservation);
	}
}
