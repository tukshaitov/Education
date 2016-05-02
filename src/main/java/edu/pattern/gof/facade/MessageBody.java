package edu.pattern.gof.facade;

import org.apache.commons.collections4.KeyValue;
import org.w3c.dom.Document;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class MessageBody {
    private Document document;
    private Element root;
    private Element currentElement;

    public MessageBody() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.newDocument();
            root = document.createElement("HTML");
            currentElement = root;
            document.appendChild(root);
        } catch (Exception e) {
        }
    }
    public Element addElement(String name, String value, KeyValue<String, String> ... attributes) {
        return addElement(this.currentElement, name, value, attributes);
    }

    public Element addElement(Element currentElement, String name, String value, KeyValue<String, String> ... attributes) {
        Element element = document.createElement(name);
        for(KeyValue<String, String> attribute: attributes) {
            element.setAttribute(attribute.getKey(), attribute.getValue());
        }
        if(value != null)
        element.setTextContent(value);
        currentElement.appendChild(element);
        return element;
    }

    @Override
    public String toString(){
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(this.document), new StreamResult(writer));
            return writer.getBuffer().toString().replaceAll("\n|\r", "");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
