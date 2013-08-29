package entities;

import java.util.ArrayList;

public class PitchGroup {

	private long id;
	private PitchGroup_Usage usage;
	private Area area;
	private ArrayList<Pitch> pitches;

	public PitchGroup() {
		super();
	}

	public PitchGroup(PitchGroup_Usage usage) {
		super();
		pitches = new  ArrayList<Pitch>();
		this.setUsage(usage);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PitchGroup_Usage getUsage() {
		return usage;
	}

	public void setUsage(PitchGroup_Usage usage) {
		this.usage = usage;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public float getPrice() {
		float price = 0.0f;
		switch (usage) {
		case Tent:
			price = 5.5f;
			break;
		case Caravan:
			price = 7.5f;
			break;
		case Trailer:
			price = 7.5f;
			break;
		default:
			throw new RuntimeException("Unknown Usage type");
		}
		return price;
	}

	public boolean addPitch(Pitch pitch) {
		return pitches.add(pitch);
	}

	public boolean removePitch(Pitch pitch) {
		return pitches.remove(pitch);
	}

	public ArrayList<Pitch> getPitches() {
		return pitches;
	}

	public void setPitches(ArrayList<Pitch> pitches) {
		this.pitches = pitches;
	}

}
