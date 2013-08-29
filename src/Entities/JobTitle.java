package entities;

public class JobTitle {

	private long id;
	private String name;
	private int matchingEmployeeType;

	public JobTitle() {
		super();
	}
	
	

	public JobTitle(String name, int matchingEmployeeType) {
		super();
		this.name = name;
		this.matchingEmployeeType = matchingEmployeeType;
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



	@Override
	public String toString() {
		return name;
	}
	
	

}
