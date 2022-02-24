package lukyanov.task.xmlparser.validator;

import lukyanov.task.xmlparser.exception.CustomException;
import lukyanov.task.xmlparser.handler.DeviceErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class DeviceSchemaValidator {
    private static final Logger logger = LogManager.getLogger();
    private static DeviceSchemaValidator instance;

    private DeviceSchemaValidator() {
    }

    public static DeviceSchemaValidator getInstance(){
        if(instance == null){
            instance = new DeviceSchemaValidator();
        }
        return instance;
    }

    public boolean validateXml(){
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "resources/data/devices.xml";
        String schemaName = "resources/data/schema.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new DeviceErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            logger.info(fileName + " is not correct or valid");
            return false;
        }
        return true;
    }
}
