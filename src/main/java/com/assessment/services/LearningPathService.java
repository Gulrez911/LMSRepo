package com.assessment.services;

import java.util.List;

import com.assessment.data.LearningPath;

public interface LearningPathService {
	
	LearningPath findByPrimaryKey( String name,  String companyId);

	
	List<LearningPath> searchLearningPaths( String searchLabel, String companyId);
	
	List<LearningPath> getPopularLearningPaths(String companyId);
	
	LearningPath saveOrUpdate(LearningPath learningPath);
	
	void incrementNoOfEnrollemnts(Long id);


}
