package Entities;

import java.util.Date;

public class Guest extends Person {

	private long customerId;

	// nicht persistent
	private transient int numberOfBookings;
	private transient boolean present;

	public Guest() {
		super();
	}
	
	
	public Guest(Address address, String firstName, String lastName,
			Date dateOfBirth) {
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


}
