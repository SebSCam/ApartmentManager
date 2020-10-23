package models;

public enum IDType {
	
	CC("C.C"),TI("T.I"),NIT("NIT"),CE("C.E");
	
	private String type;

	private IDType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}