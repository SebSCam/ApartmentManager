package views;

public enum TableOptions {
    PROPIETARIOS("TODOS"), MORA("EN MORA"), ALDIA("AL DIA");

    private String text;

    private TableOptions(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
