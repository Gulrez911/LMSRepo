package com.assessment.services;

import java.util.List;

import com.assessment.data.CourseModule;

public interface CourseModuleService {
	
	CourseModule findByPrimaryKey(String moduleName, String courseName,  String companyId);
	
	List<CourseModule> findModulesByCourseName( String courseName,  String companyId);
	
	CourseModule saveOrUpdate(CourseModule courseModule);
	
	

}
