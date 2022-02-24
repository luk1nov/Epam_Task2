package lukyanov.task.xmlparser.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DeviceHandler extends DefaultHandler {

    @Override
    public void startDocument() {
        System.out.println("parse started");
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

    @Override
    public void endDocument() {
        System.out.println("parse ended");
    }
}
