
package com.assessment.eclipseche.config;

import java.util.HashMap;
import java.util.Map;

public class Default {

    private Machines machines;
    private Recipe recipe;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Default() {
    }

    /**
     * 
     * @param recipe
     * @param machines
     */
    public Default(Machines machines, Recipe recipe) {
        super();
        this.machines = machines;
        this.recipe = recipe;
    }

    public Machines getMachines() {
        return machines;
    }

    public void setMachines(Machines machines) {
        this.machines = machines;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
