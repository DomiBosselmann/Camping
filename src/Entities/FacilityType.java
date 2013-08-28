package Entities;

public class FacilityType extends Property {

	private long id;
	private String name;
	private Effort effort;

	public FacilityType() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Effort getEffort() {
		return effort;
	}

	public void setEffort(Effort effort) {
		this.effort = effort;
	}



	

}
