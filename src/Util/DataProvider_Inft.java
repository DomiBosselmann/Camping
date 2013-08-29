package Util;

import java.util.List;

import org.joda.time.LocalDate;

import entities.Area;
import entities.Booking;
import entities.ChipCard;
import entities.Employee;
import entities.FacilityType;
import entities.Guest;
import entities.Invoice;
import entities.JobTitle;
import entities.Pitch;
import entities.Reservation;
import entities.Task;


public interface DataProvider_Inft {

	public List<Guest> getGuests();

	public List<Booking> getBookings();

	public List<Pitch> getPitches();
	
	public List<Pitch> getFreePitchesFromTo(LocalDate start, LocalDate finish);

	public List<Area> getAreas();

	public List<FacilityType> getFacilityTypes();

	public List<Invoice> getInvoices();

	public List<JobTitle> getJobTitles(int employee_type);
	
	//Needed for the search feature of this application
	//for now searching in only possible by using the id fields
	
	public Guest getGuest(long id);
	
	public Booking getBooking(long id);
	
	public Pitch getPitch(String id);
	
	public Area getArea(String id);
	
	public FacilityType getFacilityType(String id);
	
	public Invoice getInvoice(long id);
	
	public JobTitle getJobTitle(long id);
	
	public Reservation getReservation(long id);
	
	public Employee getEmployee(long id);
	 
	public Task getTask(long id);
	
	public ChipCard getChipCard(long id);
}
