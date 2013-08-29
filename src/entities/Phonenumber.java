package entities;

public class Phonenumber {

	private int country;
	private long nationalNumber;
	private boolean beginningWithPlusSign;

	public Phonenumber() {
		super();
	}

	public Phonenumber(int country, long nationalNumber,
			boolean beginningWithPlusSign) {
		super();
		this.country = country;
		this.nationalNumber = nationalNumber;
		this.beginningWithPlusSign = beginningWithPlusSign;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public long getNationalNumber() {
		return nationalNumber;
	}

	public void setNationalNumber(long nationalNumber) {
		this.nationalNumber = nationalNumber;
	}

	public boolean isBeginningWithPlusSign() {
		return beginningWithPlusSign;
	}

	public void setBeginningWithPlusSign(boolean beginningWithPlusSign) {
		this.beginningWithPlusSign = beginningWithPlusSign;
	}

}
