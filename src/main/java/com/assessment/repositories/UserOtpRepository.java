package com.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.data.UserOtp;

public interface UserOtpRepository extends JpaRepository<UserOtp,Long>{

	
	@Query("SELECT u FROM UserOtp u WHERE u.user=:user and u.companyId=:companyId  ORDER by u.updateDate desc")
	List<UserOtp> findByPrimaryKey(@Param("user") String user, @Param("companyId") String companyId);
	
	@Query("SELECT u FROM UserOtp u WHERE u.user=:user and u.companyId=:companyId and u.testName=:testName")
	UserOtp findByPrimaryKeyTest(@Param("user") String user, @Param("companyId") String companyId, @Param("testName") String testName);
	
}
