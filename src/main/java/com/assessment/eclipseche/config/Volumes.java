
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Volumes {

    private M2 m2;
    private Javadata javadata;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Volumes() {
    }

    /**
     * 
     * @param javadata
     * @param m2
     */
    public Volumes(M2 m2, Javadata javadata) {
        super();
        this.m2 = m2;
        this.javadata = javadata;
    }

    public M2 getM2() {
        return m2;
    }

    public void setM2(M2 m2) {
        this.m2 = m2;
    }

    public Javadata getJavadata() {
        return javadata;
    }

    public void setJavadata(Javadata javadata) {
        this.javadata = javadata;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
