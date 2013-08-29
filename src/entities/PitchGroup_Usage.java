package entities;

public enum PitchGroup_Usage {
	Tent("Zelt"), Trailer("Wohnwagen"), Caravan("Wohnmobil");

	private final String value;

	PitchGroup_Usage(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}