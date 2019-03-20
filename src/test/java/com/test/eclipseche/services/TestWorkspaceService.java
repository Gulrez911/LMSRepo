package com.test.eclipseche.services;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.assessment.eclipseche.config.response.WorkspaceResponse;
import com.assessment.eclipseche.services.EclipseCheService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestWorkspaceService {
	EclipseCheService eclipseCheService = new EclipseCheService();
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testCreateWorkSpace() throws Exception{
		String json = FileUtils.readFileToString(new File("assessment/eclipseChe/Java_FullStack.json"));
		json = json.replace("${APP_USER}", "tikamsingh-3456-67894224"+System.currentTimeMillis());
		//json = json.replace("${APP_USER}", "a01");
		json = json.replace("${APP_DESC}", "Sample............................Project\n\n\n.........");
		
		WorkspaceResponse workspaceResponse = eclipseCheService.createWorkSpace(json);
		System.out.println(workspaceResponse.getLinks().getIde());
	}
}
