package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.Device;
import lukyanov.task.xmlparser.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DeviceSetBuilderTest {
    private static final DeviceSetBuilder builder = new DeviceSetBuilder();
    private static final Logger logger = LogManager.getLogger();
    private static final String XSD_PATH = "resources/data/schema.xsd";
    private static final String XML_PATH = "resources/data/devices.xml";
    private static final String PARSER_TYPE = "SAX";

    @Test
    void createSet() {
        int expectedSize = 6;
        try {
            Set<Device> devices = builder.createSet(XML_PATH, XSD_PATH, PARSER_TYPE);
            assertEquals(devices.size(), expectedSize);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }
}