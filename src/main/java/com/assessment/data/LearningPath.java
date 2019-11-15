package com.assessment.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class LearningPath extends Base {

	String name;

	String description;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Course> courses = new ArrayList<Course>();

	@Transient
	List<String> course = new ArrayList<String>();

	public List<String> getCourse() {
		return course;
	}

	public void setCourse(List<String> course) {
		this.course = course;
	}

	String imageUrl;

	/**
	 * Comma separated string
	 */
	@Column(length = 500)
	String searchLabel;

	/**
	 * Comma separated string
	 */
	@Column(length = 500)
	String technology;

	Integer noOfEnrollments = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public Integer getNoOfEnrollments() {
		return noOfEnrollments;
	}

	public void setNoOfEnrollments(Integer noOfEnrollments) {
		this.noOfEnrollments = noOfEnrollments;
	}

	@Override
	public String toString() {
		return "LearningPath [name=" + name + ", description=" + description + ", courses=" + courses
				+ ", imageUrl=" + imageUrl + ", searchLabel=" + searchLabel + ", technology="
				+ technology + ", noOfEnrollments=" + noOfEnrollments + "]";
	}

}
