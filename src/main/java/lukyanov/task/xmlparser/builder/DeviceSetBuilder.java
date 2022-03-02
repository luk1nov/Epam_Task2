package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.Device;
import lukyanov.task.xmlparser.exception.CustomException;
import lukyanov.task.xmlparser.factory.DeviceBuilderFactory;
import lukyanov.task.xmlparser.validator.DeviceSchemaValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class DeviceSetBuilder {
    private static final Logger logger = LogManager.getLogger();

    public Set<Device> createSet(String xmlPath, String xsdPath, String parserType) throws CustomException {
        Set<Device> devices = null;
        DeviceSchemaValidator validator = DeviceSchemaValidator.getInstance();
        if(validator.validateXml(xmlPath, xsdPath)){
            AbstractDeviceBuilder builder = DeviceBuilderFactory.createDeviceBuilder(parserType);
            try {
                builder.buildSetDevices(xmlPath);
                devices = builder.getDeviceSet();
            } catch (CustomException e) {
                logger.error(e.getMessage());
            }
            return devices;
        } else {
            logger.error("xml not valid (" + xmlPath + ")");
            throw new CustomException("xml not valid (" + xmlPath + ")");
        }
    }
}
