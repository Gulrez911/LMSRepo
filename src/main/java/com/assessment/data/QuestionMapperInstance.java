package com.assessment.data;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
/**
 * Primary key - questionMapper & companyId
 * @author jsutaria
 *
 */
@Entity
public class QuestionMapperInstance extends Base{
	@ManyToOne
	QuestionMapper questionMapper;
	
	
	String userChoices;
	
	Boolean correct = false;
	
	Boolean answered = false;
	
	String questionText;
	
	@javax.validation.constraints.NotNull
	String testName;
	
	@javax.validation.constraints.NotNull
	String sectionName;
	
	@javax.validation.constraints.NotNull
	String user;
	
	String codingOuputBySystemTestCase;
	
	@Lob
	String codeByUser;
	
	
	//Long userTestSessionId;

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
			if(userChoices.length() > 0) {
				setAnswered(true);
				String choices = getQuestionMapper().getQuestion().getRightChoices();
				String correct[] = choices.split("-");
				String userC[] = userChoices.split("-");
				if(Arrays.equals(correct, userC)) {
					setCorrect(true);
				}
			}
			else {
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
		this.codingOuputBySystemTestCase = codingOuputBySystemTestCase;
		if(getQuestionMapper().getQuestion().getHiddenOutputNegative().equalsIgnoreCase(codingOuputBySystemTestCase)){
			setCorrect(true);
		}
		else{
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
	
	
	
	
}
