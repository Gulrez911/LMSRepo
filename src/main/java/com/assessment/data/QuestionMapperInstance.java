package com.assessment.data;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.bouncycastle.util.encoders.Base64Encoder;

/**
 * Primary key - questionMapper & companyId
 * 
 * @author jsutaria
 *
 */
@Entity
public class QuestionMapperInstance extends Base {
	@ManyToOne
	QuestionMapper questionMapper;

	String userChoices;

	Boolean correct = false;

	Boolean answered = false;

	@Column(length = 2000)
	String questionText;

	@Transient
	String encodedQuestionText;

	@javax.validation.constraints.NotNull
	String testName;

	@javax.validation.constraints.NotNull
	String sectionName;

	@javax.validation.constraints.NotNull
	String user;

	String codingOuputBySystemTestCase;

	@Lob
	String codeByUser;

	@Lob
	String reviewerComments;

	@Column(length = 400)
	String workspaceUrl;

	@Transient
	String encodedUrl;

	@Column(length = 200)
	String workSpaceId;

	@Column(length = 400)
	String usageDocumentUrl;

	@Column
	Boolean workspaceSubmitted;

	@Transient
	String uerFullName;
	// Long userTestSessionId;

	@Transient
	String workspaceDateOfSubmission;

	Boolean confidence;

	Boolean codeCompilationErrors;

	Boolean codeRunTimeErrors;

	Boolean testCaseInputPositive;

	Boolean testCaseInputNegative;

	Boolean testCaseMinimalValue;

	Boolean testCaseMaximumValue;

	Boolean testCaseInvalidData;

	Integer noOfTestCases;

	Integer noOfTestCasesPassed;

	String courseName;

	String moduleName;

	String learningPathName;

	public QuestionMapper getQuestionMapper() {
		return questionMapper;
	}

