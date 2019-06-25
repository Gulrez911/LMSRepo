package com.assessment.services;

import com.assessment.data.UserOtp;

public interface UserOtpService {

	
	public UserOtp getOtpForUser(String user, String companyId);
	
	public UserOtp findExistingUserOtp(String user, String companyId);
}
