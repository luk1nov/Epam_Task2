package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.Device;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDeviceBuilder {

    protected Set<Device> devices;

    public AbstractDeviceBuilder() {
        devices = new HashSet<>();
    }

    public AbstractDeviceBuilder(Set<Device> devices) {
        this.devices = devices;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public abstract void buildSetDevices(String filename);
}
