package Entities;

public enum Booking_Status {
	
    Canceled ("Storniert"),
    Reserved ("Reserviert"),
    Closed ("Abgeschlossen"),
    Activ ("Aktiv");

    private final String value;

    Booking_Status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
};
