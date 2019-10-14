package com.assessment.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.Company;
import com.assessment.data.User;
import com.assessment.data.UserOtp;
import com.assessment.repositories.UserOtpRepository;
import com.assessment.services.CompanyService;
import com.assessment.services.UserOtpService;
import com.assessment.services.UserService;
@Service
@Transactional
public class UserOtpServiceImpl implements UserOtpService{
	@Autowired
	UserService userService;

	@Autowired
	UserOtpRepository userOtpRep;
	
	@Autowired
	CompanyService comnpanyService;
	
	@Override
	public UserOtp getOtpForUser(String user, String companyId) {
		// TODO Auto-generated method stub
		User user2 = userService.findByPrimaryKey(user, companyId);
			if(user2 == null){
				return null;
			}
			Random rand = new Random();
			String otp = String.format("%04d", rand.nextInt(10000));
			List<UserOtp> otps = userOtpRep.findByPrimaryKey(user, companyId);
			UserOtp userOtp = null;
				
			
			if(otps.size() == 0){
					
					userOtp = new UserOtp();
					userOtp.setCompanyId(companyId);
					userOtp.setUser(user);
					userOtp.setOtp(otp);
					userOtp.setCreateDate(new Date());
					userOtp.setUpdateDate(new Date());
					userOtp.setEnabled(true);
					userOtp.setFirstName(user2.getFirstName());
					userOtp.setLastName(user2.getLastName());
					userOtp.setCompanyName(user2.getCompanyName());
				}
				else{
					userOtp = otps.get(0);
					userOtp.setCompanyId(companyId);
					userOtp.setUser(user);
					userOtp.setOtp(otp);
					userOtp.setUpdateDate(new Date());
					userOtp.setEnabled(true);
					userOtp.setFirstName(user2.getFirstName());
					userOtp.setLastName(user2.getLastName());
					userOtp.setCompanyName(user2.getCompanyName());
				}
				userOtpRep.save(userOtp);
		return userOtp;
	}

	@Override
	public UserOtp findExistingUserOtp(String user, String companyId) {
		List<UserOtp> otps = userOtpRep.findByPrimaryKey(user, companyId);
		if(otps.size() == 0){
			return null;
		}
		return otps.get(0);
	}
	
	public UserOtp getOtpForTestByUser(String user, String test, String companyId){
		Random rand = new Random();
		String otp = String.format("%04d", rand.nextInt(10000));
		Company company = comnpanyService.findByCompanyId(companyId);
			if(company == null){
				return null;
			}
		
		UserOtp userOtp = userOtpRep.findByPrimaryKeyTest(user, companyId, test);
			if(userOtp == null){
				userOtp = new UserOtp();
				userOtp.setCreateDate(new Date());
				userOtp.setUpdateDate(new Date());
			}
			
			
		userOtp.setCompanyId(company.getCompanyId());
		userOtp.setCompanyName(company.getCompanyName());
		userOtp.setUpdateDate(new Date());
		userOtp.setUser(user);
		userOtp.setTestName(test);
		userOtp.setOtp(otp);
		userOtp.setEnabled(true);
		userOtpRep.save(userOtp);
		
		return userOtp;
	}
	
	public UserOtp findExistingUserOtpforTest(String user, String companyId, String test){
		UserOtp userOtp = userOtpRep.findByPrimaryKeyTest(user, companyId, test);
		return userOtp;
	}

	@Override
	public void deleteUserOtp(String user, String companyId, String test) {
		// TODO Auto-generated method stub
		UserOtp userOtp = userOtpRep.findByPrimaryKeyTest(user, companyId, test);
			if(userOtp != null){
				userOtpRep.delete(userOtp);
			}
	}

}
