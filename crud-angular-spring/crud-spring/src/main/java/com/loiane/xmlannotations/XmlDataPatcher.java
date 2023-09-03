package com.loiane.xmlannotations;

import com.loiane.model.XmlData;

import java.util.Map;

public class XmlDataPatcher {
    public void patch(XmlData xmlData, Map<String, Object> updates) {
        if (updates.containsKey("name")) {
            xmlData.setName((String) updates.get("name"));
        }
        if (updates.containsKey("description")) {
            xmlData.setDescription((String) updates.get("description"));
        }
    }
}

