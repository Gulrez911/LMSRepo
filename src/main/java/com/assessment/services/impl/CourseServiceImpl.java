package com.assessment.services.impl;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.Course;
import com.assessment.repositories.CourseRepository;
import com.assessment.services.CourseService;
@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRep;

	@Override
	public Course findByPrimaryKey(String courseName, String companyId) {
		// TODO Auto-generated method stub
		return courseRep.findByPrimaryKey(courseName, companyId);
	}

	@Override
	public List<Course> searchCourses(String searchLabel, String companyId) {
		// TODO Auto-generated method stub
		return courseRep.searchCourses(searchLabel, companyId);
	}

	@Override
	public List<Course> getPopularCourses(String companyId) {
		// TODO Auto-generated method stub
		return courseRep.getPopularCourses(companyId);
	}

	@Override
	public Course saveOrUpdate(Course course) {
		// TODO Auto-generated method stub
		Course course2 = findByPrimaryKey(course.getCourseName(), course.getCompanyId());
			if(course2 == null){
				course.setCreateDate(new Date());
				courseRep.save(course);
			}
			else{
				course.setId(course2.getId());
				org.dozer.Mapper mapper = new DozerBeanMapper();
				mapper.map(course, course2);
				course2.setUpdateDate(new Date());
				courseRep.save(course2);
				course = course2;
			}
		return course;
	}

}
