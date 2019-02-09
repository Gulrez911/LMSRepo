
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Servers {

    private Tomcat8Debug tomcat8Debug;
    private Tomcat8 tomcat8;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Servers() {
    }

    /**
     * 
     * @param tomcat8
     * @param tomcat8Debug
     */
    public Servers(Tomcat8Debug tomcat8Debug, Tomcat8 tomcat8) {
        super();
        this.tomcat8Debug = tomcat8Debug;
        this.tomcat8 = tomcat8;
    }

    public Tomcat8Debug getTomcat8Debug() {
        return tomcat8Debug;
    }

    public void setTomcat8Debug(Tomcat8Debug tomcat8Debug) {
        this.tomcat8Debug = tomcat8Debug;
    }

    public Tomcat8 getTomcat8() {
        return tomcat8;
    }

    public void setTomcat8(Tomcat8 tomcat8) {
        this.tomcat8 = tomcat8;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
