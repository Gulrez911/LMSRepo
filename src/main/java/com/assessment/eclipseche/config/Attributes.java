
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Attributes {

    private String memoryLimitBytes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes() {
    }

    /**
     * 
     * @param memoryLimitBytes
     */
    public Attributes(String memoryLimitBytes) {
        super();
        this.memoryLimitBytes = memoryLimitBytes;
    }

    public String getMemoryLimitBytes() {
        return memoryLimitBytes;
    }

    public void setMemoryLimitBytes(String memoryLimitBytes) {
        this.memoryLimitBytes = memoryLimitBytes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
