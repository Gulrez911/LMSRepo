package com.assessment.web.dto;

public class SPACodeMetrics {
	
	Integer syntaxAwarenessPercent;
	
	Integer codeIntegrityPercent;
	
	Integer codeValidationsPercent;
	
	Integer lowInputPercent;
	
	Integer highInputPercent;
	
	Integer productionGradePercent;

	public Integer getSyntaxAwarenessPercent() {
		return syntaxAwarenessPercent;
	}

	public void setSyntaxAwarenessPercent(Integer syntaxAwarenessPercent) {
		this.syntaxAwarenessPercent = syntaxAwarenessPercent;
	}

	public Integer getCodeIntegrityPercent() {
		return codeIntegrityPercent;
	}

	public void setCodeIntegrityPercent(Integer codeIntegrityPercent) {
		this.codeIntegrityPercent = codeIntegrityPercent;
	}

	public Integer getCodeValidationsPercent() {
		return codeValidationsPercent;
	}

	public void setCodeValidationsPercent(Integer codeValidationsPercent) {
		this.codeValidationsPercent = codeValidationsPercent;
	}

	public Integer getLowInputPercent() {
		return lowInputPercent;
	}

	public void setLowInputPercent(Integer lowInputPercent) {
		this.lowInputPercent = lowInputPercent;
	}

	public Integer getHighInputPercent() {
		return highInputPercent;
	}

	public void setHighInputPercent(Integer highInputPercent) {
		this.highInputPercent = highInputPercent;
	}

	public Integer getProductionGradePercent() {
		return productionGradePercent;
	}

	public void setProductionGradePercent(Integer productionGradePercent) {
		this.productionGradePercent = productionGradePercent;
	}
	
	

}
