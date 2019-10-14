package com.assessment.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.common.Qualifiers;
import com.assessment.data.QuestionMapper;

public interface QuestionMapperRepository extends JpaRepository<QuestionMapper,Long>{
	
	@Query("SELECT q FROM QuestionMapper q WHERE q.testName=:testName and q.sectionName=:sectionName and q.companyId=:companyId")
	public List<QuestionMapper> getQuestionsForSection(@Param("testName") String testName, @Param("sectionName") String sectionName, @Param("companyId") String companyId);
	
	@Query("SELECT COUNT(q) FROM QuestionMapper q WHERE q.sectionName=:sectionName and q.testName=:testName and q.companyId=:companyId")
	Integer findCountQuestionMapperForTestAndSection(@Param("sectionName") String sectionName, @Param("testName") String testName,   @Param("companyId") String companyId);
	
	List<QuestionMapper>  	findByQuestion_id(Long id);
	
	@Query("SELECT " +
	           "    new com.assessment.common.Qualifiers(q.qualifier1, q.qualifier2, q.qualifier3, q.qualifier4, q.qualifier5) " +
	           "FROM " +
	           "    Question q, QuestionMapper m WHERE q.companyId=:companyId and m.testName=:testName and q.id=m.question.id  GROUP BY q.qualifier1, q.qualifier2, q.qualifier3, q.qualifier4, q.qualifier5")
	public Set<Qualifiers> getAllUniqueQualifiersForTest(@Param("companyId")String companyId, @Param("testName")String testName);


}
