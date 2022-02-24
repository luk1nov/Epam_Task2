package lukyanov.task.xmlparser.entity;

public enum Brand {
    RAZER("Razer"),
    SONY("Sony"),
    HYPERX("HyperX"),
    LOGITECH("Logitech"),
    OCLICK("Oclick"),
    SANDISK("Sandisk"),
    WD("WD");

    private final String brand;

    Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
