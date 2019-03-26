package com.assessment.data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CodeMetrics extends Base{
	
	Long testId;
	
	Long questionId;
	
	Long questionMapperInstanceId;
	
	String email;
	
	String fullName;
	
	String testName;
	
	String sectionName;
	
	Question  question;
	
	@Enumerated(EnumType.STRING)
	QualityIndice functionalCompliance = QualityIndice.AVERAGE;
	
	@Enumerated(EnumType.STRING)
	QualityIndice designForPerforanceQuality = QualityIndice.AVERAGE;
	
	@Enumerated(EnumType.STRING)
	QualityIndice designForScalabilityQuality = QualityIndice.AVERAGE;
	
	@Enumerated(EnumType.STRING)
	QualityIndice designForSecurityQuality = QualityIndice.AVERAGE;
	
	@Enumerated(EnumType.STRING)
	QualityIndice designForFlexibilityQuality = QualityIndice.AVERAGE;
	
	@Enumerated(EnumType.STRING)
	QualityIndice designForAdaptibilityQuality = QualityIndice.AVERAGE;
	
	@Enumerated(EnumType.STRING)
	QualityIndice testCasesQuality = QualityIndice.AVERAGE;
	
	String functionalComplianceComments;
	
	String performanceComments;
	
	String scalabilityComments;
	
	String securityComments;
	
	String flexibilityComments;
	
	String adaptibilityComments;
	
	String testCasesComments;
	
	String overAll;
	
	@Enumerated(EnumType.STRING)
	Status status = Status.NOT_STARTED;

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestionMapperInstanceId() {
		return questionMapperInstanceId;
	}

	public void setQuestionMapperInstanceId(Long questionMapperInstanceId) {
		this.questionMapperInstanceId = questionMapperInstanceId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QualityIndice getFunctionalCompliance() {
		return functionalCompliance;
	}

	public void setFunctionalCompliance(QualityIndice functionalCompliance) {
		this.functionalCompliance = functionalCompliance;
	}

	public QualityIndice getDesignForPerforanceQuality() {
		return designForPerforanceQuality;
	}

	public void setDesignForPerforanceQuality(QualityIndice designForPerforanceQuality) {
		this.designForPerforanceQuality = designForPerforanceQuality;
	}

	public QualityIndice getDesignForScalabilityQuality() {
		return designForScalabilityQuality;
	}

	public void setDesignForScalabilityQuality(QualityIndice designForScalabilityQuality) {
		this.designForScalabilityQuality = designForScalabilityQuality;
	}

	public QualityIndice getDesignForSecurityQuality() {
		return designForSecurityQuality;
	}

	public void setDesignForSecurityQuality(QualityIndice designForSecurityQuality) {
		this.designForSecurityQuality = designForSecurityQuality;
	}

	public QualityIndice getDesignForFlexibilityQuality() {
		return designForFlexibilityQuality;
	}

	public void setDesignForFlexibilityQuality(QualityIndice designForFlexibilityQuality) {
		this.designForFlexibilityQuality = designForFlexibilityQuality;
	}

	public QualityIndice getDesignForAdaptibilityQuality() {
		return designForAdaptibilityQuality;
	}

	public void setDesignForAdaptibilityQuality(QualityIndice designForAdaptibilityQuality) {
		this.designForAdaptibilityQuality = designForAdaptibilityQuality;
	}

	public QualityIndice getTestCasesQuality() {
		return testCasesQuality;
	}

	public void setTestCasesQuality(QualityIndice testCasesQuality) {
		this.testCasesQuality = testCasesQuality;
	}

	public String getFunctionalComplianceComments() {
		return functionalComplianceComments;
	}

	public void setFunctionalComplianceComments(String functionalComplianceComments) {
		this.functionalComplianceComments = functionalComplianceComments;
	}

	public String getPerformanceComments() {
		return performanceComments;
	}

	public void setPerformanceComments(String performanceComments) {
		this.performanceComments = performanceComments;
	}

	public String getScalabilityComments() {
		return scalabilityComments;
	}

	public void setScalabilityComments(String scalabilityComments) {
		this.scalabilityComments = scalabilityComments;
	}

	public String getSecurityComments() {
		return securityComments;
	}

	public void setSecurityComments(String securityComments) {
		this.securityComments = securityComments;
	}

	public String getFlexibilityComments() {
		return flexibilityComments;
	}

	public void setFlexibilityComments(String flexibilityComments) {
		this.flexibilityComments = flexibilityComments;
	}

	public String getAdaptibilityComments() {
		return adaptibilityComments;
	}

	public void setAdaptibilityComments(String adaptibilityComments) {
		this.adaptibilityComments = adaptibilityComments;
	}

	public String getTestCasesComments() {
		return testCasesComments;
	}

	public void setTestCasesComments(String testCasesComments) {
		this.testCasesComments = testCasesComments;
	}

	public String getOverAll() {
		return overAll;
	}

	public void setOverAll(String overAll) {
		this.overAll = overAll;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	

}
