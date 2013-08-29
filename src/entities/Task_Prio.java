package entities;

public enum Task_Prio {

	low("Niedrig"), normal("Normal"), high("Hoch");

	private final String value;

	Task_Prio(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}
