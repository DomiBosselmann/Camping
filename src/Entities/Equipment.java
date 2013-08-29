package entities;

public class Equipment {

	private long id;
	private Equipment_Kind kind;
	private int numberTents;
	private int numberVehicles;
	private int sizeTents;

	public Equipment() {
		super();
	}

	public Equipment_Kind getKind() {
		return kind;
	}

	public void setKind(Equipment_Kind kind) {
		this.kind = kind;
	}

	public int getNumberTents() {
		return numberTents;
	}

	public void setNumberTents(int numberTents) {
		this.numberTents = numberTents;
	}

	public int getNumberVehicles() {
		return numberVehicles;
	}

	public void setNumberVehicles(int numberVehicles) {
		this.numberVehicles = numberVehicles;
	}

	public int getSizeTents() {
		return sizeTents;
	}

	public void setSizeTents(int sizeTents) {
		this.sizeTents = sizeTents;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
