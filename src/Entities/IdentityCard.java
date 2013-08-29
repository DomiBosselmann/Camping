package entities;

public class IdentityCard {

	private String id;
	private String authority;

	public IdentityCard() {
		super();
	}

	public IdentityCard(String identityCard, String country) {
		super();
		this.id = identityCard;
		this.authority = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String identityCard) {
		this.id = identityCard;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
