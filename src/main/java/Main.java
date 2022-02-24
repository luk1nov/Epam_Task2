import lukyanov.task.xmlparser.entity.Device;
import lukyanov.task.xmlparser.entity.Ports;
import lukyanov.task.xmlparser.handler.DeviceErrorHandler;
import lukyanov.task.xmlparser.handler.DeviceHandler;
import lukyanov.task.xmlparser.validator.DeviceSchemaValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        DeviceSchemaValidator validator = DeviceSchemaValidator.getInstance();
        if(validator.validateXml()){
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                XMLReader reader = parser.getXMLReader();
                reader.setContentHandler(new DeviceHandler());
                reader.setErrorHandler(new DeviceErrorHandler());
                reader.parse("resources/data/devices.xml");
            } catch (SAXException | IOException | ParserConfigurationException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
