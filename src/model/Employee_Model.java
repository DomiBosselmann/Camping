package model;

import java.util.Observable;

import org.joda.time.LocalDate;

import entities.Address;
import entities.Employee;
import entities.IdentityCard;
import entities.JobTitle;
import entities.Phonenumber;


public class Employee_Model extends Observable {

	private Employee employee;

	public long getPersonnelId() {
		return employee.getPersonnelId();
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		this.setChanged();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setPersonnelId(long personnelNumber) {
		employee.setPersonnelId(personnelNumber);
		this.setChanged();
	}

	public JobTitle getJobTitle() {
		return employee.getJobTitle();
	}

	public void setJobTitle(JobTitle jobTitle) {
		employee.setJobTitle(jobTitle);
		this.setChanged();
	}

	public String getPassword() {
		return employee.getPassword();
	}

	public void setPassword(String password) {
		employee.setPassword(password);
		this.setChanged();
	}

	public Address getAdress() {
		return employee.getAddress();
	}

	public void setAddress(Address adress) {
		employee.setAddress(adress);
		this.setChanged();
	}

	public IdentityCard getId() {
		return employee.getId();
	}

	public void setId(IdentityCard id) {
		employee.getId();
		this.setChanged();
	}

	public String getFirstName() {
		return employee.getFirstName();
	}

	public void setFirstName(String firstName) {
		employee.setFirstName(firstName);
		this.setChanged();
	}

	public String getLastName() {
		return employee.getLastName();
	}

	public void setLastName(String lastName) {
		employee.setLastName(lastName);
		this.setChanged();
	}

	public LocalDate getBirthdate() {
		return employee.getDateOfBirth();
	}

	public void setBirthdate(LocalDate birthdate) {
		employee.setDateOfBirth(birthdate);
		this.setChanged();
	}

	public String getInsuranceNumber() {
		return employee.getInsuranceNumber();
	}

	public void setInsuranceNumber(String insuranceNumber) {
		employee.setInsuranceNumber(insuranceNumber);
		this.setChanged();
	}

	public Phonenumber getPhonenumber() {
		return employee.getPhonenumber();
	}

	public void setPhonenumber(Phonenumber phonenumber) {
		employee.setPhonenumber(phonenumber);
	}

	@Override
	public String toString() {
		return employee.toString();
	}

}
