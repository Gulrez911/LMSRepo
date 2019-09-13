package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import com.assessment.data.User;
import com.assessment.data.UserType;
import com.assessment.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestUser {
	
	@Autowired
	private UserService userService;
	
	@Test
	@Transactional
	@Rollback(value=false)
	public void testaddUser()
	{
		User user=new User();
		user.setEmail("cgi@iiht.com");
		user.setMobileNumber("989878");
		user.setFirstName("Tikam");
		user.setLastName("Singh");
		user.setPassword("12345");
		user.setCompanyId("CGI");
		user.setCompanyName("CGI");
		user.setDepartment("IT");
		user.setUserType(UserType.ADMIN);
		userService.addUser(user);
	}
	
	@Test
	@Transactional
	@Rollback(value=false)
	public void testaddUserAdmin()
	{
		User user=new User();
		user.setEmail("system@iiht.com");
		user.setMobileNumber("989878");
		user.setFirstName("System");
		user.setLastName("Admin");
		user.setPassword("1234");
		user.setCompanyId("IH");
		user.setCompanyName("IIHT");
		user.setDepartment("IT");
		user.setUserType(UserType.ADMIN);
		userService.addUser(user);
	}
	
	@Test
	@Transactional
	@Rollback(value=false)
	public void testaddUserLmsAdmin()
	{
		User user=new User();
		user.setEmail("lmsadmin@iiht.com");
		user.setMobileNumber("989878");
		user.setFirstName("Lms");
		user.setLastName("Admin");
		user.setPassword("12345");
		user.setCompanyId("IH");
		user.setCompanyName("IIHT");
		user.setDepartment("IT");
		user.setUserType(UserType.LMS_ADMIN);
		userService.addUser(user);
	}
	
	@Test
	@Transactional
	@Rollback(value=false)
	public void testupdateUser()
	{
		User user=new User();
		user.setEmail("sreeram.gopal@iiht.com");
		user.setMobileNumber("989878");
		user.setFirstName("Tikam");
		user.setLastName("Singh");
		user.setPassword("12345");
		user.setCompanyId("IH");
		user.setCompanyName("IIHT");
		user.setDepartment("IT");
		user.setUserType(UserType.SUPER_ADMIN);
		userService.addUser(user);
	}
	

}
