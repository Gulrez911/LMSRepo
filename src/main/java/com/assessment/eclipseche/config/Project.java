
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

    private List<Object> links = null;
    private String name;
    private Attributes___ attributes;
    private String type;
    private Source source;
    private String path;
    private String description;
    private List<Object> problems = null;
    private List<String> mixins = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Project() {
    }

    /**
     * 
     * @param mixins
     * @param problems
     * @param source
     * @param description
     * @param name
     * @param path
     * @param links
     * @param attributes
     * @param type
     */
    public Project(List<Object> links, String name, Attributes___ attributes, String type, Source source, String path, String description, List<Object> problems, List<String> mixins) {
        super();
        this.links = links;
        this.name = name;
        this.attributes = attributes;
        this.type = type;
        this.source = source;
        this.path = path;
        this.description = description;
        this.problems = problems;
        this.mixins = mixins;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes___ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes___ attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getProblems() {
        return problems;
    }

    public void setProblems(List<Object> problems) {
        this.problems = problems;
    }

    public List<String> getMixins() {
        return mixins;
    }

    public void setMixins(List<String> mixins) {
        this.mixins = mixins;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
