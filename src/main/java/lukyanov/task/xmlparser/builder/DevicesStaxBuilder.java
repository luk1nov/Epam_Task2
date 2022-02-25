package lukyanov.task.xmlparser.builder;

import lukyanov.task.xmlparser.entity.AudioDevice;
import lukyanov.task.xmlparser.entity.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class DevicesStaxBuilder extends AbstractDeviceBuilder{
    private static final Logger logger = LogManager.getLogger();
    private XMLInputFactory inputFactory;

    public DevicesStaxBuilder() {
    }

    @Override
    public void buildSetDevices(String filename) {
        Device device = null;
        inputFactory = XMLInputFactory.newInstance();

        try(FileInputStream inputStream = new FileInputStream(filename)) {
            XMLEventReader reader = inputFactory.createXMLEventReader(inputStream);
            while (reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if(event.isStartElement()){
                    StartElement startElement = event.asStartElement();
                    DeviceXmlTag currentTag = DeviceXmlTag.valueOf(startElement.getName().getLocalPart().toUpperCase().replace("-","_"));
                    switch (currentTag){
                        case NAME -> {
                            event = reader.nextEvent();
                            device.setName(event.asCharacters().getData());
                        }
                    }
                    if(startElement.getName().getLocalPart().equals(DeviceXmlTag.AUDIO_DEVICE.getTagName())){
                        device = new AudioDevice();
                    }

                }
                if (event.isEndElement()){
                    EndElement endElement = event.asEndElement();
                    String endElementTag = endElement.getName().getLocalPart();
                    if(isDeviceTag(endElementTag)){
                        deviceSet.add(device);
                    }
                }

            }
        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDeviceTag(String tag){
        return DeviceXmlTag.AUDIO_DEVICE.getTagName().equals(tag) || DeviceXmlTag.STORAGE_DEVICE.getTagName().equals(tag);
    }
}
