package Entities;

import java.util.Date;

public class Task {

	private Date startDate;
	private Date finishDate;
	private String desc;
	private String prio;
	private String status;

	public Task() {
		super();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrio() {
		return prio;
	}

	public void setPrio(String prio) {
		this.prio = prio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
