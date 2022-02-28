package lukyanov.task.xmlparser.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceSchemaValidatorTest {
    private static final DeviceSchemaValidator validator = DeviceSchemaValidator.getInstance();
    private static final String XSD_PATH = "resources/data/schema.xsd";
    private static final String XML_PATH = "resources/data/devices.xml";

    @Test
    void validateXml() {
        assertTrue(validator.validateXml(XML_PATH, XSD_PATH));
    }
}