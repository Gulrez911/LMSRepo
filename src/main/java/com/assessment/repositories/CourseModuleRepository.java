package com.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.data.Course;
import com.assessment.data.CourseModule;

public interface CourseModuleRepository extends JpaRepository<CourseModule,Long>
{
	
	@Query("SELECT c FROM CourseModule c WHERE c.moduleName=:moduleName and c.courseName=:courseName and c.companyId=:companyId")
	CourseModule findByPrimaryKey(@Param("moduleName") String moduleName,@Param("courseName") String courseName, @Param("companyId") String companyId);
	
	@Query("SELECT c FROM CourseModule c WHERE c.courseName=:courseName and c.companyId=:companyId")
	List<CourseModule> findModulesByCourseName(@Param("courseName") String courseName, @Param("companyId") String companyId);

	List<CourseModule> findByCompanyId(String companyId);
	
}
