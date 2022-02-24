package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.Device;
import lukyanov.task.xmlparser.handler.DeviceErrorHandler;
import lukyanov.task.xmlparser.handler.DeviceHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class DevicesSaxBuilder extends AbstractDeviceBuilder{
    private static final Logger logger = LogManager.getLogger();
    private DeviceHandler handler;
    private final SAXParserFactory factory;


    public DevicesSaxBuilder() {
        factory = SAXParserFactory.newInstance();
        handler = new DeviceHandler();
    }



    @Override
    public void buildSetDevices(String filename) {
        try {
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(new DeviceErrorHandler());
            reader.parse(filename);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error(e.getMessage());
        }

    }
}
