package com.assessment.services;

import java.util.List;

import com.assessment.data.Enrollment;
import com.assessment.data.LearningObjectType;

public interface EnrollmentService {
	
	Enrollment findByPrimaryKey( String email,  String learningObjectName,  Long learningObjectId,  String companyId);
	
	List<Enrollment> getEnrollemntsForUser( String email,  String companyId);
	
	
	List<Enrollment> getEnrollemntsForUserByType( String email,  LearningObjectType learningObjectType,  String companyId);
	
	
	Integer getCountOfEnrollemntsForUserByType( String email,  LearningObjectType learningObjectType,  String companyId);
	
	Integer getCountOfEnrollemntsForUserByTypeAndStatus( String email,  LearningObjectType learningObjectType,  Boolean completionStatus,  String companyId);
	
	Enrollment saveOrUpdate(Enrollment enrollment);
	
	Float getWeightedScore(String email, String companyId);


}
