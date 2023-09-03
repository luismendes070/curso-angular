package com.loiane.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlDto {
    private String name;
    private String description;

    public XmlDto() {}

    public XmlDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
} // end class XmlDto

