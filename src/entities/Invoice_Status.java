package entities;

public enum Invoice_Status {
	
	Pending ("Ausstehend"),
    Blocked ("Blockiert"),
    Canceled("Storniert"),
    Closed ("Abgeschloßen");

    private final String value;

	Invoice_Status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
