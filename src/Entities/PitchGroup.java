package Entities;

public class PitchGroup {

	private long id;
	private String useage;
	private Area area;
	private transient float price;

	public PitchGroup() {
		super();
	}

	public PitchGroup(String useage, float price) {
		super();
		this.setUseage(useage);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUseage() {
		return useage;
	}

	public void setUseage(String useage) {
		switch (useage) {
		case "Tent":
			price = 5.5f;
			break;
		case "Caravan":
			price = 7.5f;
			break;
		case "Trailer":
			price = 7.5f;
			break;
		default:
			throw new RuntimeException("Unknown Usage type");
		}
		this.useage = useage;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public float getPrice() {
		return price;
	}

}
