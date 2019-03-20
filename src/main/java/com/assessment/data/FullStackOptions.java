package com.assessment.data;

public enum FullStackOptions {
	

NONE("NONE"), JAVA_FULLSTACK("JAVA_FULLSTACK"), DOTNET_FULLSTACK("DOTNET_FULLSTACK"), JAVASCRIPT_FULLSTACK("JAVASCRIPT_FULLSTACK");
	
	String stack;
	private FullStackOptions(String stack) {
		this.stack = stack;
	}
	public String getStack() {
		return stack;
	}
	
	

}

