package Util;

import entities.Booking;
import entities.ChipCard;
import entities.Employee;
import entities.Facility;
import entities.Guest;
import entities.Invoice;
import entities.Reservation;
import entities.Task;

public interface ApplicationCore_Inft {
	
	public ApplicationCore getInstance();
	
	public void createGuest(Guest guest);
	public void createEmployee(Employee employee);
	public void createBooking(Booking booking);
	public void createChipcard(ChipCard chipCard);
	public void createReservation(Reservation reservation);
	public void createInvoice(Invoice invoice);
	public void createTask(Task task);
	public void createFacility(Facility facility);
	
	public void updateGuest(Guest guest);
	public void updateEmployee(Employee employee);
	public void updateBooking(Booking booking);
	public void updateChipcard(ChipCard chipCard);
	public void updateReservation(Reservation reservation);
	public void updateInvoice(Invoice invoice);
	public void updateTask(Task task);
	public void updateFacility(Facility facility);

}
