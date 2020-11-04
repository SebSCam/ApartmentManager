package views;

public enum Concept {
	POOL_SERVICE("Piscina"), SCYTHE_SERVICE("Guadaña"), ADMINISTRATION("Pago Administracion");

	private String text;

	private Concept(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}