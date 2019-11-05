package com.assessment.services.impl;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.LearningPath;
import com.assessment.repositories.LearningPathRepository;
import com.assessment.services.LearningPathService;
@Service
@Transactional
public class LearningPathServiceImpl implements LearningPathService {
	@Autowired
	LearningPathRepository learningPathRep;

	@Override
	public LearningPath findByPrimaryKey(String name, String companyId) {
		// TODO Auto-generated method stub
		return learningPathRep.findByPrimaryKey(name, companyId);
	}

	@Override
	public List<LearningPath> searchLearningPaths(String searchLabel, String companyId) {
		// TODO Auto-generated method stub
		return learningPathRep.searchLearningPaths(searchLabel, companyId);
	}

	@Override
	public List<LearningPath> getPopularLearningPaths(String companyId) {
		// TODO Auto-generated method stub
		return learningPathRep.getPopularLearningPaths(companyId);
	}

	@Override
	public LearningPath saveOrUpdate(LearningPath learningPath) {
		// TODO Auto-generated method stub
		LearningPath learningPath2 = findByPrimaryKey(learningPath.getName(), learningPath.getCompanyId());
			if(learningPath2 == null){
				learningPath.setCreateDate(new Date());
				learningPathRep.save(learningPath);
				return learningPath;
			}
			else{
				learningPath.setId(learningPath2.getId());
				org.dozer.Mapper mapper = new DozerBeanMapper();
				learningPath.setCourses(learningPath2.getCourses());
				mapper.map(learningPath, learningPath2);
				learningPath2.setUpdateDate(new Date());
				learningPathRep.save(learningPath2);
				return learningPath2;
			}
	}

	@Override
	public void incrementNoOfEnrollemnts(Long id) {
		// TODO Auto-generated method stub
		LearningPath learningPath = learningPathRep.findById(id).get();
		learningPath.setNoOfEnrollments((learningPath.getNoOfEnrollments() == null ? 0 : learningPath.getNoOfEnrollments()+1));
		learningPathRep.save(learningPath);
	}

}
