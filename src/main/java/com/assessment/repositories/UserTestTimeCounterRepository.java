package com.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.data.UserTestTimeCounter;

public interface UserTestTimeCounterRepository extends JpaRepository<UserTestTimeCounter,Long>
{
	
	@Query("SELECT u FROM UserTestTimeCounter u WHERE u.companyId=:companyId and  u.email=:email and u.testId=:testId")
	UserTestTimeCounter findByPrimaryKey(@Param("testId") Long testId, @Param("email") String email, @Param("companyId") String companyId);
	
	
}


