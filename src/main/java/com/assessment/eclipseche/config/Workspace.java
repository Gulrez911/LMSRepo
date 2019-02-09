
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Workspace {

    private String defaultEnv;
    private Environments environments;
    private List<Project> projects = null;
    private String name;
    private Attributes____ attributes;
    private List<Command> commands = null;
    private List<Object> links = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Workspace() {
    }

    /**
     * 
     * @param projects
     * @param commands
     * @param name
     * @param environments
     * @param defaultEnv
     * @param links
     * @param attributes
     */
    public Workspace(String defaultEnv, Environments environments, List<Project> projects, String name, Attributes____ attributes, List<Command> commands, List<Object> links) {
        super();
        this.defaultEnv = defaultEnv;
        this.environments = environments;
        this.projects = projects;
        this.name = name;
        this.attributes = attributes;
        this.commands = commands;
        this.links = links;
    }

    public String getDefaultEnv() {
        return defaultEnv;
    }

    public void setDefaultEnv(String defaultEnv) {
        this.defaultEnv = defaultEnv;
    }

    public Environments getEnvironments() {
        return environments;
    }

    public void setEnvironments(Environments environments) {
        this.environments = environments;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes____ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes____ attributes) {
        this.attributes = attributes;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
