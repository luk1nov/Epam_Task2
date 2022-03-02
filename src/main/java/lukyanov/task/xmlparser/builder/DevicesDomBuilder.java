package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.*;
import lukyanov.task.xmlparser.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;

public class DevicesDomBuilder extends AbstractDeviceBuilder{
    private static final Logger logger = LogManager.getLogger();
    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';
    private DocumentBuilder docBuilder;


    public DevicesDomBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void buildSetDevices(String filename) throws CustomException {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList deviceList = root.getElementsByTagName(DeviceXmlTag.AUDIO_DEVICE.getTagName());
            for (int i = 0; i < deviceList.getLength(); i++) {
                Element deviceElement = (Element) deviceList.item(i);
                Device device = buildDevice(deviceElement);
                deviceSet.add(device);
            }

            deviceList = root.getElementsByTagName(DeviceXmlTag.STORAGE_DEVICE.getTagName());
            for (int i = 0; i < deviceList.getLength(); i++) {
                Element deviceElement = (Element) deviceList.item(i);
                Device device = buildDevice(deviceElement);
                deviceSet.add(device);
            }

        } catch (SAXException | IOException e) {
            logger.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }

    private Device buildDevice(Element deviceElement){
        Device device = deviceElement.getTagName().equals(DeviceXmlTag.AUDIO_DEVICE.getTagName()) ?
                new AudioDevice() : new StorageDevice();
        String data = deviceElement.getAttribute(DeviceXmlTag.DEVICE_ID.getTagName());
        device.setDeviceId(data);

        data = deviceElement.getAttribute(DeviceXmlTag.TITLE.getTagName());
        device.setTitle(data);

        data = getElementTextContent(deviceElement, DeviceXmlTag.NAME.getTagName());
        device.setName(data);

        data = getElementTextContent(deviceElement, DeviceXmlTag.BRAND.getTagName());
        data = Brand.valueOf(data.toUpperCase().replace(HYPHEN, UNDERSCORE)).getBrand();
        device.setBrand(data);

        data = getElementTextContent(deviceElement, DeviceXmlTag.PRICE.getTagName());
        device.setPrice(Double.parseDouble(data));

        data = getElementTextContent(deviceElement, DeviceXmlTag.CRITICAL.getTagName());
        device.setCritical(Boolean.parseBoolean(data));

        data = getElementTextContent(deviceElement, DeviceXmlTag.WARRANTY.getTagName());
        device.setWarranty(LocalDate.parse(data));

        DeviceType type = device.getType();
        data = getElementTextContent(deviceElement, DeviceXmlTag.PERIPHERAL.getTagName());
        type.setPeripheral(Boolean.parseBoolean(data));

        data = getElementTextContent(deviceElement, DeviceXmlTag.POWER_USAGE.getTagName());
        type.setPowerUsage(Integer.parseInt(data));

        data = getElementTextContent(deviceElement, DeviceXmlTag.COOLER.getTagName());
        type.setCooler(Boolean.parseBoolean(data));

        Ports ports = type.getPorts();
        data = getElementTextContent(deviceElement, DeviceXmlTag.COM.getTagName());
        ports.setCom(Boolean.parseBoolean(data));

        data = getElementTextContent(deviceElement, DeviceXmlTag.USB.getTagName());
        ports.setUsb(Boolean.parseBoolean(data));

        data = getElementTextContent(deviceElement, DeviceXmlTag.LPT.getTagName());
        ports.setLpt(Boolean.parseBoolean(data));

        if (device instanceof AudioDevice audioDevice){
            data = getElementTextContent(deviceElement, DeviceXmlTag.WIRELESS.getTagName());
            audioDevice.setWireless(Boolean.parseBoolean(data));
            data = getElementTextContent(deviceElement, DeviceXmlTag.SURROUND.getTagName());
            audioDevice.setSurround(data);
        } else {
            StorageDevice storageDevice = (StorageDevice) device;
            data = getElementTextContent(deviceElement, DeviceXmlTag.STORAGE_CAPACITY.getTagName());
            storageDevice.setStorageCapacity(Integer.parseInt(data));
            data = getElementTextContent(deviceElement, DeviceXmlTag.WRITE_SPEED.getTagName());
            storageDevice.setWriteSpeed(Integer.parseInt(data));
            data = getElementTextContent(deviceElement, DeviceXmlTag.READING_SPEED.getTagName());
            storageDevice.setReadingSpeed(Integer.parseInt(data));
        }
        return device;
    }

    private String getElementContent(Element element, String elementName){
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    private String getElementTextContent(Element element, String elementName){
        return getElementContent(element, elementName).strip();
    }

}
