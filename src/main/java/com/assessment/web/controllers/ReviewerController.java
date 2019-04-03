package com.assessment.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.assessment.data.CodeMetrics;
import com.assessment.data.QuestionMapperInstance;
import com.assessment.data.Test;
import com.assessment.data.User;
import com.assessment.data.UserType;
import com.assessment.repositories.QuestionMapperInstanceRepository;
import com.assessment.services.CodeMetricsService;
import com.assessment.services.QuestionMapperInstanceService;
import com.assessment.services.TestService;
import com.assessment.services.UserService;

@Controller
public class ReviewerController {
	@Autowired
	QuestionMapperInstanceService qminService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	QuestionMapperInstanceRepository qminrep;
	
	@Autowired
	CodeMetricsService codeMetricsService;
	
	
	 @RequestMapping(value = "/showJavaFullStack", method = RequestMethod.GET)
	 public ModelAndView showJavaFullStack(HttpServletRequest request, HttpServletResponse response,@RequestParam String qMapperInstanceId) throws Exception {
		 User user = (User) request.getSession().getAttribute("user");
		 if(!(user != null && user.getUserType().getType().equals(UserType.REVIEWER.getType()))){
			 ModelAndView mav = new ModelAndView("index");
			    User usr = new User();
			    mav.addObject("user", usr);
			    return mav;
		 }
		 ModelAndView mav = new ModelAndView("java_fullstack");
		 List<QuestionMapperInstance> instances = qminService.findFullStackQuestionMapperInstancesForJava(user.getCompanyId());
		 for(QuestionMapperInstance ins : instances){
		 		User u = userService.findByPrimaryKey(ins.getUser(), user.getCompanyId());
		 		ins.setUerFullName(u.getFirstName()+" "+u.getLastName());
		 	}
		 mav.addObject("instances", instances);
		 return mav;
	 }
	 
	 @RequestMapping(value = "/showDotNetFullStack", method = RequestMethod.GET)
	 public ModelAndView showDotNetFullStack(HttpServletRequest request, HttpServletResponse response,@RequestParam String qMapperInstanceId) throws Exception {
		 User user = (User) request.getSession().getAttribute("user");
		 if(!(user != null && user.getUserType().getType().equals(UserType.REVIEWER.getType()))){
			 ModelAndView mav = new ModelAndView("index");
			    User usr = new User();
			    mav.addObject("user", usr);
			    return mav;
		 }
		 ModelAndView mav = new ModelAndView("dotnet_fullstack");
		 List<QuestionMapperInstance> instances = qminService.findFullStackQuestionMapperInstancesForDotNet(user.getCompanyId());
		 for(QuestionMapperInstance ins : instances){
		 		User u = userService.findByPrimaryKey(ins.getUser(), user.getCompanyId());
		 		ins.setUerFullName(u.getFirstName()+" "+u.getLastName());
		 	}
		 mav.addObject("instances", instances);
		 return mav;
	 }
	 
	 @RequestMapping(value = "/showJavascriptFullStack", method = RequestMethod.GET)
	 public ModelAndView showJavascriptFullStack(HttpServletRequest request, HttpServletResponse response,@RequestParam String qMapperInstanceId) throws Exception {
		 User user = (User) request.getSession().getAttribute("user");
		 if(!(user != null && user.getUserType().getType().equals(UserType.REVIEWER.getType()))){
			 ModelAndView mav = new ModelAndView("index");
			    User usr = new User();
			    mav.addObject("user", usr);
			    return mav;
		 }
		 ModelAndView mav = new ModelAndView("javscript_fullstack");
		 List<QuestionMapperInstance> instances = qminService.findFullStackQuestionMapperInstancesForDotNet(user.getCompanyId());
		 for(QuestionMapperInstance ins : instances){
		 		User u = userService.findByPrimaryKey(ins.getUser(), user.getCompanyId());
		 		ins.setUerFullName(u.getFirstName()+" "+u.getLastName());
		 	}
		 mav.addObject("instances", instances);
		 return mav;
	 }
	 
	 @RequestMapping(value = "/saveFullstackReview", method = RequestMethod.POST)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public @ResponseBody String   saveFullstackReview(HttpServletRequest request, HttpServletResponse response, CodeMetrics codeMetrics){
		 QuestionMapperInstance instance = qminrep.findById(codeMetrics.getQuestionMapperInstanceId()).get();
		 codeMetrics.setQuestionId(instance.getQuestionMapper().getQuestion().getId());
		 codeMetrics.setQuestion(instance.getQuestionMapper().getQuestion());
		 codeMetrics.setEmail(instance.getUser());
		// codeMetrics.setFullName(instance.getUerFullName());
		 codeMetrics.setTestName(instance.getTestName());
		 Test test = testService.findbyTest(instance.getTestName(), instance.getCompanyId());
		 codeMetrics.setTestId(test.getId());
		 codeMetrics.setCompanyId(instance.getCompanyId());
		 codeMetrics.setCompanyName(instance.getCompanyName());
		 codeMetricsService.saveOrUpdate(codeMetrics);
		 return "ok";
	 }

}
