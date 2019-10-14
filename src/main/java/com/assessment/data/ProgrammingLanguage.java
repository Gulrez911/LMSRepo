package com.assessment.data;

public enum ProgrammingLanguage {
	
JAVA("JAVA"), C("C"), CPLUSPLUS("CPLUSPLUS"),  DotNet("DotNet"), CHASH("CHASH"), PYTHON("PYTHON"), PHP("PHP"), JAVASCRIPT("JAVASCRIPT"),
CLOJURE("CLOJURE"), GO("GO"), BASH("BASH"), OBJECTIVE_C("OBJECTIVE_C"), MYSQL("MYSQL"), PERL("PERL"), RUST("RUST");
	
	String language;
	private ProgrammingLanguage(String language) {
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}
	
	

}
