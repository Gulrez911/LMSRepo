package com.assessment.web.dto;

public class TestCasesMetric {
	
	String problemStatement;
	
	Integer noOfTestCases;
	
	Integer testCasesPassed;
	
	String codeQualityLink;
	
	String projDocLink;
	
	Boolean available = false;
	
	Integer functionalTestCases;
	Integer boundaryTestCases;
	Integer exceptionTestCases;
	
	Integer functionalTestCasesPassed;
	Integer boundaryTestCasesPassed;
	Integer exceptionTestCasesPassed;

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

	public Integer getFunctionalTestCases() {
		return functionalTestCases;
	}

	public void setFunctionalTestCases(Integer functionalTestCases) {
		this.functionalTestCases = functionalTestCases;
	}

	public Integer getBoundaryTestCases() {
		return boundaryTestCases;
	}

	public void setBoundaryTestCases(Integer boundaryTestCases) {
		this.boundaryTestCases = boundaryTestCases;
	}

	public Integer getExceptionTestCases() {
		return exceptionTestCases;
	}

	public void setExceptionTestCases(Integer exceptionTestCases) {
		this.exceptionTestCases = exceptionTestCases;
	}

	public Integer getFunctionalTestCasesPassed() {
		return functionalTestCasesPassed;
	}

	public void setFunctionalTestCasesPassed(Integer functionalTestCasesPassed) {
		this.functionalTestCasesPassed = functionalTestCasesPassed;
	}

	public Integer getBoundaryTestCasesPassed() {
		return boundaryTestCasesPassed;
	}

	public void setBoundaryTestCasesPassed(Integer boundaryTestCasesPassed) {
		this.boundaryTestCasesPassed = boundaryTestCasesPassed;
	}

	public Integer getExceptionTestCasesPassed() {
		return exceptionTestCasesPassed;
	}

	public void setExceptionTestCasesPassed(Integer exceptionTestCasesPassed) {
		this.exceptionTestCasesPassed = exceptionTestCasesPassed;
	}
	
	

}
