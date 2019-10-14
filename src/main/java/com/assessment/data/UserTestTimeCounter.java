package com.assessment.data;

import javax.persistence.Entity;

@Entity
public class UserTestTimeCounter extends Base{
	
	Long testId;
	
	String testName;
	
	
	
	String email;
	
	Long timeCounter;

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTimeCounter() {
		return timeCounter;
	}

	public void setTimeCounter(Long timeCounter) {
		this.timeCounter = timeCounter;
	}
	
	

}
