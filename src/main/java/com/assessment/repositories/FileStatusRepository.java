package com.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FileStatusRepository extends JpaRepository<com.assessment.data.FileStatus, Long>{

	
	@Query("SELECT f FROM FileStatus f WHERE f.email=:email")
	public com.assessment.data.FileStatus getUniqueFileStatus(@Param("email") String email);
	
}
