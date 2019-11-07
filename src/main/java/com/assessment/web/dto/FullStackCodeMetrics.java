package com.assessment.web.dto;

import java.text.DecimalFormat;

public class FullStackCodeMetrics {
	
	
	String problemDesc;
	
	Integer noOfTestCases;
	
	Integer noOfTestCasesPassed;
	
	String percent;

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
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

	public String getPercent() {
		try {
			float per = (100 * (noOfTestCasesPassed))/noOfTestCases;
			 DecimalFormat df = new DecimalFormat();
			 df.setMaximumFractionDigits(2);
			 String percentage = df.format(per);
			return percentage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0.0";
		}
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}
	
	
	
	

}
