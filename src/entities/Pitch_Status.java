package entities;

public enum Pitch_Status {
	
    Available ("Frei"),
    Booked ("Gebucht"),
    Service ("In Wartung"),
    NotAvailable("Nicht Verfügbar");

    private final String value;

    Pitch_Status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
};
