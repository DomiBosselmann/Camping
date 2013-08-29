package entities;

import java.util.ArrayList;

public abstract class Property {

	private ArrayList<Effort> effort;

	public Property() {
		super();
	}

	public ArrayList<Effort>  getEffort() {
		return effort;
	}

	public void setEffort(ArrayList<Effort>  effort) {
		this.effort = effort;
	}

}
