package entities;

import java.util.ArrayList;

public class Area {

	private String label;
	private ArrayList<PitchGroup> groups;

	public Area() {
		super();
	}

	public Area(String label) {
		super();
		groups = new ArrayList<PitchGroup>();
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ArrayList<PitchGroup> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<PitchGroup> groups) {
		this.groups = groups;
	}

	public boolean addPitchGroup(PitchGroup group) {
		return groups.add(group);
	}

	public boolean remove(PitchGroup group) {
		return groups.remove(group);
	}

}
