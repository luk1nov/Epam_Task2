package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.Device;

import javax.xml.stream.XMLInputFactory;
import java.util.Set;

public class DevicesStaxBuilder extends AbstractDeviceBuilder{
    private XMLInputFactory inputFactory;

    public DevicesStaxBuilder() {
    }

    public DevicesStaxBuilder(Set<Device> devices) {
        super(devices);
    }

    @Override
    public void buildSetDevices(String filename) {

    }
}
