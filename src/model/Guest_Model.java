package model;

import java.util.Observable;

import org.joda.time.LocalDate;

import entities.Address;
import entities.Guest;
import entities.IdentityCard;
import entities.Phonenumber;


public class Guest_Model extends Observable {

	private Guest guest;

	public long getCustomerNumber() {
		return guest.getCustomerId();
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
		this.setChanged();
	}

	public void setCustomerNumber(long customerNumber) {
		guest.setCustomerId(customerNumber);
		this.setChanged();
	}

	public Address getAdress() {
		return guest.getAddress();
	}

	public void setAddress(Address adress) {
		guest.setAddress(adress);
		this.setChanged();
	}

	public IdentityCard getId() {
		return guest.getId();
	}

	public void setId(IdentityCard id) {
		guest.getId();
		this.setChanged();
	}

	public String getFirstName() {
		return guest.getFirstName();
	}

	public void setFirstName(String firstName) {
		guest.setFirstName(firstName);
		this.setChanged();
	}

	public String getLastName() {
		return guest.getLastName();
	}

	public void setLastName(String lastName) {
		guest.setLastName(lastName);
		this.setChanged();
	}

	public LocalDate getBirthdate() {
		return guest.getDateOfBirth();
	}

	public void setBirthdate(LocalDate birthdate) {
		guest.setDateOfBirth(birthdate);
		this.setChanged();
	}
	
	public Phonenumber getPhonenumber() {
		return guest.getPhonenumber();
	}

	public void setPhonenumber(Phonenumber phonenumber) {
		guest.setPhonenumber(phonenumber);
	}

	@Override
	public String toString() {
		return guest.toString();
	}

}
