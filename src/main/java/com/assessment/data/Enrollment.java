package com.assessment.data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Enrollment extends Base{
	
	@Enumerated(EnumType.STRING)
	LearningObjectType learningObjectType = LearningObjectType.LEARNING_PATH;

	Long learningObjectId;
	
	String learningObjectName;
	
	Boolean completionStatus;
	
	Float completionPercentage;
	
	java.util.Date startDate;
	
	java.util.Date completionDate;
	
	String email;
	
	String imageUrl;

	public LearningObjectType getLearningObjectType() {
		return learningObjectType;
	}

	public void setLearningObjectType(LearningObjectType learningObjectType) {
		this.learningObjectType = learningObjectType;
	}

	public Long getLearningObjectId() {
		return learningObjectId;
	}

	public void setLearningObjectId(Long learningObjectId) {
		this.learningObjectId = learningObjectId;
	}

	public Boolean getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(Boolean completionStatus) {
		this.completionStatus = completionStatus;
	}

	public Float getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(Float completionPercentage) {
		this.completionPercentage = completionPercentage;
	}

	public java.util.Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(java.util.Date completionDate) {
		this.completionDate = completionDate;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public String getLearningObjectName() {
		return learningObjectName;
	}

	public void setLearningObjectName(String learningObjectName) {
		this.learningObjectName = learningObjectName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
