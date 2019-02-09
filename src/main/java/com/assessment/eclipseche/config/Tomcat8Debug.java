
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Tomcat8Debug {

    private Attributes_ attributes;
    private String port;
    private String protocol;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tomcat8Debug() {
    }

    /**
     * 
     * @param port
     * @param protocol
     * @param attributes
     */
    public Tomcat8Debug(Attributes_ attributes, String port, String protocol) {
        super();
        this.attributes = attributes;
        this.port = port;
        this.protocol = protocol;
    }

    public Attributes_ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_ attributes) {
        this.attributes = attributes;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
