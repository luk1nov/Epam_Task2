package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DevicesStaxBuilder extends AbstractDeviceBuilder{
    private static final Logger logger = LogManager.getLogger();
    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';
    private XMLInputFactory inputFactory;

    public DevicesStaxBuilder() {
    }

    @Override
    public void buildSetDevices(String filename) {
        inputFactory = XMLInputFactory.newInstance();
        try(FileInputStream inputStream = new FileInputStream(filename)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()){
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT){
                    String name = reader.getLocalName();
                    if (isDeviceTag(name)){
                        Device device = buildDevice(reader);
                        deviceSet.add(device);
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error();
        }
    }

    private Device buildDevice(XMLStreamReader reader) throws XMLStreamException {
        Device device = reader.getLocalName().equals(DeviceXmlTag.AUDIO_DEVICE.getTagName()) ? new AudioDevice() : new StorageDevice();
        device.setDeviceId(reader.getAttributeValue(null, DeviceXmlTag.DEVICE_ID.getTagName()));
        device.setTitle(reader.getAttributeValue(null, DeviceXmlTag.TITLE.getTagName()));
        String name;
        while(reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT -> {
                    name = reader.getLocalName();
                    switch (DeviceXmlTag.valueOf(name.toUpperCase().replace(HYPHEN, UNDERSCORE))){
                        case NAME -> device.setName(getXMLText(reader));
                        case BRAND -> device.setBrand(getXMLText(reader));
                        case PRICE -> device.setPrice(Double.parseDouble(getXMLText(reader)));
                        case CRITICAL -> device.setCritical(Boolean.parseBoolean(getXMLText(reader)));
                        case TYPE -> {
                            DeviceType deviceType = device.getType();

                        }
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {

                }
            }
        }

        return device;
    }


    private void buildDeviceType(XMLStreamReader reader, DeviceType deviceType) throws XMLStreamException {
        while (reader.hasNext()){
            int type = reader.next();
            String name = reader.getLocalName();
            switch (type){
                case XMLStreamConstants.START_ELEMENT -> {
                    String data = getXMLText(reader);
                    DeviceXmlTag currentTag = DeviceXmlTag.valueOf(name.toUpperCase().replace(HYPHEN, UNDERSCORE));
                    switch (currentTag){
                        case PERIPHERAL -> deviceType.setPeripheral(Boolean.parseBoolean(data));
                        case POWER_USAGE -> deviceType.setPowerUsage(Integer.parseInt(data));
                        case COOLER -> deviceType.setCooler(Boolean.parseBoolean(data));
                        case PORTS -> {
                            Ports ports = deviceType.getPorts();

                        }
                        default -> logger.error("tag not found");
                    }

                }
                case XMLStreamConstants.END_ELEMENT -> {

                }
            }
        }

    }


    private void buildDevicePorts(XMLStreamReader reader, Ports ports) throws XMLStreamException {
        while (reader.hasNext()){
            int type = reader.next();
            String name = reader.getLocalName();
            switch (type){
                case XMLStreamConstants.START_ELEMENT -> {
                    String data = getXMLText(reader);
                    DeviceXmlTag currentTag = DeviceXmlTag.valueOf(name.toUpperCase().replace(HYPHEN, UNDERSCORE));
                    switch (currentTag){
                        case COM -> ports.setCom(Boolean.parseBoolean(data));
                        case USB -> ports.setUsb(Boolean.parseBoolean(data));
                        case LPT -> ports.setLpt(Boolean.parseBoolean(data));
                        default -> logger.error("tag not found");
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {

                }
            }
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    public boolean isDeviceTag(String tag){
        return DeviceXmlTag.AUDIO_DEVICE.getTagName().equals(tag) || DeviceXmlTag.STORAGE_DEVICE.getTagName().equals(tag);
    }
}
