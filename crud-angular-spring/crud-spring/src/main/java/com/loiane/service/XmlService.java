package com.loiane.service;

import com.loiane.dto.XmlDto;
import com.loiane.dto.XmlPatchDto;
import com.loiane.exception.XmlNotFoundException;
import com.loiane.repository.XmlRepository;
import io.swagger.models.Xml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import java.io.StringWriter;

@Service
public class XmlService {

    private final XmlRepository xmlRepository;

    @Autowired
    public XmlService(XmlRepository xmlRepository) {
        this.xmlRepository = xmlRepository;
    }

    public XmlDto getXml(String id) {
        // retrieve the XML document from the repository
        Xml xml = xmlRepository.findById(id)
                .orElseThrow(() -> new XmlNotFoundException(id));

        return convertToDto(xml);
    }

    public XmlDto updateXml(String id, XmlPatchDto patch) {
        Xml xml = xmlRepository.findById(id)
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
            transformer.transform(new DOMSource(document), new StreamResult(writer));

            xml.setContent(writer.toString());
            xmlRepository.save(xml);
        } catch (Exception e){

        }finally {

        }
        } // end method XmlDto
    }
