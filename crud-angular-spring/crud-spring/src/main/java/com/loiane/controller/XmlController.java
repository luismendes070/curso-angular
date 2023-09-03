package com.loiane.controller;

import com.loiane.model.XmlData;
import com.loiane.response.XmlResponse;
import com.loiane.xmlannotations.XmlPatchVariable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class XmlController {

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<XmlData> patchXmlData(@PathVariable Long id, @PatchVariable XmlData xmlData) {
        // Implement the logic to update the XML data based on the id
        return ResponseEntity.ok(xmlData);
    }
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public XmlResponse getXmlData() {
        XmlResponse response = new XmlResponse();
        response.setMessage("This is a message in XML format");
        return response;
    }
} // end class