	public void setQuestionMapper(QuestionMapper questionMapper) {
		this.questionMapper = questionMapper;
	}

	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}

	public Boolean getAnswered() {
		return answered;
	}

	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}

	public String getUserChoices() {
		return userChoices;
	}

	public void setUserChoices(String userChoices) {
		this.userChoices = userChoices;
		if (userChoices.length() > 0) {
			setAnswered(true);
			String choices = getQuestionMapper().getQuestion().getRightChoices();
			String correct[] = choices.split("-");
			String userC[] = userChoices.split("-");
			// String correct[] = choices.split("-");
			// String userC[] = userChoices.split("-");
			if (Arrays.equals(correct, userC)) {
				setCorrect(true);
			}
		} else {
			setAnswered(false);
		}

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getCodingOuputBySystemTestCase() {
		return codingOuputBySystemTestCase;
	}

	public void setCodingOuputBySystemTestCase(String codingOuputBySystemTestCase) {
		codingOuputBySystemTestCase = codingOuputBySystemTestCase == null ? ""
				: (codingOuputBySystemTestCase.trim());
		this.codingOuputBySystemTestCase = codingOuputBySystemTestCase;

		if (getCodeCompilationErrors()) {
			setCorrect(false);
		}

		System.out.println("in codingOuputBySystemTestCase " + codingOuputBySystemTestCase);
		System.out.println("in codingOuputBySystemTestCase2 "
				+ getQuestionMapper().getQuestion().getHiddenOutputNegative());

		if (getQuestionMapper().getQuestion().getHiddenOutputNegative().equalsIgnoreCase(
				codingOuputBySystemTestCase == null ? "" : codingOuputBySystemTestCase)) {
			setTestCaseInputNegative(true);
			System.out.println("in setCodingOuputBySystemTestCase " + true);
			setCorrect(true);
		} else {
			setTestCaseInputNegative(false);
			System.out.println("in setCodingOuputBySystemTestCase " + false);
			setCorrect(false);
		}
		setAnswered(true);
	}

	public String getCodeByUser() {
		return codeByUser;
	}

	public void setCodeByUser(String codeByUser) {
		this.codeByUser = codeByUser;
	}

	public String getReviewerComments() {
		return reviewerComments;
	}

	public void setReviewerComments(String reviewerComments) {
		this.reviewerComments = reviewerComments;
	}

	public String getWorkspaceUrl() {
		return workspaceUrl;
	}

	public void setWorkspaceUrl(String workspaceUrl) {
		this.workspaceUrl = workspaceUrl;
	}

	public String getWorkSpaceId() {
		return workSpaceId;
	}

	public void setWorkSpaceId(String workSpaceId) {
		this.workSpaceId = workSpaceId;
	}

	public String getUsageDocumentUrl() {
		return usageDocumentUrl;
	}

	public void setUsageDocumentUrl(String usageDocumentUrl) {
		this.usageDocumentUrl = usageDocumentUrl;
	}

	public Boolean getWorkspaceSubmitted() {
		return workspaceSubmitted;
	}

	public void setWorkspaceSubmitted(Boolean workspaceSubmitted) {
		this.workspaceSubmitted = workspaceSubmitted;
	}

	public String getUerFullName() {
		return uerFullName;
	}

	public void setUerFullName(String uerFullName) {
		this.uerFullName = uerFullName;
	}

	public String getWorkspaceDateOfSubmission() {
		String pattern = "dd-MMM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		if (getUpdateDate() == null) {
			if (getCreateDate() == null) {
				return "Not Available";
			} else {
				return simpleDateFormat.format(getCreateDate());
			}

		} else {
			return simpleDateFormat.format(getUpdateDate());
		}
	}

	public void setWorkspaceDateOfSubmission(String workspaceDateOfSubmission) {
		this.workspaceDateOfSubmission = workspaceDateOfSubmission;
	}

	public Boolean getConfidence() {
		return confidence;
	}

	public void setConfidence(Boolean confidence) {
		this.confidence = confidence;
	}

	public Boolean getTestCaseInputPositive() {
		if (this.testCaseInputPositive == null) {
			return false;
		}
		return testCaseInputPositive;
	}

	public void setTestCaseInputPositive(Boolean testCaseInputPositive) {
		this.testCaseInputPositive = testCaseInputPositive;
	}

	public Boolean getTestCaseInputNegative() {
		if (this.testCaseInputNegative == null) {
			return false;
		}
		return testCaseInputNegative;
	}

	public void setTestCaseInputNegative(Boolean testCaseInputNegative) {
		this.testCaseInputNegative = testCaseInputNegative;
	}

	public Boolean getTestCaseMinimalValue() {
		if (this.testCaseMinimalValue == null) {
			return false;
		}
		return testCaseMinimalValue;
	}

	public void setTestCaseMinimalValue(Boolean testCaseMinimalValue) {
		this.testCaseMinimalValue = testCaseMinimalValue;
	}

	public Boolean getTestCaseMaximumValue() {
		if (this.testCaseMaximumValue == null) {
			return false;
		}
		return testCaseMaximumValue;
	}

	public void setTestCaseMaximumValue(Boolean testCaseMaximumValue) {
		this.testCaseMaximumValue = testCaseMaximumValue;
	}

	public Boolean getTestCaseInvalidData() {
		if (this.testCaseInvalidData == null) {
			return false;
		}
		return testCaseInvalidData;
	}

	public void setTestCaseInvalidData(Boolean testCaseInvalidData) {
		this.testCaseInvalidData = testCaseInvalidData;
	}

	public Boolean getCodeCompilationErrors() {
		if (this.codeCompilationErrors == null) {
			return false;
		}
		return codeCompilationErrors;
	}

	public void setCodeCompilationErrors(Boolean codeCompilationErrors) {
		this.codeCompilationErrors = codeCompilationErrors;
	}

	public Boolean getCodeRunTimeErrors() {
		if (this.codeRunTimeErrors == null) {
			return false;
		}
		return codeRunTimeErrors;
	}

	public void setCodeRunTimeErrors(Boolean codeRunTimeErrors) {
		this.codeRunTimeErrors = codeRunTimeErrors;
	}

	public String getEncodedUrl() {
		return URLEncoder.encode(Base64.getEncoder().encodeToString(getWorkspaceUrl().getBytes()));
	}

	public void setEncodedUrl(String encodedUrl) {
		this.encodedUrl = encodedUrl;
	}

	public String getEncodedQuestionText() {
		return new org.apache.commons.codec.binary.Base64().encodeAsString(getQuestionText().getBytes());
	}

	public void setEncodedQuestionText(String encodedQuestionText) {
		this.encodedQuestionText = encodedQuestionText;
	}

	public Integer getNoOfTestCases() {
		return noOfTestCases;
	}

	public void setNoOfTestCases(Integer noOfTestCases) {
		this.noOfTestCases = noOfTestCases;
	}

	public Integer getNoOfTestCasesPassed() {
		return noOfTestCasesPassed;
	}

	public void setNoOfTestCasesPassed(Integer noOfTestCasesPassed) {
		this.noOfTestCasesPassed = noOfTestCasesPassed;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getLearningPathName() {
		return learningPathName;
	}

	public void setLearningPathName(String learningPathName) {
		this.learningPathName = learningPathName;
	}
}
