
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Attributes____ {

    private String persistVolumes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes____() {
    }

    /**
     * 
     * @param persistVolumes
     */
    public Attributes____(String persistVolumes) {
        super();
        this.persistVolumes = persistVolumes;
    }

    public String getPersistVolumes() {
        return persistVolumes;
    }

    public void setPersistVolumes(String persistVolumes) {
        this.persistVolumes = persistVolumes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
