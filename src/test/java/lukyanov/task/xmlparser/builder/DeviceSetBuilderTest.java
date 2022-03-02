package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.creator.AudioDeviceCreator;
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
    private static final String VALID_XML_PATH = "src/test/resources/data/devices_valid.xml";
    private static final String INVALID_XML_PATH = "src/test/resources/data/devices_invalid.xml";
    private static final String PARSER_TYPE = "SAX";

    @Test
    public void createValidSizeSet() {
        int expectedSize = 6;
        try {
            Set<Device> devices = builder.createSet(VALID_XML_PATH, XSD_PATH, PARSER_TYPE);
            assertEquals(devices.size(), expectedSize);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void createValidInnerSet() {
        Device expectedDevice = AudioDeviceCreator.createAudioDevice();
        try {
            Set<Device> devices = builder.createSet(VALID_XML_PATH, XSD_PATH, PARSER_TYPE);
            assertTrue(devices.contains(expectedDevice));
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void createInvalidSet(){
        assertThrows(CustomException.class, () ->{
            Set<Device> devices = builder.createSet(INVALID_XML_PATH, XSD_PATH, PARSER_TYPE);
        });
    }
}