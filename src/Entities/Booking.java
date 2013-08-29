package entities;

import java.util.ArrayList;

import org.joda.time.LocalDate;


public class Booking {

	private long id;
	private LocalDate startDate;
	private LocalDate finishDate;
	private ChipCard chipCard;
	private Booking_Status status;
	private Invoice invoice;
	private Guest guest;
	private boolean taskGenerating;
	private ArrayList<Reservation> reservations;

	public Booking() {
		super();
	}

	public Booking(long id, LocalDate startDate, LocalDate finishDate,
			Booking_Status status, Guest guest, boolean taskGenerating) {
		super();
		reservations = new ArrayList<Reservation>();
		this.id = id;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.status = status;
		this.guest = guest;
		this.taskGenerating = taskGenerating;
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

	public void calcDate() {
		
	}

	public void setStatus(Booking_Status status) {
		this.status = status;
	}

	private void checkFollowUpTasks() {
		
	}

	private void settle() {
		
	}

	public void checkout() {
		
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

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		if(reservations == null){
			reservations = new ArrayList<Reservation>();
		}
		this.reservations = reservations;
	}

	public boolean addReservation(Reservation reservation) {
		if(reservations == null){
			reservations = new ArrayList<Reservation>();
		}
		return reservations.add(reservation);
	}

	public boolean removeReservation(Reservation reservation) {
		return reservations.remove(reservation);
	}

	public boolean isTaskGenerating() {
		return taskGenerating;
	}

	public void setTaskGenerating(boolean taskGenerating) {
		this.taskGenerating = taskGenerating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Buchung ( #" + id + ")";
	}

	public ChipCard getChipCard() {
		return chipCard;
	}

	public void setChipCard(ChipCard chipCard) {
		this.chipCard = chipCard;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
