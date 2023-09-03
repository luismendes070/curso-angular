package com.loiane.service;

// ChatGPT
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import com.loiane.dto.XmlDto;
import com.loiane.dto.XmlPatchDto;
import com.loiane.exception.XmlNotFoundException;
import com.loiane.repository.XmlRepository;
import io.swagger.models.Xml;
import org.xml.sax.InputSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class XmlService {

    private XmlRepository xmlRepository;

    @Autowired
    public XmlService(XmlRepository xmlRepository) {
        this.xmlRepository = xmlRepository;

        // Create a SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // Create a SAXParser
        SAXParser saxParser = factory.newSAXParser();

        // Create a handler to process the XML content
        DefaultHandler handler = new MyHandler(); // You should implement MyHandler class

        // Parse the XML document
        saxParser.parse("./courses.xml", handler);

    } // end XmlService

    public XmlDto getXml(String id) throws XmlNotFoundException {
        // retrieve the XML document from the repository
        Xml xml = (Xml) xmlRepository.findById(id)
                .orElseThrow(() -> new XmlNotFoundException(id));

        return convertToDto(xml);
    }

    private XmlDto convertToDto(Xml xml) {
        return null;
    }

    public XmlDto updateXml(String id, XmlPatchDto patch) throws XmlNotFoundException {
        Xml xml = (Xml) xmlRepository.findById(id)
                .orElseThrow(() -> new XmlNotFoundException(id));

        // modify the XML document using the xpath expressions in the patch
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml.getContent())));

            XPath xpath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xpath.evaluate(patch.getXpath(), document, XPathConstants.NODE);
            node.setTextContent(patch.getValue());

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(), new StreamResult(writer));

            xml.setContent(writer.toString());
            xmlRepository.save(xml);
        } catch (Exception e){

            e.printStackTrace();

        }finally {

        }
        } // end method XmlDto
    }
