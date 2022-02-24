package lukyanov.task.xmlparser.handler;

import lukyanov.task.xmlparser.builder.DeviceXmlTag;
import lukyanov.task.xmlparser.entity.Device;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class DeviceHandler extends DefaultHandler {
    private Set<Device> devices;
    private Device current;
    private DeviceXmlTag currentXmlName;
    private EnumSet<DeviceXmlTag> withText;
    private static final String ELEMENT_DEVICE = "device";

    public DeviceHandler() {
        devices = new HashSet<>();
        withText = EnumSet.range(DeviceXmlTag.NAME, DeviceXmlTag.SURROUND);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        StringBuilder tagData = new StringBuilder();
        tagData.append(qName);
        tagData.append(" ");
        for (int i = 0; i < attrs.getLength(); i++) {
            tagData.append(" ");
            tagData.append(attrs.getQName(i));
            tagData.append("=");
            tagData.append(attrs.getValue(i));
        }
        System.out.print(tagData);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(" " + qName);
    }

}
