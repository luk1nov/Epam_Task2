package lukyanov.task.xmlparser.validator;

import lukyanov.task.xmlparser.exception.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceSchemaValidatorTest {
    private static final DeviceSchemaValidator validator = DeviceSchemaValidator.getInstance();
    private static final String XSD_PATH = "resources/data/schema.xsd";
    private static final String VALID_XML_PATH = "src/test/resources/data/devices_valid.xml";
    private static final String INVALID_XML_PATH = "src/test/resources/data/devices_invalid.xml";


    @Test
    void validateValidXml() {
        assertTrue(validator.validateXml(VALID_XML_PATH, XSD_PATH));
    }

    @Test
    void validateInvalidXml() {
        assertFalse(validator.validateXml(INVALID_XML_PATH, XSD_PATH));
    }
}