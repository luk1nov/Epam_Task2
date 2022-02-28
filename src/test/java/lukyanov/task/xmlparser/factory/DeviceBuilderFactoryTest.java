package lukyanov.task.xmlparser.factory;

import lukyanov.task.xmlparser.builder.AbstractDeviceBuilder;
import lukyanov.task.xmlparser.builder.DevicesDomBuilder;
import lukyanov.task.xmlparser.builder.DevicesSaxBuilder;
import lukyanov.task.xmlparser.builder.DevicesStaxBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceBuilderFactoryTest {
    private static final String SAX = "SAX";
    private static final String STAX = "STAX";
    private static final String DOM = "DOM";

    @Test
    void createDeviceStaxBuilder() {
        AbstractDeviceBuilder builder = DeviceBuilderFactory.createDeviceBuilder(STAX);
        assertTrue(builder instanceof DevicesStaxBuilder);
    }

    @Test
    void createDeviceSaxBuilder() {
        AbstractDeviceBuilder builder = DeviceBuilderFactory.createDeviceBuilder(SAX);
        assertTrue(builder instanceof DevicesSaxBuilder);
    }

    @Test
    void createDeviceDomBuilder() {
        AbstractDeviceBuilder builder = DeviceBuilderFactory.createDeviceBuilder(DOM);
        assertTrue(builder instanceof DevicesDomBuilder);
    }
}