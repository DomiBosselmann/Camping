package entities;

public enum Booking_Status {
	
    Canceled ("Storniert"),
    Reserved ("Reserviert"),
    Closed ("Abgeschloßen"),
    Active ("Aktiv");

    private final String value;

    Booking_Status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
};
