package Entities;

public abstract class Employee extends Person {

	private long personnelId;
	private JobTitle jobTitle;
	private String insuranceNumber;
	private String password;

	public Employee() {
		super();
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
	

}
