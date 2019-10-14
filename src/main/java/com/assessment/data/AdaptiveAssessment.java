package com.assessment.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class AdaptiveAssessment extends Base{
	
private String testName;
	Integer testTimeInMinutes;
	
	//Integer totalMarks;
	
	String coreSkills;
	
	Boolean basedOnDifficultyLevel;
	
	String startingLevel;
	
	String intro;
	
	String postTestCompletionText;
	
	Boolean showFinalScoreToParticipants;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	List<Skill> skills = new ArrayList<>();
	
	
	
	Boolean sentToStudent = false;
	
	@Transient
	String category;
	
	@Transient
	String uDate;
	
	@Transient
	String cDate;
	
	String sendToAdminEmail;
	
	@Transient
	Set<User> users = new HashSet<>();
	
	
	
	@Transient
	String publicUrl;
	
	String domainEmailSupported = "*";
	
	
	String testType = "Java";
	
	Boolean sendRecommReport = false;
	
	Integer noOfConfigurableAttempts = 1;
	
	Boolean considerConfidence;
	
	Boolean justification;

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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPostTestCompletionText() {
		return postTestCompletionText;
	}

	public void setPostTestCompletionText(String postTestCompletionText) {
		this.postTestCompletionText = postTestCompletionText;
	}

	public Boolean getShowFinalScoreToParticipants() {
		return showFinalScoreToParticipants;
	}

	public void setShowFinalScoreToParticipants(Boolean showFinalScoreToParticipants) {
		this.showFinalScoreToParticipants = showFinalScoreToParticipants;
	}

	

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	

	public Boolean getSentToStudent() {
		return sentToStudent;
	}

	public void setSentToStudent(Boolean sentToStudent) {
		this.sentToStudent = sentToStudent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getuDate() {
		return uDate;
	}

	public void setuDate(String uDate) {
		this.uDate = uDate;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getSendToAdminEmail() {
		return sendToAdminEmail;
	}

	public void setSendToAdminEmail(String sendToAdminEmail) {
		this.sendToAdminEmail = sendToAdminEmail;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public String getDomainEmailSupported() {
		return domainEmailSupported;
	}

	public void setDomainEmailSupported(String domainEmailSupported) {
		this.domainEmailSupported = domainEmailSupported;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public Boolean getSendRecommReport() {
		return sendRecommReport;
	}

	public void setSendRecommReport(Boolean sendRecommReport) {
		this.sendRecommReport = sendRecommReport;
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

	public Boolean getJustification() {
		return justification;
	}

	public void setJustification(Boolean justification) {
		this.justification = justification;
	}
	
	
	

}
