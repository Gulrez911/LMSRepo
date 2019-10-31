package com.assessment.services;

import java.util.List;

import com.assessment.data.Course;

public interface CourseService {
	
	Course findByPrimaryKey( String courseName, String companyId);
	
	List<Course> searchCourses( String searchLabel, String companyId);
	
	
	List<Course> getPopularCourses(String companyId);
	
	Course saveOrUpdate(Course course);
	
	

}
