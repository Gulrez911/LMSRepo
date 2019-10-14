package com.assessment.services;

import org.springframework.data.repository.query.Param;

import com.assessment.data.UserTestTimeCounter;

public interface UserTestTimeCounterService {
	
	public UserTestTimeCounter saveOrUpdate(UserTestTimeCounter userTestTimeCounter);
	
	public UserTestTimeCounter findByPrimaryKey(Long testId,  String email, String companyId);

}
