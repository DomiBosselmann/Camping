package Entities;

import java.util.Date;

public abstract class Person {

	protected IdentityCard id;
	protected Address address;
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;

	public Person() {
		super();
	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public IdentityCard getId() {
		return id;
	}

	public void setId(IdentityCard id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
