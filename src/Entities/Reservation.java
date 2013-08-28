package Entities;

import java.util.Date;

public class Reservation {

	private long id;
	private Date startDate;
	private Date finishDate;
	private Pitch pitch;

	public Reservation() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Pitch getPitch() {
		return pitch;
	}

	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}

	@Override
	public String toString() {
		return pitch.getPitchId() + "( " + startDate + " - "
				+ finishDate + " )";
	}
	
	

}
