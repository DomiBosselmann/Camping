package entities;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.LocalDate;

public class Effort {
	
	private long id;
	private String desc;
	private Effort_Prio prio;
	private ArrayList<JobTitle> responsibility;
	private int timeCycle;
	private LocalDate lastProcedure;
	
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

	public Effort_Prio getPrio() {
		return prio;
	}

	public void setPrio(Effort_Prio prio) {
		this.prio = prio;
	}

	public ArrayList<JobTitle> getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(ArrayList<JobTitle> responsibility) {
		this.responsibility = responsibility;
	}

	public int getTimeCycle() {
		return timeCycle;
	}

	public void setTimeCycle(int timeCycle) {
		this.timeCycle = timeCycle;
	}

	public LocalDate getLastProcedure() {
		return lastProcedure;
	}

	public void setLastProcedure(LocalDate lastProcedure) {
		this.lastProcedure = lastProcedure;
	}
}
