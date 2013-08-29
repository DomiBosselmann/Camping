package entities;

import org.joda.time.LocalDate;

public class Reservation {

	private long id;
	private LocalDate startDate;
	private LocalDate finishDate;
	private Pitch pitch;
	private Booking booking;

	public Reservation() {
		super();
	}

	/**
	 * Generates a new instance an register this instance at the corresponding
	 * booking and pitch instances
	 * 
	 * @param id
	 * @param startDate
	 * @param finishDate
	 * @param pitch
	 * @param booking
	 */
	public Reservation(long id, LocalDate startDate, LocalDate finishDate,
			Pitch pitch, Booking booking) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.pitch = pitch;
		this.booking = booking;
		pitch.addReservation(this);
		booking.addReservation(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public Pitch getPitch() {
		return pitch;
	}

	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return pitch.getPitchId() + "( " + startDate + " - " + finishDate
				+ " )";
	}

}
