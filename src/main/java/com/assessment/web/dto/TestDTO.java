package com.assessment.web.dto;

import java.util.ArrayList;
import java.util.List;

public class TestDTO {
	private String testName;
	
	Integer testTimeInMinutes;
	
	Integer totalMarks;
	
	Float passPercent = 60f;
	
	Integer noOfConfigurableAttempts = 1;
	
	Boolean considerConfidence;
	
	Boolean fullStackTest;
	
	Boolean justification;
	
	List<String> recommendedAreas = new ArrayList<String>();

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getTestTimeInMinutes() {
		return testTimeInMinutes;
	}

	public void setTestTimeInMinutes(Integer testTimeInMinutes) {
		this.testTimeInMinutes = testTimeInMinutes;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Float getPassPercent() {
		return passPercent;
	}

	public void setPassPercent(Float passPercent) {
		this.passPercent = passPercent;
	}

	public Integer getNoOfConfigurableAttempts() {
		return noOfConfigurableAttempts;
	}

	public void setNoOfConfigurableAttempts(Integer noOfConfigurableAttempts) {
		this.noOfConfigurableAttempts = noOfConfigurableAttempts;
	}

	public Boolean getConsiderConfidence() {
		return considerConfidence;
	}

	public void setConsiderConfidence(Boolean considerConfidence) {
		this.considerConfidence = considerConfidence;
	}

	public Boolean getFullStackTest() {
		return fullStackTest;
	}

	public void setFullStackTest(Boolean fullStackTest) {
		this.fullStackTest = fullStackTest;
	}

	public Boolean getJustification() {
		return justification;
	}

	public void setJustification(Boolean justification) {
		this.justification = justification;
	}

	public List<String> getRecommendedAreas() {
		return recommendedAreas;
	}

	public void setRecommendedAreas(List<String> recommendedAreas) {
		this.recommendedAreas = recommendedAreas;
	}
	
	
	
}
