package com.loiane.dto;

import java.util.Map;

public class XmlPatchDto {
    private Map<String, Object> updates;

    public XmlPatchDto() {}

    public XmlPatchDto(Map<String, Object> updates) {
        this.updates = updates;
    }

    public Map<String, Object> getUpdates() {
        return updates;
    }

    public void setUpdates(Map<String, Object> updates) {
        this.updates = updates;
    }
}

