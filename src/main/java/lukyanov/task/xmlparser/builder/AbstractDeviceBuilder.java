package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.Device;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDeviceBuilder {

    protected Set<Device> deviceSet;

    public AbstractDeviceBuilder() {
        deviceSet = new HashSet<>();
    }

    public AbstractDeviceBuilder(Set<Device> deviceSet) {
        this.deviceSet = deviceSet;
    }

    public Set<Device> getDeviceSet() {
        return deviceSet;
    }

    public abstract void buildSetDevices(String filename);
}
