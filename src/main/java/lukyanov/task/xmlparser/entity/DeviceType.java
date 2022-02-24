package lukyanov.task.xmlparser.entity;


import java.util.Objects;

public class DeviceType {
    private boolean peripheral;
    private int powerUsage;
    private boolean cooler;
    private Ports ports;

    public DeviceType() {
        ports = new Ports();
    }

    public boolean isPeripheral() {
        return peripheral;
    }

    public void setPeripheral(boolean peripheral) {
        this.peripheral = peripheral;
    }

    public int getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(int powerUsage) {
        this.powerUsage = powerUsage;
    }

    public boolean isCooler() {
        return cooler;
    }

    public void setCooler(boolean cooler) {
        this.cooler = cooler;
    }

    public Ports getPorts() {
        return ports;
    }

    public void setPorts(Ports ports) {
        this.ports = ports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceType that = (DeviceType) o;
        return peripheral == that.peripheral && powerUsage == that.powerUsage && cooler == that.cooler && ports.equals(that.ports);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (peripheral ? 1 : 0);
        result = 31 * result + powerUsage;
        result = 31 * result + (cooler ? 1 : 0);
        result = 31 * result + (ports != null ? ports.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeviceType{");
        sb.append("peripheral=").append(peripheral);
        sb.append(", powerUsage=").append(powerUsage);
        sb.append(", cooler=").append(cooler);
        sb.append(", ports=").append(ports);
        sb.append('}');
        return sb.toString();
    }
}
