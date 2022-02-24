import lukyanov.task.xmlparser.builder.AbstractDeviceBuilder;
import lukyanov.task.xmlparser.factory.DeviceBuilderFactory;
import lukyanov.task.xmlparser.validator.DeviceSchemaValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        DeviceSchemaValidator validator = DeviceSchemaValidator.getInstance();
        if(validator.validateXml()){
            AbstractDeviceBuilder builder = DeviceBuilderFactory.createDeviceBuilder("SAX");
            builder.buildSetDevices("resources/data/devices.xml");
            System.out.println(builder.getDeviceSet().toString());

        }
    }
}
