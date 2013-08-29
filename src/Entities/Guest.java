package entities;

import java.util.ArrayList;

import org.joda.time.LocalDate;


public class Guest extends Person {

	private long customerId;
	private ArrayList<Booking> bookings;

	public Guest() {
		super();
	}

	public Guest(IdentityCard id, Phonenumber number, Address address, String firstName, String lastName,
			LocalDate dateOfBirth) {
		super();
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public int getNumberOfBookings() {
		return bookings.size();
	}

	public boolean isPresent() {
		boolean isPresent = false;
		LocalDate now = new LocalDate();

		for (Booking booking : bookings) {
			for (Reservation reservation : booking.getReservations()) {
				//complex, but true
				//checks if now is beetween the boundaries
				isPresent = (reservation.getStartDate().compareTo(now) * now
						.compareTo(reservation.getFinishDate())) >= 0;
				if(isPresent){
					return isPresent;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + " ("
				+ customerId + ")";
	}

}
