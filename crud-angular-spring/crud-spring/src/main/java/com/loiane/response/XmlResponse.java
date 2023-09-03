package com.loiane.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
} // end class
