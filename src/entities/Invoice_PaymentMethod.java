package entities;

public enum Invoice_PaymentMethod {
	
	Cash ("Bar"),
    EC ("EC");

    private final String value;

	Invoice_PaymentMethod(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
