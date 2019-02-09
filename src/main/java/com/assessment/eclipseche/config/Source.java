
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Source {

    private String location;
    private String type;
    private Parameters parameters;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param location
     * @param parameters
     * @param type
     */
    public Source(String location, String type, Parameters parameters) {
        super();
        this.location = location;
        this.type = type;
        this.parameters = parameters;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
