package entities;

public enum Task_Status {

	Canceled ("Storniert"),
    Reserved ("Reserviert"),
    Closed ("Abgeschloßen");

    private final String value;

    Task_Status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
};
