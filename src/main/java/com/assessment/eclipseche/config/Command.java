
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Command {

    private String commandLine;
    private String name;
    private Attributes_____ attributes;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Command() {
    }

    /**
     * 
     * @param commandLine
     * @param name
     * @param attributes
     * @param type
     */
    public Command(String commandLine, String name, Attributes_____ attributes, String type) {
        super();
        this.commandLine = commandLine;
        this.name = name;
        this.attributes = attributes;
        this.type = type;
    }

    public String getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes_____ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_____ attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
