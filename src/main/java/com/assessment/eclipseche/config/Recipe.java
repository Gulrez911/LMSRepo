
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Recipe {

    private String type;
    private String content;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipe() {
    }

    /**
     * 
     * @param content
     * @param type
     */
    public Recipe(String type, String content) {
        super();
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
