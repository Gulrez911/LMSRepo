package com.assessment.services.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.User;
import com.assessment.data.UserOtp;
import com.assessment.repositories.UserOtpRepository;
import com.assessment.services.UserOtpService;
import com.assessment.services.UserService;
@Service
@Transactional
public class UserOtpServiceImpl implements UserOtpService{
	@Autowired
	UserService userService;

	@Autowired
	UserOtpRepository userOtpRep;
	
	@Override
	public UserOtp getOtpForUser(String user, String companyId) {
		// TODO Auto-generated method stub
		User user2 = userService.findByPrimaryKey(user, companyId);
			if(user2 == null){
				return null;
			}
			Random rand = new Random();
			String otp = String.format("%04d", rand.nextInt(10000));
			UserOtp userOtp = userOtpRep.findByPrimaryKey(user, companyId);
				if(userOtp == null){
					userOtp = new UserOtp();
					userOtp.setCompanyId(companyId);
					userOtp.setUser(user);
					userOtp.setOtp(otp);
					userOtp.setCreateDate(new Date());
					userOtp.setEnabled(true);
					userOtp.setFirstName(user2.getFirstName());
					userOtp.setLastName(user2.getLastName());
					userOtp.setCompanyName(user2.getCompanyName());
				}
				else{
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
		UserOtp userOtp = userOtpRep.findByPrimaryKey(user, companyId);
		return userOtp;
	}

}
