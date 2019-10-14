package com.assessment.data;

public enum DifficultyLevel {
	
	VERY_EASY("VERY_EASY"), EASY("EASY"), MEDIUM("MEDIUM"), DIFFICULT("DIFFICULT"), VERY_DIFFICULT("VERY_DIFFICULT");
	
	String level;
	private DifficultyLevel(String level) {
		this.level = level;
	}
	public String getLevel() {
		return level;
	}
	
	
}
