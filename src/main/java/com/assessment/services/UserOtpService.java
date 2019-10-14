package com.assessment.services;

import com.assessment.data.UserOtp;

public interface UserOtpService {

	
	public UserOtp getOtpForUser(String user, String companyId);
	
	public UserOtp findExistingUserOtp(String user, String companyId);
	
	public UserOtp getOtpForTestByUser(String user, String test, String companyId);
	
	public UserOtp findExistingUserOtpforTest(String user, String companyId, String test);
	
	public void deleteUserOtp(String user, String companyId, String test);
}
