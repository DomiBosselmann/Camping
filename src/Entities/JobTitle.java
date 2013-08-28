package Entities;

public class JobTitle {

	private long id;
	private String name;

	public JobTitle() {
		super();
	}
	
	

	public JobTitle(String name) {
		super();
		this.name = name;
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

}
