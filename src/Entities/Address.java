package entities;

public class Address {

	private long id;
	private String streetName;
	private String houseNumber;
	private int zipCode;
	private String city;

	public Address() {
		super();
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Address(String streetName, String houseNumer, int zipCode,
			String city) {
		super();
		this.streetName = streetName;
		this.houseNumber = houseNumer;
		this.zipCode = zipCode;
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumer) {
		this.houseNumber = houseNumer;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
