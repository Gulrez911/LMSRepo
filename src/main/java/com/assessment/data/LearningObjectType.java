package com.assessment.data;

public enum LearningObjectType {
	
	COURSE("COURSE"), LEARNING_PATH("LEARNING_PATH");
	
	private String type;
	
	private LearningObjectType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	

}
