package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.common.ExcelReader;
import com.assessment.common.Qualifiers;
import com.assessment.data.Company;
import com.assessment.data.Question;
import com.assessment.data.QuestionMapper;
import com.assessment.data.QuestionMapperInstance;
import com.assessment.repositories.QuestionMapperInstanceRepository;
import com.assessment.repositories.QuestionMapperRepository;
import com.assessment.repositories.QuestionRepository;
import com.assessment.services.CompanyService;
import com.assessment.services.QuestionMapperInstanceService;
import com.assessment.services.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestQuestion {
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionMapperRepository questionMapperRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	QuestionMapperInstanceRepository instanceRep;
	
	@Autowired
	QuestionMapperInstanceService questionMapperInstanceService;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	public void testQMC(){
		List<QuestionMapperInstance> ins = instanceRep.findCodingQuestionMapperInstances("IH");
		System.out.println(ins.size());
	}
	
	@Test
	public void testGetUniqueQualifiers(){
		Set<Qualifiers> qs = questionRepository.getAllUniqueQualifiers("IH");
		System.out.println(qs.size());
		for(Qualifiers qualifiers : qs){
			System.out.println(qualifiers.getQualifier1()+" ." +qualifiers.getQualifier2()+" ."+ qualifiers.getQualifier3()+" ."+ qualifiers.getQualifier4()+" ."+ qualifiers.getQualifier5());
		}
	}
	
	@Test
	public void testGetInstancesByQualifier(){
		List<QuestionMapperInstance> instances = questionMapperInstanceService.getInstancesOR("Java", "IH");
		System.out.println(instances.size());
	}
	
	@Test
	public void testQuestion() {
		Page<Question> questions = questionService.findQuestionsByPage("IH", 0);
		System.out.println(questions.getSize());
	}
	
	@Test
	public void testGetLevel1Qs(){
		List<Question> qs = questionService.getAllLevel1Questions("IH");
		for(Question q : qs){
			System.out.println(q.getQualifier1());
		}
	}
	
	@Test
	@Rollback(value=false)
	public void testUniqueQMIS() {
		List<QuestionMapperInstance> ins = instanceRep.findQuestionMapperInstancesForUserForTest("Recruitment_Drive_Comprehensive_test_fresher", "patilsiddesh941@gmail.com", "IH");
		System.out.println(ins.size());
	}
	
	@Test
	@Rollback(value=false)
	public void testGetQuestionMapper() {
		List<QuestionMapper> mappers = questionMapperRepository.findByQuestion_id(76l);
		System.out.println(mappers.size());
	}
	
	@Test
	@Rollback(value=false)
	public void testCreateQuestion() {
		Question q = new Question();
		q.setCompanyId("V2");
		q.setCompanyName("V2 Technologies");
		q.setQuestionText("Qhat is your name");
		questionService.createQuestion(q);
	}
	
	@Test
	@Rollback(value=false)
	public void testUploadquestions() throws Exception{
		FileInputStream fis = new FileInputStream("AssessmentEngine_Upload_Data.xlsx");
		File file = new File("questions.xml");
		List<Question> questions = ExcelReader.parseExcelFileToBeans(fis, file);
		Company company = companyService.findByPrimaryKey("IIHT", "IH");
		for(Question q : questions) {
			System.out.println(q.getQuestionText());
			q.setCompanyId(company.getCompanyId());
			q.setCompanyName(company.getCompanyName());
			questionService.createQuestion(q);
		}
	}

}