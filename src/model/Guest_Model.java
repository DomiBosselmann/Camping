package model;

import java.util.Date;
import java.util.Observable;

import Entities.Address;
import Entities.Guest;
import Entities.IdentityCard;

public class Guest_Model extends Observable {

	private Guest guest;

	public long getCustomerNumber() {
		return guest.getCustomerId();
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
		this.hasChanged();
	}

	public void setCustomerNumber(long customerNumber) {
		guest.setCustomerId(customerNumber);
		this.hasChanged();
	}

	public Address getAdress() {
		return guest.getAddress();
	}

	public void setAddress(Address adress) {
		guest.setAddress(adress);
		this.hasChanged();
	}

	public IdentityCard getId() {
		return guest.getId();
	}

	public void setId(IdentityCard id) {
		guest.getId();
		this.hasChanged();
	}

	public String getFirstName() {
		return guest.getFirstName();
	}

	public void setFirstName(String firstName) {
		guest.setFirstName(firstName);
		this.hasChanged();
	}

	public String getLastName() {
		return guest.getLastName();
	}

	public void setLastName(String lastName) {
		guest.setLastName(lastName);
		this.hasChanged();
	}

	public Date getBirthdate() {
		return guest.getDateOfBirth();
	}

	public void setBirthdate(Date birthdate) {
		guest.setDateOfBirth(birthdate);
		this.hasChanged();
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + "( #"
				+ this.getCustomerNumber() + ")";
	}

}
