
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Javadata {

    private String path;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Javadata() {
    }

    /**
     * 
     * @param path
     */
    public Javadata(String path) {
        super();
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
