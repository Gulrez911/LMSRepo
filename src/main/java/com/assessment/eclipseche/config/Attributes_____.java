
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Attributes_____ {

    private String goal;
    private String previewUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes_____() {
    }

    /**
     * 
     * @param goal
     * @param previewUrl
     */
    public Attributes_____(String goal, String previewUrl) {
        super();
        this.goal = goal;
        this.previewUrl = previewUrl;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
