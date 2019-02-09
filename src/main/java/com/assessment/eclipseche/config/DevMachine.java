
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevMachine {

    private Attributes attributes;
    private Servers servers;
    private Volumes volumes;
    private List<String> installers = null;
    private Env env;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DevMachine() {
    }

    /**
     * 
     * @param servers
     * @param installers
     * @param env
     * @param volumes
     * @param attributes
     */
    public DevMachine(Attributes attributes, Servers servers, Volumes volumes, List<String> installers, Env env) {
        super();
        this.attributes = attributes;
        this.servers = servers;
        this.volumes = volumes;
        this.installers = installers;
        this.env = env;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Servers getServers() {
        return servers;
    }

    public void setServers(Servers servers) {
        this.servers = servers;
    }

    public Volumes getVolumes() {
        return volumes;
    }

    public void setVolumes(Volumes volumes) {
        this.volumes = volumes;
    }

    public List<String> getInstallers() {
        return installers;
    }

    public void setInstallers(List<String> installers) {
        this.installers = installers;
    }

    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
