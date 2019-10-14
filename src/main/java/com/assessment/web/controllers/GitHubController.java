package com.assessment.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GitHubController {

	
	Logger logger = LoggerFactory.getLogger(GitHubController.class);
	
	
	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public ModelAndView github(@RequestParam(required = false, name = "code") String code, @RequestParam(required = false, name = "state") String state, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		ModelAndView mav = new ModelAndView("github");
		System.out.println("code is "+code);
		String url = "https://github.com/login/oauth/access_token?client_id=Iv1.eb48e5a9cf3cc745&client_secret=d317fc19343bf94c9803a5ded667b0fc9e539667&code="+code;
		URL url2 = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) url2.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		conn.getOutputStream().write(new String().getBytes());
		String data = getResponse(conn);
	    ObjectMapper mapper = new ObjectMapper();
	    GitHubToken token = mapper.readValue(data, GitHubToken.class);
	    System.out.println("access token "+token.getAccess_token());
	    System.out.println("Scope "+token.getScope());
	    System.out.println("toekn type "+token.getToken_type());
		return mav;
	} 
	
	@RequestMapping(value = "/githublogin", method = RequestMethod.GET)
	public ModelAndView githublogin(@RequestParam(required = false, name = "code") String code, @RequestParam(required = false, name = "state") String state, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		ModelAndView mav = new ModelAndView("githublogin");
		return mav;
	} 
	
	public String getResponse(HttpsURLConnection con) {
		if(con!=null){
			
			try {
				
			   BufferedReader br = 
				new BufferedReader(
					new InputStreamReader(con.getInputStream()));
						
			   String input;
			   String output="";
						
			   while ((input = br.readLine()) != null){
				   output +=input;
			   }
			   br.close();
			   return output;
						
			} catch (IOException e) {
			   e.printStackTrace();
			}
					
		       }
				
		   return null;
	}
}

class GitHubToken{
	
	String access_token;
	
	String scope;
	
	String token_type;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	
	
	
}
