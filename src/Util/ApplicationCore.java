package Util;


import controller.LoginWindow;
import entities.Booking;
import entities.ChipCard;
import entities.Employee;
import entities.Facility;
import entities.Guest;
import entities.Invoice;
import entities.Reservation;
import entities.Task;

public class ApplicationCore implements ApplicationCore_Inft{
	
	public static DataProvider provider;
	
	static {
		provider = new DataProvider();
	}


	@Override
	public ApplicationCore getInstance() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void createGuest(Guest guest) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createChipcard(ChipCard chipCard) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createTask(Task task) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createFacility(Facility facility) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateChipcard(ChipCard chipCard) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateFacility(Facility facility) {
		// TODO Auto-generated method stub
		
	}

}
