package com.assessment.services.impl;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.Course;
import com.assessment.data.Enrollment;
import com.assessment.data.LearningObjectType;
import com.assessment.data.LearningPath;
import com.assessment.repositories.CourseRepository;
import com.assessment.repositories.EnrollmentRepository;
import com.assessment.repositories.LearningPathRepository;
import com.assessment.services.CourseService;
import com.assessment.services.EnrollmentService;
import com.assessment.services.LearningPathService;
@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {
	@Autowired
	EnrollmentRepository enrollmentRep;
	
	@Autowired
	LearningPathService learningPathservice;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	LearningPathRepository pathRep;
	
	@Autowired
	CourseRepository courseRep;

	@Override
	public Enrollment findByPrimaryKey(String email, String learningObjectName, Long learningObjectId,
			String companyId) {
		// TODO Auto-generated method stub
		return enrollmentRep.findByPrimaryKey(email, learningObjectName, learningObjectId, companyId);
	}

	@Override
	public List<Enrollment> getEnrollemntsForUser(String email, String companyId) {
		// TODO Auto-generated method stub
		return enrollmentRep.getEnrollemntsForUser(email, companyId);
	}

	@Override
	public List<Enrollment> getEnrollemntsForUserByType(String email, LearningObjectType learningObjectType, String companyId) {
		// TODO Auto-generated method stub
		return enrollmentRep.getEnrollemntsForUserByType(email, learningObjectType, companyId);
	}

	@Override
	public Integer getCountOfEnrollemntsForUserByType(String email, LearningObjectType learningObjectType, String companyId) {
		// TODO Auto-generated method stub
		return enrollmentRep.getCountOfEnrollemntsForUserByType(email, learningObjectType, companyId);
	}

	@Override
	public Integer getCountOfEnrollemntsForUserByTypeAndStatus(String email, LearningObjectType learningObjectType,
			Boolean completionStatus, String companyId) {
		// TODO Auto-generated method stub
		return enrollmentRep.getCountOfEnrollemntsForUserByTypeAndStatus(email, learningObjectType, completionStatus, companyId);
	}

	@Override
	public Enrollment saveOrUpdate(Enrollment enrollment) {
		// TODO Auto-generated method stub
		Enrollment enrollment2 = enrollmentRep.findByPrimaryKey(enrollment.getEmail(), enrollment.getLearningObjectName(), enrollment.getLearningObjectId(), enrollment.getCompanyId());
			if(enrollment2 == null){
				enrollment.setCreateDate(new Date());
				incrementNoEnrollemnts(enrollment);
				enrollmentRep.save(enrollment);
				return enrollment;
			}
			else{
				enrollment.setId(enrollment2.getId());
				org.dozer.Mapper mapper = new DozerBeanMapper();
				mapper.map(enrollment, enrollment2);
				enrollment2.setUpdateDate(new Date());
				incrementNoEnrollemnts(enrollment2);
				enrollmentRep.save(enrollment2);
				return enrollment2;
			}
			
	}
	
	private void incrementNoEnrollemnts(Enrollment enrollment){
		if(enrollment.getLearningObjectType().getType().equals(LearningObjectType.LEARNING_PATH.getType())){
			LearningPath learningPath = pathRep.findById(enrollment.getLearningObjectId()).get();
			/**
			 * Done within service
			 */
			//learningPath.setNoOfEnrollments(learningPath.getNoOfEnrollments() == null ? 1: learningPath.getNoOfEnrollments()+1);
			learningPathservice.incrementNoOfEnrollemnts(learningPath.getId());
		}
		else if(enrollment.getLearningObjectType().getType().equals(LearningObjectType.COURSE.getType())){
			Course course = courseRep.findById(enrollment.getLearningObjectId()).get();
			course.setNoOfEnrollemnts(course.getNoOfEnrollemnts() == null ? 1 : course.getNoOfEnrollemnts()+1);
			courseService.saveOrUpdate(course);
		}
	}

	@Override
	public Float getWeightedScore(String email, String companyId) {
		// TODO Auto-generated method stub
		return 0.0f;
	}

}
