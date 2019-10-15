package com.assessment.web.dto;

import com.assessment.data.Base;

public class QuestionMapperDto extends Base {

	String sectionName;

	String testName;

	Long questionId;
	
	String questionText;

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "QuestionMapperDto [sectionName=" + sectionName + ", testName=" + testName + ", questionId="
				+ questionId + "]";
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

}
