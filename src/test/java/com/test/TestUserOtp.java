package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.repositories.UserOtpRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestUserOtp {
	@Autowired
	UserOtpRepository otpRepository;
	
	@Test
	public void testUserOtp(){
		otpRepository.findByPrimaryKey("tets", "test");
	}

}
