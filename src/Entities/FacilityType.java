package entities;

import java.util.ArrayList;

public class FacilityType extends Property {

	private long id;
	private String name;
	private ArrayList<Facility> facilities;

	public FacilityType() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(ArrayList<Facility> facilities) {
		this.facilities = facilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
