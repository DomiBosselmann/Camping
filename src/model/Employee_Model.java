package model;

import java.util.Date;
import java.util.Observable;

import Entities.Address;
import Entities.Employee;
import Entities.IdentityCard;
import Entities.JobTitle;

public class Employee_Model extends Observable {

	private Employee employee;

	public long getPersonnelNumber() {
		return employee.getPersonnelId();
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		this.hasChanged();
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setPersonnelNumber(long personnelNumber) {
		employee.setPersonnelId(personnelNumber);
		this.hasChanged();
	}

	public JobTitle getJobTitle() {
		return employee.getJobTitle();
	}

	public void setJobTitle(JobTitle jobTitle) {
		employee.setJobTitle(jobTitle);
		this.hasChanged();
	}

	public String getPassword() {
		return employee.getPassword();
	}

	public void setPassword(String password) {
		employee.setPassword(password);
		this.hasChanged();
	}

	public Address getAdress() {
		return employee.getAddress();
	}

	public void setAddress(Address adress) {
		employee.setAddress(adress);
		this.hasChanged();
	}

	public IdentityCard getId() {
		return employee.getId();
	}

	public void setId(IdentityCard id) {
		employee.getId();
		this.hasChanged();
	}

	public String getFirstName() {
		return employee.getFirstName();
	}

	public void setFirstName(String firstName) {
		employee.setFirstName(firstName);
		this.hasChanged();
	}

	public String getLastName() {
		return employee.getLastName();
	}

	public void setLastName(String lastName) {
		employee.setLastName(lastName);
		this.hasChanged();
	}

	public Date getBirthdate() {
		return employee.getDateOfBirth();
	}

	public void setBirthdate(Date birthdate) {
		employee.setDateOfBirth(birthdate);
		this.hasChanged();
	}

	public String getInsuranceNumber() {
		return employee.getInsuranceNumber();
	}

	public void setInsuranceNumber(String insuranceNumber) {
		employee.setInsuranceNumber(insuranceNumber);
		this.hasChanged();
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + "( #"
				+ this.getPersonnelNumber() + ")";
	}

}
