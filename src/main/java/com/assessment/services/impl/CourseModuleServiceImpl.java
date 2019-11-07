package com.assessment.services.impl;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.CourseModule;
import com.assessment.repositories.CourseModuleRepository;
import com.assessment.services.CourseModuleService;
@Service
@Transactional
public class CourseModuleServiceImpl implements CourseModuleService {
	@Autowired
	CourseModuleRepository courseModuleRep;

	@Override
	public CourseModule findByPrimaryKey(String moduleName, String courseName, String companyId) {
		// TODO Auto-generated method stub
		return courseModuleRep.findByPrimaryKey(moduleName, courseName, companyId);
	}

	@Override
	public List<CourseModule> findModulesByCourseName(String courseName, String companyId) {
		// TODO Auto-generated method stub
		return courseModuleRep.findModulesByCourseName(courseName, companyId);
	}

	@Override
	public CourseModule saveOrUpdate(CourseModule courseModule) {
		// TODO Auto-generated method stub
		CourseModule courseModule2 = findByPrimaryKey(courseModule.getModuleName(), courseModule.getCourseName(), courseModule.getCompanyId());
			if(courseModule2 == null){
				courseModule.setCreateDate(new Date());
				courseModuleRep.save(courseModule);
				return courseModule;
			}
			else{
				courseModule.setId(courseModule2.getId());
				org.dozer.Mapper mapper = new DozerBeanMapper();
				mapper.map(courseModule, courseModule2);
				courseModule2.setUpdateDate(new Date());
				courseModuleRep.save(courseModule2);
				return courseModule2;
			}
	}

}
