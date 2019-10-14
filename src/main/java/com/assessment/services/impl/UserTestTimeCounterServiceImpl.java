package com.assessment.services.impl;

import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.UserTestTimeCounter;
import com.assessment.repositories.UserTestTimeCounterRepository;
import com.assessment.services.UserTestTimeCounterService;

@org.springframework.stereotype.Service
@Transactional
public class UserTestTimeCounterServiceImpl implements UserTestTimeCounterService {
	@Autowired
	UserTestTimeCounterRepository counterRep;

	@Override
	public UserTestTimeCounter saveOrUpdate(UserTestTimeCounter userTestTimeCounter) {
		// TODO Auto-generated method stub
		UserTestTimeCounter userTestTimeCounter2 = findByPrimaryKey(userTestTimeCounter.getTestId(), userTestTimeCounter.getEmail(), userTestTimeCounter.getCompanyId());
			if(userTestTimeCounter2 == null){
				userTestTimeCounter.setCreateDate(new Date());
				counterRep.save(userTestTimeCounter);
				return userTestTimeCounter;
			}
			else{
				Mapper mapper = new DozerBeanMapper();
				userTestTimeCounter.setId(userTestTimeCounter2.getId());
				userTestTimeCounter.setUpdateDate(new Date());
				mapper.map(userTestTimeCounter, userTestTimeCounter2);
				userTestTimeCounter2.setUpdateDate(new Date());
				counterRep.save(userTestTimeCounter2);
				return userTestTimeCounter2;
			}
		
		//return null;
	}

	@Override
	public UserTestTimeCounter findByPrimaryKey(Long testId, String email, String companyId) {
		// TODO Auto-generated method stub
		return counterRep.findByPrimaryKey(testId, email, companyId);
	}

}
