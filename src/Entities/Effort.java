package Entities;

import java.util.Date;

public class Effort {
	
	private long id;
	private String desc;
	private String prio;
	private JobTitle responsibility;
	private int timeCycle;
	private Date lastProcedure;
	
	public Effort() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public JobTitle getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(JobTitle responsibility) {
		this.responsibility = responsibility;
	}

	public int getTimeCycle() {
		return timeCycle;
	}

	public void setTimeCycle(int timeCycle) {
		this.timeCycle = timeCycle;
	}

	public Date getLastProcedure() {
		return lastProcedure;
	}

	public void setLastProcedure(Date lastProcedure) {
		this.lastProcedure = lastProcedure;
	}
}
