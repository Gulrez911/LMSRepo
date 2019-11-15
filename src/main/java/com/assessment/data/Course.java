package com.assessment.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Course extends Base{
	
	@Enumerated(EnumType.STRING)
	private CourseType courseType = CourseType.ONLINE;
	
	String courseName;
	
	Boolean activeStatus = true;
	
	@Column(length=1000)
	String imageUrl;
	
	Integer duration;
	
	@Column(length=5000)
	String courseDesc;
	
	/**
	 * Comma separated string
	 */
	@Column(length=500)
	String searchLabel;
	
	
	/**
	 * Comma separated string
	 */
	@Column(length=500)
	String technology;
	
	Integer noOfEnrollemnts = 0;


	public CourseType getCourseType() {
		return courseType;
	}


	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Boolean getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public String getCourseDesc() {
		return courseDesc;
	}


	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}


	public String getSearchLabel() {
		return searchLabel;
	}


	public void setSearchLabel(String searchLabel) {
		this.searchLabel = searchLabel;
	}


	public String getTechnology() {
		return technology;
	}


	public void setTechnology(String technology) {
		this.technology = technology;
	}


	public Integer getNoOfEnrollemnts() {
		return noOfEnrollemnts;
	}


	public void setNoOfEnrollemnts(Integer noOfEnrollemnts) {
		this.noOfEnrollemnts = noOfEnrollemnts;
	}


	@Override
	public String toString() {
		return "Course [courseType=" + courseType + ", courseName=" + courseName + ", activeStatus="
				+ activeStatus + ", imageUrl=" + imageUrl + ", duration=" + duration + ", courseDesc="
				+ courseDesc + ", searchLabel=" + searchLabel + ", technology=" + technology
				+ ", noOfEnrollemnts=" + noOfEnrollemnts + "]";
	}
}
