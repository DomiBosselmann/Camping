package TestClasses;

public class myClass {

	private String desc;

	public myClass(String desc) {
		super();
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "myClass [desc=" + desc + "]";
	}
}
