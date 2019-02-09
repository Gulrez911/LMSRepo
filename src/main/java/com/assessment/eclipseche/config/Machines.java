
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Machines {

    private DevMachine devMachine;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Machines() {
    }

    /**
     * 
     * @param devMachine
     */
    public Machines(DevMachine devMachine) {
        super();
        this.devMachine = devMachine;
    }

    public DevMachine getDevMachine() {
        return devMachine;
    }

    public void setDevMachine(DevMachine devMachine) {
        this.devMachine = devMachine;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
