package entities;

import org.joda.time.LocalDate;



public class Task {

	private long id;
	private LocalDate startDate;
	private LocalDate finishDate;
	private String desc;
	private Task_Prio prio;
	private Task_Status status;
	private Property property;

	public Task() {
		super();
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Task_Prio getPrio() {
		return prio;
	}

	public void setPrio(Task_Prio prio) {
		this.prio = prio;
	}

	public Task_Status getStatus() {
		return status;
	}

	public void setStatus(Task_Status status) {
		this.status = status;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	

}
