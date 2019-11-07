package com.assessment.web.dto;

public class TestCasesMetric {
	
	String problemStatement;
	
	Integer noOfTestCases;
	
	Integer testCasesPassed;
	
	String codeQualityLink;
	
	String projDocLink;
	
	Boolean available = false;

	public String getProblemStatement() {
		return problemStatement;
	}

	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}

	public Integer getNoOfTestCases() {
		return noOfTestCases;
	}

	public void setNoOfTestCases(Integer noOfTestCases) {
		this.noOfTestCases = noOfTestCases;
	}

	public Integer getTestCasesPassed() {
		return testCasesPassed;
	}

	public void setTestCasesPassed(Integer testCasesPassed) {
		this.testCasesPassed = testCasesPassed;
	}

	public String getCodeQualityLink() {
		return codeQualityLink;
	}

	public void setCodeQualityLink(String codeQualityLink) {
		this.codeQualityLink = codeQualityLink;
	}

	public String getProjDocLink() {
		return projDocLink;
	}

	public void setProjDocLink(String projDocLink) {
		this.projDocLink = projDocLink;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	

}
