package Entities;

import java.util.ArrayList;

public class TechnicalEmployee extends Employee {

	private ArrayList<Task> tasks;

	public TechnicalEmployee() {
		super();
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

}
