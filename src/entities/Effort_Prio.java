package entities;

public enum Effort_Prio {

	low("Niedrig"), normal("Normal"), high("Hoch");

	private final String value;

	Effort_Prio(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}
