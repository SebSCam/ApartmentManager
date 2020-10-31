package models;

public enum ExtraServices {

    POOL_SERVICE("SERVICIO DE PISCINA"), SCYTHE_SERVICE("SERVICIO DE GUADAÑA");

    private String nameService;

    private ExtraServices(String nameService) {
        this.nameService = nameService;
    }

    @Override
    public String toString() {
        return nameService;
    }
}
