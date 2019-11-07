package com.assessment.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assessment.common.CompileData;
import com.assessment.common.CompileOutput;
import com.assessment.services.SQLCodingAutomationService;
import com.assessment.services.impl.CompilerService;

@Controller
public class CompilerController {
	@Autowired
	CompilerService compilerService;
	
	@Autowired
	SQLCodingAutomationService automationService;
	
	private String evaluateMySQLCoding(String query){
		 List results;
		try {
			results = automationService.fireDirectQuery(query);
		} 
		catch(PersistenceException e){
			System.out.println(e.getCause().getMessage());
			try {
				SQLGrammarException e1 = (SQLGrammarException)e.getCause();
				System.out.println("111 "+e1.getSQLException().getMessage());
				System.out.println("222 " +e1.getSQLException().getLocalizedMessage());
				return e1.getSQLException().getMessage();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "System Problem with Docker infra "+e1.getMessage();//tp message
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Query Problem"+e.getMessage());
			return "Query Problem"+e.getMessage();
		}
		 String ret = "";
		 
		 List<String> ress = new ArrayList();
		 if(results != null && results.size() > 0){
			 if(results.get(0) instanceof String){
				 ress = (List<String>) results;
				 
				 for(String s : ress){
					 ret += s + "   \n";
				 }
				 return ret;
			 }
			 else if(results.get(0) instanceof String[]){
				 System.out.println("multiple results");
			List<String[]> op = (List<String[]> ) results;
				 for(String[] row : op){
					 for(Object col : row){
						 ret += col +"    ";
					 }
					 ret += "\n";
				 }
			 }
			 else if(results.get(0) instanceof Object[]){
				 System.out.println("multiple results 111");
			List<Object[]> op =  results;
				 for(Object[] row : op){
					 for(Object col : row){
						 ret += col.toString() +"    ";
					 }
					 ret += "\n";
				 }
			 }
			 else{
				 System.out.println("multiple results but no where");
				 System.out.println(results.get(0).getClass());
			 }
		 }
		return ret;	 
		 
	 }
	
	
	@RequestMapping(value = "/compile", method = RequestMethod.POST , consumes="application/json")
	  public @ResponseBody String compile(HttpServletRequest request, HttpServletResponse response,@RequestBody CompileData data) {
		try {
//			data = URLDecoder.decode(data);
//			ObjectMapper mapper = new ObjectMapper();
//			CompileData dat = mapper.readValue(data, CompileData.class);
			if(data.getLanguage().equals("13")){
				return evaluateMySQLCoding(data.getCode());
			}
			
			CompileOutput op=  compilerService.compile(data);
			return op.getOutput() +"\n\n"+op.getErrors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Compiler Services not available. Contact your Test Administrator";
		} 
	  }
	
	//compileAndRunSystemTest
	@RequestMapping(value = "/compileAndRunSystemTest", method = RequestMethod.POST , consumes="application/json" )
	  public @ResponseBody String compileAndRunSystemTest(HttpServletRequest request, HttpServletResponse response,@RequestBody CompileData data) {
		try {
			
			CompileOutput op=  compilerService.compile(data);
				if(op.getErrors() != null && op.getErrors().trim().length() > 0){
					return op.getErrors() +"\n"+op.getOutput();
				}
			return op.getOutput().replaceAll("\n", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Compiler Services not available. Contact your Test Administrator";
		} 
	  }
}
