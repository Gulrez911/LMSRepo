package com.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.data.UserOtp;

public interface UserOtpRepository extends JpaRepository<UserOtp,Long>{

	
	@Query("SELECT u FROM UserOtp u WHERE u.user=:user and u.companyId=:companyId")
	UserOtp findByPrimaryKey(@Param("user") String user, @Param("companyId") String companyId);
	
}
