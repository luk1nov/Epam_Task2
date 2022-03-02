package lukyanov.task.xmlparser.entity;

import java.time.LocalDate;

public abstract class Device {
    private String deviceId;
    private String title;
    private String name;
    private String brand;
    private double price;
    private DeviceType type;
    private boolean critical;
    private LocalDate warranty;

    public Device() {
        type = new DeviceType();
    }

    public Device(String deviceId, String title, String name, String brand,
                  double price, DeviceType type, boolean critical, LocalDate warranty) {
        this.deviceId = deviceId;
        this.title = title;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.type = type;
        this.critical = critical;
        this.warranty = warranty;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDate getWarranty() {
        return warranty;
    }

    public void setWarranty(LocalDate warranty) {
        this.warranty = warranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        if (Double.compare(device.price, price) != 0) return false;
        if (critical != device.critical) return false;
        if (deviceId != null ? !deviceId.equals(device.deviceId) : device.deviceId != null) return false;
        if (title != null ? !title.equals(device.title) : device.title != null) return false;
        if (name != null ? !name.equals(device.name) : device.name != null) return false;
        if (brand != null ? !brand.equals(device.brand) : device.brand != null) return false;
        if (type != null ? !type.equals(device.type) : device.type != null) return false;
        return warranty != null ? warranty.equals(device.warranty) : device.warranty == null;
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
        sb.append("deviceId='").append(deviceId).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", type=").append(type);
        sb.append(", critical=").append(critical);
        sb.append(", warranty=").append(warranty);
        sb.append('}');
        return sb.toString();
    }

    protected static abstract class DeviceBuilder<B extends DeviceBuilder<?>>{
        protected String deviceId;
        protected String title;
        protected String name;
        protected String brand;
        protected double price;
        protected DeviceType type;
        protected boolean critical;
        protected LocalDate warranty;

        public B deviceId(String deviceId){
            this.deviceId = deviceId;
            return (B) this;
        }

        public B title(String title){
            this.title = title;
            return (B) this;
        }

        public B name(String name){
            this.name = name;
            return (B) this;
        }

        public B brand(String brand){
            this.brand = brand;
            return (B) this;
        }

        public B price(Double price){
            this.price = price;
            return (B) this;
        }

        public B type(DeviceType type){
            this.type = type;
            return (B) this;
        }

        public B critical(Boolean critical){
            this.critical = critical;
            return (B) this;
        }

        public B warranty(LocalDate warranty){
            this.warranty = warranty;
            return (B) this;
        }

        public abstract Device build();
    }
}
