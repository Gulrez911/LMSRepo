package com.assessment.web.dto;

import java.util.List;

import com.assessment.data.Course;
import com.assessment.data.Enrollment;
import com.assessment.data.LearningPath;

public class LMSLearnerDashboardDTO {
Integer noOfCoursesEnrolled;

Integer noOfCoursesCompleted;

Integer noOfLearningPathsEnrolled;

Integer noOfLearningPathsCompleted;

String weightedScorePercentage;


List<Enrollment> enrolledLearningPaths;

List<Enrollment> enrolledCourses;

List<LearningPath> popularLearningPaths;

List<Course> popularCourses;

UserDto userDto;

public Integer getNoOfCoursesEnrolled() {
	return noOfCoursesEnrolled;
}

public void setNoOfCoursesEnrolled(Integer noOfCoursesEnrolled) {
	this.noOfCoursesEnrolled = noOfCoursesEnrolled;
}

public Integer getNoOfCoursesCompleted() {
	return noOfCoursesCompleted;
}

public void setNoOfCoursesCompleted(Integer noOfCoursesCompleted) {
	this.noOfCoursesCompleted = noOfCoursesCompleted;
}

public Integer getNoOfLearningPathsEnrolled() {
	return noOfLearningPathsEnrolled;
}

public void setNoOfLearningPathsEnrolled(Integer noOfLearningPathsEnrolled) {
	this.noOfLearningPathsEnrolled = noOfLearningPathsEnrolled;
}

public Integer getNoOfLearningPathsCompleted() {
	return noOfLearningPathsCompleted;
}

public void setNoOfLearningPathsCompleted(Integer noOfLearningPathsCompleted) {
	this.noOfLearningPathsCompleted = noOfLearningPathsCompleted;
}

public String getWeightedScorePercentage() {
	return weightedScorePercentage;
}

public void setWeightedScorePercentage(String weightedScorePercentage) {
	this.weightedScorePercentage = weightedScorePercentage;
}



public List<Enrollment> getEnrolledLearningPaths() {
	return enrolledLearningPaths;
}

public void setEnrolledLearningPaths(List<Enrollment> enrolledLearningPaths) {
	this.enrolledLearningPaths = enrolledLearningPaths;
}

public List<Enrollment> getEnrolledCourses() {
	return enrolledCourses;
}

public void setEnrolledCourses(List<Enrollment> enrolledCourses) {
	this.enrolledCourses = enrolledCourses;
}

public List<LearningPath> getPopularLearningPaths() {
	return popularLearningPaths;
}

public void setPopularLearningPaths(List<LearningPath> popularLearningPaths) {
	this.popularLearningPaths = popularLearningPaths;
}

public List<Course> getPopularCourses() {
	return popularCourses;
}

public void setPopularCourses(List<Course> popularCourses) {
	this.popularCourses = popularCourses;
}

public UserDto getUserDto() {
	return userDto;
}

public void setUserDto(UserDto userDto) {
	this.userDto = userDto;
}

}
