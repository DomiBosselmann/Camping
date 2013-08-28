package Util;

import java.util.Date;
import java.util.List;

import Entities.Address;
import Entities.Area;
import Entities.Booking;
import Entities.Employee;
import Entities.Guest;
import Entities.Pitch;
import Entities.PitchGroup;
import Entities.Reservation;

public class DataProvider {

	private List<Guest> guests;
	private List<Employee> employees;
	private List<Booking> bookings;
	private List<Pitch> pitches;

	public DataProvider() {
		// init Persistence Util

		Area area1 = new Area("Area 1");
		Area area2 = new Area("Area 2");
		PitchGroup group1 = new PitchGroup("Tent", 7.5f);
		group1.setArea(area1);
		PitchGroup group2 = new PitchGroup("Trailer", 10.5f);
		group2.setArea(area2);

		Pitch p = new Pitch("A52", 5, true, true);
		p.setGroup(group1);
		pitches.add(p);
		p = new Pitch("A52", 8, false, true);
		p.setGroup(group1);
		pitches.add(p);
		p = new Pitch("A42", 3, true, true);
		p.setGroup(group2);
		pitches.add(p);
		p = new Pitch("A5s2", 7, true, false);
		p.setGroup(group1);
		pitches.add(p);
		p = new Pitch("BA52", 8, false, false);
		p.setGroup(group2);
		pitches.add(p);
		p = new Pitch("B52", 3, true, true);
		p.setGroup(group2);
		pitches.add(p);
		p = new Pitch("A32", 10, false, true);
		p.setGroup(group1);
		p.setReservation(new Reservation());
		pitches.add(p);

		Address address1 = new Address("Rankach", "30", 77709, "Oberwolfach");
		Address address2 = new Address("Göthestraße", "17", 76135, "Karlsruhe");
		Date dateOfBirth = new Date(1992, 9, 24);
		Guest g = new Guest(address1, "Marius", "Obert", dateOfBirth);

		guests.add(g);
		g = new Guest(address2, "Obert", "Marius", dateOfBirth);
		guests.add(g);
		g = new Guest(address1, "marius", "obert", dateOfBirth);
		guests.add(g);

	}

	public List<Guest> getGuests() {
		return guests;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public List<Pitch> getPitches() {
		return pitches;
	}

}
