package com.loiane.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class XmlData {

    private Long id;
    private String name;
    private String description;

// Getters and setters for the fields


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
