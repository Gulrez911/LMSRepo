package com.test.excel;

public class CourseDto {

	String learningPath;
	String courseName;
	String imageUrl;
	String module;
	String link;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public CourseDto() {
		super();
	}
	public String getLearningPath() {
		return learningPath;
	}
	public void setLearningPath(String learningPath) {
		this.learningPath = learningPath;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
