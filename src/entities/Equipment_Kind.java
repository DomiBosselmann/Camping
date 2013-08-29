package entities;

public enum Equipment_Kind {
	
	Tent ("Zelt"),
	Trailer ("Wohnwagen"),
	Caravan("Wohnmobil"),
	TentTrailer ("Zelt & Wohnwagen"),
	TrailerCaravan ("Wohnwagen & Wohnmobil"),
	TentCaravan ("Zelt & Wohnmobil"),
	TentTrailerCaravan ("Zelt & Wohnwagen & Wohnmobil");
    

    private final String value;

	Equipment_Kind(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
