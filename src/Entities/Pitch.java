package Entities;

public class Pitch extends Property {

	private String pitchId;
	private int size;
	private boolean waterSupplied;
	private boolean powerSupplied;
	private Reservation reservation;
	private PitchGroup group;

	public Pitch() {
		super();
	}

	

	public Pitch(String pitchId, int size, boolean waterSupplied,
			boolean powerSupplied) {
		super();
		this.pitchId = pitchId;
		this.size = size;
		this.waterSupplied = waterSupplied;
		this.powerSupplied = powerSupplied;
	}



	public String getPitchId() {
		return pitchId;
	}

	public void setPitchId(String id) {
		this.pitchId = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isWaterSupplied() {
		return waterSupplied;
	}

	public void setWaterSupply(boolean waterSupply) {
		this.waterSupplied = waterSupply;
	}

	public boolean isPowerSupplied() {
		return powerSupplied;
	}

	public void setPowerSupply(boolean powerSupply) {
		this.powerSupplied = powerSupply;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public PitchGroup getGroup() {
		return group;
	}

	public void setGroup(PitchGroup group) {
		this.group = group;
	}
	
	public float calcPrice(){
		float price = group.getPrice();
		if(powerSupplied){
			price += 2.5f;
		}
		if(waterSupplied){
			price += 2.5f;
		}
		return price;
	}

}
