package com.assessment.web.dto;

import java.util.ArrayList;
import java.util.List;

public class TestSessionDTO {
Boolean testComplete;
	
	Integer noOfQuestionsAnswered;
	
	Integer totalQuestions;
	
	List<QualifierSkillLevelDto> skills = new ArrayList<QualifierSkillLevelDto>();

	public Boolean getTestComplete() {
		return testComplete;
	}

	public void setTestComplete(Boolean testComplete) {
		this.testComplete = testComplete;
	}

	public Integer getNoOfQuestionsAnswered() {
		return noOfQuestionsAnswered;
	}

	public void setNoOfQuestionsAnswered(Integer noOfQuestionsAnswered) {
		this.noOfQuestionsAnswered = noOfQuestionsAnswered;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public List<QualifierSkillLevelDto> getSkills() {
		return skills;
	}

	public void setSkills(List<QualifierSkillLevelDto> skills) {
		this.skills = skills;
	}
	
}
