package com.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.data.Enrollment;
import com.assessment.data.LearningObjectType;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>
{
	
	@Query("SELECT c FROM Enrollment c WHERE c.email=:email and  c.learningObjectName=:learningObjectName and c.learningObjectId=:learningObjectId and c.companyId=:companyId")
	Enrollment findByPrimaryKey(@Param("email") String email, @Param("learningObjectName") String learningObjectName, @Param("learningObjectId") Long learningObjectId, @Param("companyId") String companyId);
	
	@Query("SELECT c FROM Enrollment c WHERE c.email=:email and c.companyId=:companyId")
	List<Enrollment> getEnrollemntsForUser(@Param("email") String email, @Param("companyId") String companyId);
	
	
	@Query("SELECT c FROM Enrollment c WHERE c.email=:email and c.companyId=:companyId and c.learningObjectType=:learningObjectType")
	List<Enrollment> getEnrollemntsForUserByType(@Param("email") String email, @Param("learningObjectType") LearningObjectType learningObjectType, @Param("companyId") String companyId);
	
	
	@Query("SELECT count(c) FROM Enrollment c WHERE c.email=:email and c.companyId=:companyId and c.learningObjectType=:learningObjectType")
	Integer getCountOfEnrollemntsForUserByType(@Param("email") String email, @Param("learningObjectType") LearningObjectType learningObjectType, @Param("companyId") String companyId);
	
	@Query("SELECT count(c) FROM Enrollment c WHERE c.email=:email and c.companyId=:companyId and c.learningObjectType=:learningObjectType and c.completionStatus=:completionStatus")
	Integer getCountOfEnrollemntsForUserByTypeAndStatus(@Param("email") String email, @Param("learningObjectType") LearningObjectType learningObjectType, @Param("completionStatus") Boolean completionStatus, @Param("companyId") String companyId);
	
}
