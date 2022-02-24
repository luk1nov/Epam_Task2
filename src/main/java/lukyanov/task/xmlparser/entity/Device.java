package lukyanov.task.xmlparser.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Device {
    private String name;
    private String brand;
    private double price;
    private DeviceType type;
    private boolean critical;
    private LocalDateTime warranty;

    public Device() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public LocalDateTime getWarranty() {
        return warranty;
    }

    public void setWarranty(LocalDateTime warranty) {
        this.warranty = warranty;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Double.compare(device.price, price) == 0 && critical == device.critical && name.equals(device.name) && brand.equals(device.brand) && type.equals(device.type) && warranty.equals(device.warranty);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 17 * result + name.hashCode();
        result = 17 * result + brand.hashCode();
        result = 17 * result + Double.hashCode(price);
        result = 17 * result + type.hashCode();
        result = 17 * result + (critical ? 1 : 0);
        result = 17 * result + warranty.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Device{");
        sb.append("name='").append(name).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", type=").append(type);
        sb.append(", critical=").append(critical);
        sb.append(", warranty=").append(warranty);
        sb.append('}');
        return sb.toString();
    }
}
