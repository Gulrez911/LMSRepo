
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Environments {

    private Default _default;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Environments() {
    }

    /**
     * 
     * @param _default
     */
    public Environments(Default _default) {
        super();
        this._default = _default;
    }

    public Default getDefault() {
        return _default;
    }

    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
