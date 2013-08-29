package entities;

public abstract class Employee extends Person {
	
	public static final int TECHNICAL = 0, RECEPTION = 1, ADMIN = 2;

	protected long personnelId;
	protected JobTitle jobTitle;
	protected String insuranceNumber;
	protected String password;

	public Employee() {
		super();
	}

	public Employee(long personnelId, JobTitle jobTitle,
			String insuranceNumber, String password) {
		super();
		this.personnelId = personnelId;
		this.jobTitle = jobTitle;
		this.insuranceNumber = insuranceNumber;
		this.password = password;
	}

	public long getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(long personnelNumber) {
		this.personnelId = personnelNumber;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + "( #" + this.personnelId
				+ ")";
	}

}
