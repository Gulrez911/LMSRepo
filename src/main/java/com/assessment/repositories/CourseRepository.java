package com.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.data.Course;

public interface CourseRepository extends JpaRepository<Course,Long>
{
	
	@Query("SELECT c FROM Course c WHERE c.courseName=:courseName and c.companyId=:companyId")
	Course findByPrimaryKey(@Param("courseName") String courseName, @Param("companyId") String companyId);
	
	@Query("SELECT c FROM Course c WHERE c.searchLabel LIKE %:searchLabel% and c.companyId=:companyId")
	List<Course> searchCourses(@Param("searchLabel") String searchLabel, @Param("companyId") String companyId);
	
	
	@Query("SELECT c FROM Course c where c.companyId=:companyId order by c.noOfEnrollemnts DESC")
	List<Course> getPopularCourses(@Param("companyId") String companyId);
	
	List<Course> findByCompanyId(String companyId);
	
	Course findBycourseName(String courseName);
}
