
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attributes___ {

    private List<String> contributeToBranch = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes___() {
    }

    /**
     * 
     * @param contributeToBranch
     */
    public Attributes___(List<String> contributeToBranch) {
        super();
        this.contributeToBranch = contributeToBranch;
    }

    public List<String> getContributeToBranch() {
        return contributeToBranch;
    }

    public void setContributeToBranch(List<String> contributeToBranch) {
        this.contributeToBranch = contributeToBranch;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
