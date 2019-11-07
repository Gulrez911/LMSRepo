package com.assessment.data;

public enum CourseType {
	
	ONLINE("ONLINE");
	
	String type;
	
	private CourseType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	
	

}
