package Util;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import entities.Address;
import entities.Area;
import entities.Booking;
import entities.Booking_Status;
import entities.ChipCard;
import entities.Employee;
import entities.FacilityType;
import entities.Guest;
import entities.IdentityCard;
import entities.Invoice;
import entities.JobTitle;
import entities.Phonenumber;
import entities.Pitch;
import entities.PitchGroup;
import entities.PitchGroup_Usage;
import entities.Pitch_Status;
import entities.Reservation;
import entities.Task;
import entities.TechnicalEmployee;


public class DataProvider implements DataProvider_Inft {

	private List<Guest> guests;
	private List<Employee> employees;
	private List<Booking> bookings;
	private List<Pitch> pitches;
	private List<Area> areas;
	private List<FacilityType> facilityTypes;
	private List<Invoice> invoices;
	private List<JobTitle> jobTitles;

	public DataProvider() {
		// init Persistence Util

		guests = new ArrayList<Guest>();
		employees = new ArrayList<Employee>();
		bookings = new ArrayList<Booking>();
		pitches = new ArrayList<Pitch>();
		areas = new ArrayList<Area>();
		facilityTypes = new ArrayList<FacilityType>();
		invoices = new ArrayList<Invoice>();
		jobTitles = new ArrayList<JobTitle>();

		// Fake IDs
		IdentityCard id1 = new IdentityCard("3334318636D870702674112045",
				"Germany");
		IdentityCard id2 = new IdentityCard("2317797879D310416209111174",
				"Germany");
		IdentityCard id3 = new IdentityCard("8832367229D790429563120414",
				"Germany");
		IdentityCard id4 = new IdentityCard("7365912633D180204566070464",
				"Germany");
		IdentityCard id5 = new IdentityCard("5709429343D380914546092526",
				"Germany");
		IdentityCard id6 = new IdentityCard("2712118933D020208159101426",
				"Germany");
		IdentityCard id7 = new IdentityCard("7746377297D981010970011832",
				"Germany");
		IdentityCard id8 = new IdentityCard("3012545623D440914526100481",
				"Germany");
		IdentityCard id9 = new IdentityCard("9740650198D280713681111462",
				"Germany");
		IdentityCard id10 = new IdentityCard("310109198002147295", "China");

		// Fake addresses
		Address address1 = new Address("Musterstraﬂe", "1", 12345,
				"Musterstadt");
		Address address2 = new Address("Musterweg", "5", 12345, "Musterstadt");
		Address address3 = new Address("Musterallee", "3", 12345, "Musterstadt");
		Address address4 = new Address("Mustertal", "51", 23456, "Musterhausen");
		Address address5 = new Address("Am Musterberg", "41", 23456,
				"Musterhausen");
		Address address6 = new Address("Musterstraﬂe", "10", 23456,
				"Musterhausen");
		Address address7 = new Address("Am Muster", "30", 23456, "Musterhausen");
		Address address8 = new Address("Musterring", "10", 34567, "Musterbach");
		Address address9 = new Address("Zur Musterhˆhe", "44", 34567,
				"Musterbach");
		Address address10 = new Address("Obere Musterstraﬂe", "61", 34567,
				"Musterbach");

		// Fake phonenumbers
		Phonenumber number1 = new Phonenumber(49, 783412345, true);
		Phonenumber number2 = new Phonenumber(49, 457745634, true);
		Phonenumber number3 = new Phonenumber(49, 312854582, true);
		Phonenumber number4 = new Phonenumber(49, 31264287, true);
		Phonenumber number5 = new Phonenumber(49, 564551124, true);
		Phonenumber number6 = new Phonenumber(46, 231754628, true);
		Phonenumber number7 = new Phonenumber(49, 1231454654, true);
		Phonenumber number8 = new Phonenumber(49, 575378464, true);
		Phonenumber number9 = new Phonenumber(49, 843758464, true);
		Phonenumber number10 = new Phonenumber(49, 687665786, true);

		// Fake job titles
		JobTitle jb1 = new JobTitle("Platzwart", Employee.TECHNICAL);
		JobTitle jb2 = new JobTitle("Verk‰ufer", Employee.TECHNICAL);
		JobTitle jb3 = new JobTitle("Sicherheitsbeauftragter",
				Employee.TECHNICAL);
		JobTitle jb4 = new JobTitle("Reinigungskraft", Employee.TECHNICAL);
		JobTitle jb5 = new JobTitle("Gastronom", Employee.TECHNICAL);
		jobTitles.add(jb1);
		jobTitles.add(jb2);
		jobTitles.add(jb3);
		jobTitles.add(jb4);
		jobTitles.add(jb5);

		// Fake dates of birth
		LocalDate dateOfBirth1 = new LocalDate(1992, 9, 24);
		LocalDate dateOfBirth2 = new LocalDate(1990, 5, 2);
		LocalDate dateOfBirth3 = new LocalDate(1996, 4, 4);
		LocalDate dateOfBirth4 = new LocalDate(1994, 10, 11);
		LocalDate dateOfBirth5 = new LocalDate(1994, 11, 22);
		LocalDate dateOfBirth6 = new LocalDate(1990, 1, 7);
		LocalDate dateOfBirth7 = new LocalDate(1990, 5, 2);
		LocalDate dateOfBirth8 = new LocalDate(1996, 4, 4);
		LocalDate dateOfBirth9 = new LocalDate(1994, 10, 11);
		LocalDate dateOfBirth10 = new LocalDate(1994, 11, 22);

		// Fake guests
		Guest g = new Guest(id1, number1, address1, "Marius", "Obert",
				dateOfBirth1);
		guests.add(g);
		g = new Guest(id2, number2, address2, "Dominique", "Bosselmann",
				dateOfBirth2);
		guests.add(g);
		g = new Guest(id3, number3, address3, "Lukas", "Carullo", dateOfBirth3);
		guests.add(g);
		g = new Guest(id4, number4, address4, "Patrick", "Spiegel",
				dateOfBirth4);
		guests.add(g);
		g = new Guest(id5, number5, address5, "Richard", "Lutz", dateOfBirth5);
		guests.add(g);
		g = new Guest(id6, number6, address6, "Patrick", "Wasserziehr",
				dateOfBirth6);
		guests.add(g);

		// Fake employees
		TechnicalEmployee te = new TechnicalEmployee(id7, address7, "Marcel",
				"Reif", dateOfBirth7, number7, null, 351321, jb3,
				"s5d4as6f5sa", "fas5fs5d");
		employees.add(te);
		te = new TechnicalEmployee(id8, address8, "Wolff Christoph", "Fuss",
				dateOfBirth8, number8, null, 354345, jb2, "dfa35dgd",
				"fg23sdfds");
		employees.add(te);
		te = new TechnicalEmployee(id9, address9, "Fritz ",
				"von Thurn und Taxis", dateOfBirth9, number9, null, 35454, jb1,
				"gds2gf53as", "dfa64f5sa3");
		employees.add(te);
		te = new TechnicalEmployee(id10, address10, "Jessica ", "Kastrop ",
				dateOfBirth10, number10, null, 35555, jb4, "sd65as4f65asf",
				"bnf2db132a");
		employees.add(te);

		// Fake camping area
		Area area1 = new Area("Area 1");
		Area area2 = new Area("Area 2");
		areas.add(area1);
		areas.add(area2);
		PitchGroup group1 = new PitchGroup(PitchGroup_Usage.Tent);
		group1.setArea(area1);
		area1.addPitchGroup(group1);
		PitchGroup group2 = new PitchGroup(PitchGroup_Usage.Trailer);
		group2.setArea(area2);
		area2.addPitchGroup(group2);
		PitchGroup group3 = new PitchGroup(PitchGroup_Usage.Caravan);
		group3.setArea(area2);
		area2.addPitchGroup(group3);

		Pitch p = new Pitch("A20", 20, true, true);
		p.setGroup(group1);
		group1.addPitch(p);
		pitches.add(p);
		p = new Pitch("A21", 23, false, true);
		p.setGroup(group1);
		group1.addPitch(p);
		pitches.add(p);
		p = new Pitch("B22", 50, true, true);
		p.setGroup(group2);
		group2.addPitch(p);
		pitches.add(p);
		p = new Pitch("A23", 24, true, false);
		p.setGroup(group1);
		group1.addPitch(p);
		pitches.add(p);
		p = new Pitch("B30", 60, false, false);
		p.setGroup(group2);
		group2.addPitch(p);
		pitches.add(p);
		p = new Pitch("B31", 63, true, true);
		p.setGroup(group2);
		group2.addPitch(p);
		pitches.add(p);
		p = new Pitch("A32", 10, false, true);
		p.setGroup(group1);
		group1.addPitch(p);
		pitches.add(p);
		p = new Pitch("B30", 68, false, false);
		p.setGroup(group3);
		group3.addPitch(p);
		pitches.add(p);
		p = new Pitch("B41", 73, true, true);
		p.setGroup(group3);
		group3.addPitch(p);
		pitches.add(p);
		p = new Pitch("B3", 62, false, false);
		p.setGroup(group3);
		group3.addPitch(p);
		pitches.add(p);
		p = new Pitch("B01", 71, true, true);
		p.setGroup(group3);
		group3.addPitch(p);
		pitches.add(p);

		LocalDate start = new LocalDate(2013, 9, 3);
		LocalDate end = new LocalDate(2013, 9, 5);
		p = pitches.get(2);

		Booking book = new Booking(1, start, end, Booking_Status.Active,
				guests.get(2), false);
		Reservation res = new Reservation(526, start, end, p, book);

		start = new LocalDate(2013, 8, 28);
		end = new LocalDate(2013, 9, 5);
		p = pitches.get(4);
		book = new Booking(21, start, end, Booking_Status.Reserved,
				guests.get(4), false);
		res = new Reservation(56, start, end, p, book);

	}

	@Override
	public List<Guest> getGuests() {
		return guests;
	}

	@Override
	public List<Booking> getBookings() {
		return bookings;
	}

	@Override
	public List<Pitch> getPitches() {
		return pitches;
	}

	@Override
	public List<Area> getAreas() {
		return areas;
	}

	@Override
	public List<FacilityType> getFacilityTypes() {
		return facilityTypes;
	}

	@Override
	public List<Invoice> getInvoices() {
		return invoices;
	}

	@Override
	public List<JobTitle> getJobTitles(int employee_type) {
		// only where emplyee number is correct
		return jobTitles;
	}

	@Override
	public Guest getGuest(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBooking(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pitch getPitch(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area getArea(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacilityType getFacilityType(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice getInvoice(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobTitle getJobTitle(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getReservation(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTask(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChipCard getChipCard(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pitch> getFreePitchesFromTo(LocalDate start, LocalDate finish) {
		ArrayList<Pitch> list = new ArrayList<Pitch>();
		for (Pitch pitch : pitches) {
			if (pitch.getStatusForPeriode(start, finish).equals(
					Pitch_Status.Available)) {
				list.add(pitch);
			}
		}
		return list;
	}
}
