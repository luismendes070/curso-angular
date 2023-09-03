package com.loiane;

import com.loiane.model.XmlData;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XmlDataPatcherTest {
    @Test
    public void testPatch() {
        // Test logic goes here

        // a
        XmlData xmlData = new XmlData();
        xmlData.setName("Test");
        xmlData.setDescription("This is a test");

        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "Updated name");
        updates.put("description", "Updated description");

        // a
        XmlDataPatcher patcher = new XmlDataPatcher();
        patcher.patch(xmlData, updates);

        assertEquals("Updated name", xmlData.getName());
        assertEquals("Updated description", xmlData.getDescription());

    } // end method testPatch
} // end class XmlDataPatcherTest

