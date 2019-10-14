package com.assessment.webservices;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assessment.data.Question;
import com.assessment.services.QuestionService;

@Controller
public class QuestionWebService {
	@Autowired
	QuestionService questionService;
	
	//compileAndRunSystemTest
		@RequestMapping(value = "/searchQsWs", method = RequestMethod.GET , produces="application/json")
		  public @ResponseBody List<Question> searchQuestions(@RequestParam(name= "companyId") String companyId, @RequestParam(name= "search", required = false) String search, HttpServletRequest request, HttpServletResponse response) {
			if(search == null){
				return questionService.getAllLevel1Questions(companyId);
			}
			else{
				return questionService.searchQuestions(companyId, search);
			}
		  }
		
		@RequestMapping(value = "/findLevel1Qs", method = RequestMethod.GET , produces="application/json")
		public @ResponseBody List<Question> findQsByQualifier1(@RequestParam(name= "companyId") String companyId, @RequestParam(name= "qualifier1") String qualifier1){
			return questionService.findQuestionsByQualifier1(companyId, qualifier1);
		}
		
		@RequestMapping(value = "/findLevel2Qs", method = RequestMethod.GET , produces="application/json")
		public @ResponseBody List<Question> findQsByQualifier2(@RequestParam(name= "companyId") String companyId, @RequestParam(name= "qualifier1") String qualifier1, @RequestParam(name= "qualifier2") String qualifier2){
			return questionService.findQuestionsByQualifier2(companyId, qualifier1, qualifier2);
		}

}
