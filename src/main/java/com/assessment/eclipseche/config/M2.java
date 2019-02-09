
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class M2 {

    private String path;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public M2() {
    }

    /**
     * 
     * @param path
     */
    public M2(String path) {
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
