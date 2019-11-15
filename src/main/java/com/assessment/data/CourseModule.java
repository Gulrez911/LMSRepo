package com.assessment.data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CourseModule extends Base {
	
	String moduleName;
	
	Integer duration;
	
	@Column(length=1000)
	String contentLink;
	
	String testPublicLink;
	
	String courseName;
	
	Long courseId;
	
	/**
	 * Associated with this module
	 */
	String testName;
	
	/**
	 * Associated with this module
	 */
	Long testId;
	
	String moduleDesc;

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getContentLink() {
		return contentLink;
	}

	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}

	public String getTestPublicLink() {
		return testPublicLink;
	}

	public void setTestPublicLink(String testPublicLink) {
		this.testPublicLink = testPublicLink;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}
	
	
	

}
