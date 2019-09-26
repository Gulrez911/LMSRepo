package com.assessment.reports.manager;

public class UserTrait {
	
	String trait;
	
	String description;
	
	/**
	 * to be only sued in comprehensive reports
	 */
	String traitSpecifics;
	
	/**
	 * to be only sued in comprehensive reports
	 */
	Float percent;

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTraitSpecifics() {
		return traitSpecifics;
	}

	public void setTraitSpecifics(String traitSpecifics) {
		this.traitSpecifics = traitSpecifics;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}
	
	

}
