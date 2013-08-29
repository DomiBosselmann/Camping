package entities;

import java.util.ArrayList;

import org.joda.time.LocalDate;






public class TechnicalEmployee extends Employee {

	private ArrayList<Task> tasks;

	public TechnicalEmployee() {
		super();
	}

	public TechnicalEmployee(IdentityCard id, Address address,
			String firstName, String lastName, LocalDate dateOfBirth,
			Phonenumber phonenumber, ArrayList<Task> tasks, long personnelId,
			JobTitle jobTitle, String insuranceNumber, String password) {
		super();
		this.id = id;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phonenumber = phonenumber;
		this.personnelId = personnelId;
		this.jobTitle = jobTitle;
		this.insuranceNumber = insuranceNumber;
		this.password = password;
		this.tasks = tasks;
	}

	public boolean addTask(Task task) {
		return tasks.add(task);
	}

	public boolean removeTask(Task task) {
		return tasks.remove(task);
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

}
