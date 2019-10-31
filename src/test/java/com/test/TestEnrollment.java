package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.LearningObjectType;
import com.assessment.services.EnrollmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestEnrollment {
	@Autowired
	EnrollmentService enrollmentService;
	
	@Test
	public void testGetEnrollemntsByType(){
		System.out.println(enrollmentService.getCountOfEnrollemntsForUserByType("test@test.com", LearningObjectType.COURSE, "IH"));
	}

}
