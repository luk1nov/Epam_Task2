package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.Device;

import javax.xml.parsers.DocumentBuilder;
import java.util.Set;

public class DevicesDomBuilder extends AbstractDeviceBuilder{
    private DocumentBuilder docBuilder;

    public DevicesDomBuilder() {
    }

    public DevicesDomBuilder(Set<Device> devices) {
        super(devices);
    }

    @Override
    public void buildSetDevices(String filename) {

    }
}
