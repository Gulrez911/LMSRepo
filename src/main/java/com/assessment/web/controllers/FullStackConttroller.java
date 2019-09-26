package com.assessment.web.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.assessment.common.PropertyConfig;
import com.assessment.common.util.EmailGenericMessageThread;
import com.assessment.data.FullStackOptions;
import com.assessment.data.Question;
import com.assessment.data.QuestionMapperInstance;
import com.assessment.data.Test;
import com.assessment.data.User;
import com.assessment.eclipseche.config.response.WorkspaceResponse;
import com.assessment.eclipseche.services.EclipseCheService;
import com.assessment.repositories.QuestionMapperInstanceRepository;
import com.assessment.services.UserService;
import com.assessment.web.dto.TestCasesMetric;
@Controller
public class FullStackConttroller {
	
	Logger logger = LoggerFactory.getLogger(FullStackConttroller.class);
	
@Autowired	
PropertyConfig propertyConfig;

@Autowired
QuestionMapperInstanceRepository  questionMapperInstanceRep;

@Autowired
UserService userService;

	@RequestMapping(value = "/gotofullstack", method = RequestMethod.GET)
	public ModelAndView showLogin(@RequestParam String workspace, HttpServletRequest request, HttpServletResponse response) {
	String url = URLDecoder.decode(workspace);
	url = new String(Base64.getDecoder().decode(url.getBytes()));
	  ModelAndView mav = new ModelAndView("fullstack");
	  mav.addObject("url", url);
	  return mav;
	}
	
	@RequestMapping(value = "/createWorkSpaceForUser", method = RequestMethod.GET)
    public @ResponseBody String  addQuestionsToSectionAjax(@RequestParam String userName, @RequestParam String stackName, @RequestParam String questionId,@RequestParam String testId, HttpServletRequest request, HttpServletResponse response) throws Exception {
 
	 User user = (User) request.getSession().getAttribute("user");
	 	if(user == null){
	 		return "Log in Again";
	 	}
 	 userName = userName.replace(" ", "");
 	 if(stackName.equals("Java")){
 		 String json = FileUtils.readFileToString(new File("eclipseChe/Java_FullStack.json"));
 		json = json.replace("${APP_USER}", userName+"="+testId+"-"+questionId+"-"+System.currentTimeMillis());
 		//json = json.replace("${APP_USER}", "a01");
 		json = json.replace("${APP_DESC}", "Skeleton Code............................Project\n\n\n.........");
 		EclipseCheService eclipseCheService = new EclipseCheService();
 		WorkspaceResponse workspaceResponse = eclipseCheService.createWorkSpace(json);
 		return workspaceResponse.getLinks().getIde();
 	 }
	
		
        return "";
    }
	
	 @RequestMapping(value = "/submitFullStackCode", method = RequestMethod.GET)
	  public @ResponseBody String submitFullStackCode(HttpServletRequest request, HttpServletResponse response,@RequestParam String qMapperInstanceId) throws Exception {
		 ModelAndView model= new ModelAndView("test");
		 User user = (User) request.getSession().getAttribute("user");
		 Test test = (Test) request.getSession().getAttribute("test");
		 QuestionMapperInstance questionMapperInstance = questionMapperInstanceRep.findById(Long.parseLong(qMapperInstanceId)).get();
		 questionMapperInstance.setWorkspaceSubmitted(true);
		 questionMapperInstanceRep.save(questionMapperInstance);
		 String workSpaceId = questionMapperInstance.getWorkSpaceId();
		 //String projname = 
		 String workSpaceFolder = questionMapperInstance.getWorkspaceUrl().substring(questionMapperInstance.getWorkspaceUrl().indexOf("che/")+4, questionMapperInstance.getWorkspaceUrl().length());
		 String codebasePath = propertyConfig.getFullStackCodeLocation()+File.separator+workSpaceId+File.separator+workSpaceFolder;
		 System.out.println(" workSpaceFolder is "+workSpaceFolder);
		 System.out.println(" codebasePath is "+codebasePath);
		 /**
		  * step 1 create a file called sonar-project.properties in workspace foldewr
		  * 
		  * */
		 String analysisFile = "";
		 if(questionMapperInstance.getQuestionMapper().getQuestion().getFullstack().getStack().equalsIgnoreCase(FullStackOptions.JAVA_FULLSTACK.getStack())){
			System.out.println("doing code quality on java stack");
			 analysisFile = FileUtils.readFileToString(new File(propertyConfig.getSonarAnalysisFileLocation()));
		 }
		 else if(questionMapperInstance.getQuestionMapper().getQuestion().getFullstack().getStack().equalsIgnoreCase(FullStackOptions.PHP_FULLSTACK.getStack())) {
			 System.out.println("doing code quality on php stack");
			 analysisFile = FileUtils.readFileToString(new File(propertyConfig.getSonalAnalysisFilePHPLocation()));
		 }
		 else if(questionMapperInstance.getQuestionMapper().getQuestion().getFullstack().getStack().equalsIgnoreCase(FullStackOptions.ANGULARJS_FULLSTACK.getStack()) ) {
			 System.out.println("doing code quality on php stack");
			 analysisFile = FileUtils.readFileToString(new File(propertyConfig.getSonarAnalysisFileAngularLocation()));
		 }
		 else if(questionMapperInstance.getQuestionMapper().getQuestion().getFullstack().getStack().equalsIgnoreCase(FullStackOptions.JAVASCRIPT_FULLSTACK.getStack()) ) {
			 System.out.println("doing code quality on php stack");
			 analysisFile = FileUtils.readFileToString(new File(propertyConfig.getSonarAnalysisFileAngularLocation()));
		 }
		 else if(questionMapperInstance.getQuestionMapper().getQuestion().getFullstack().getStack().equalsIgnoreCase(FullStackOptions.DOTNET_FULLSTACK.getStack()) ) {
			 System.out.println("doing code quality on dot net stack");
			 analysisFile = FileUtils.readFileToString(new File(propertyConfig.getSonarAnalysisFileDotNetLocation()));
		 }
		 else{
			 System.out.println("doing code quality on others stack");
			 analysisFile = FileUtils.readFileToString(new File(propertyConfig.getSonarAnalysisFileLocation()));
		 }
	
		analysisFile = analysisFile.replace("${key}", workSpaceFolder);
		String writeLoc = codebasePath+File.separator+"sonar-project.properties";
		System.out.println(" writeLoc is "+writeLoc);
		try {
			System.out.println(" writting");
			FileUtils.write(new File(writeLoc), analysisFile);
			System.out.println(" written");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" analysis file written is ");
		 /**
		  * step 2 create a file called analyze.sh in workspace foldewr
		  * 
		  */
		 //not needed
		 
		 /**
		  * Step 3 Analyze
		  */
		 Process process;
		try {
			System.out.println("1 ");
			ProcessBuilder builder = new ProcessBuilder();
			System.out.println("2 ");
			// String[] command = {"/opt/softwares/sonar-scanner-3.3.0.1492/bin/sonar-scanner"};
			String[] command = {"/opt/sonar-scanner-4.0.0.1744-linux/bin/sonar-scanner"};
			
			 System.out.println("3 ");
			 builder.redirectErrorStream(true); // This is the important part
			 System.out.println("4 ");
			 builder.command(command);
			 System.out.println("5 "+codebasePath);
			 builder.directory(new File(codebasePath));
			 System.out.println("6 ");
			 process = builder.start();
			 System.out.println(" command given");
			 LogStreamReader lsr = new LogStreamReader(process.getInputStream());
			 System.out.println("7 ");
			 Thread thread = new Thread(lsr, "LogStreamReader");
			 thread.start();
			 System.out.println("8 ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// InputStream is = process.getInputStream();
		 
		 String html = FileUtils.readFileToString(new File(propertyConfig.getCodeQualityEmailTemplateLocation()));
		 String url = propertyConfig.getCodeQualityServerLink()+URLEncoder.encode(workSpaceFolder);
		 html = html.replace("{FULL_NAME}", user.getFirstName()+" "+user.getLastName());
		 html = html.replace("{TEST_NAME}", test.getTestName());
		 html = html.replace("{CODE_QUALITY_URL}", url);
		 
		 String reviewer = questionMapperInstance.getQuestionMapper().getQuestion().getReviewerEmail();
		 html = html.replace("{PROJECT_URL}", questionMapperInstance.getUsageDocumentUrl()==null?"":questionMapperInstance.getUsageDocumentUrl());
		 html = html.replace("{REVIEWER_EMAIL}", reviewer);
		 html = html.replace("{PASSWORD}", ""+reviewer.hashCode());
		 html = html.replace("{Company}", user.getCompanyName());
		 html = html.replace("{BASE_URL}", propertyConfig.getBaseUrl()+"login");
		// String message = "Results can not be sent for "+user.getEmail()+" for test "+test.getTestName();
		 System.out.println(" sending mail with foll link "+url);
		 TestCasesMetric casesMetric = initiateAutomation(workSpaceId, request, questionMapperInstance, url);
		 System.out.println("testmetrics "+casesMetric);
			if(casesMetric != null){
				System.out.println("testmetrics 1111111111");
				String message = "";
				message += "<b>Run Time Test Execution Summary</b><br/>";
				message += "Problem Statement - "+casesMetric.getProblemStatement()+"<br/>";
				message += "No Of Test Cases - "+casesMetric.getNoOfTestCases()+"<br/>";
				message += "No Of Test Cases Passed - "+casesMetric.getTestCasesPassed();
				questionMapperInstance.setNoOfTestCases(casesMetric.getNoOfTestCases());
				questionMapperInstance.setNoOfTestCasesPassed(casesMetric.getTestCasesPassed());
				questionMapperInstanceRep.save(questionMapperInstance);
				if(html.contains("${BEHAVIOUR}")){
					System.out.println("testmetrics goood");
				}
				else{
					System.out.println("testmetrics bad");
				}
				html = html.replace("${BEHAVIOUR}", message);
			}
			
			html = html.replace("${BEHAVIOUR}", "");//just make sure this is not there for tests not having automation
		 	EmailGenericMessageThread client = new EmailGenericMessageThread("jatin.sutaria@thev2technologies.com", "Code quality Report Link for "+user.getFirstName(), html, propertyConfig);
		 	String cc[] = {reviewer};
		 	client.setCcArray(cc);
		 	Thread th = new Thread(client);
			th.start();
			
		 return "Your code has been submitted for verification. This is a 2 step process - Code quality (or behaviour compliance if configured) will be measured through automation and other compilances will be judged by reviewer.";
	 }
	 
	 private TestCasesMetric initiateAutomation(String workspaceId, HttpServletRequest request, QuestionMapperInstance questionMapperInstance, String codeQualityUrl) throws IOException{
		 User user = userService.findByPrimaryKey(questionMapperInstance.getUser(), questionMapperInstance.getCompanyId());
		 if(workspaceId.contains("psk2y2afb3ecogbh")){
			 System.out.println("00000000000000000");
			 String path = "/root/.che-multiuser/instance/data/workspaces/workspacepsk2y2afb3ecogbh/regex_jdbc";
			 String outputFile = ""+System.currentTimeMillis()+".txt";
			 String[] command = ("/usr/bin/mvn -Dtest=com.assignment.regex.TestPatternFinder test --log-file "+outputFile).split("\\s+");
			 System.out.println(command);
			 ProcessBuilder builder = new ProcessBuilder();
			 builder.command(command);
			 builder.directory(new File(path));
			 Process process = builder.start();
			 LogStreamReader lsr = new LogStreamReader(process.getInputStream());
			 System.out.println("regex problem ");
			 Thread thread = new Thread(lsr, "LogStreamReader");
			 thread.start();
			 try{
				 Thread.sleep(10000);
			 }
			 catch(InterruptedException e){
				 
			 }
			 String op_path = path+"/"+outputFile;
			 List<String> lines = FileUtils.readLines(new File(op_path));
			 Integer noOfTestCases = 0;
			 Integer noOfTestCasesFailed = 0;
			 for(String line : lines){
				 if(line.contains("Tests run:")){
					 
					 String split[] = line.split(",");
					 for(String unit : split){
						 String test[] = unit.split(":");
						 System.out.println(test[0]);
						 System.out.println(test[1]);
						 if(test[0].trim().equals("Tests run")){
							 noOfTestCases = Integer.parseInt(test[1].trim());
						 }
						 
						 if(test[0].trim().equals("Failures")){
							 noOfTestCasesFailed = Integer.parseInt(test[1].trim());
							 break;
						 }
					 }
					 
					break;
				 }
			 }
			 
			 String testcaseResults = "regex.txt";
			 String line1 = "noOfTestCases$$$"+noOfTestCases;
			 String line2 = "noOfTestCasesFailed$$$"+noOfTestCasesFailed;
			 String pb = questionMapperInstance.getQuestionMapper().getQuestion().getQuestionText().replaceAll("\n", "<br/>").replace("\r", "");
			 String line3 = "problem$$$"+pb;
			 String line4 = "name$$$"+user.getFirstName()+" "+user.getLastName();
			 String line5 = "testName$$$"+questionMapperInstance.getTestName();
			 String line6 = "codeQualityLink$$$"+codeQualityUrl;
			 String line7 = "usageLink$$$"+questionMapperInstance.getUsageDocumentUrl();
			 List<String> writelines = new ArrayList<>();
			 writelines.add(line1);
			 writelines.add(line2);
			 writelines.add(line3);
			 writelines.add(line4);
			 writelines.add(line5);
			 writelines.add(line6);
			 writelines.add(line7);
			 
			 FileUtils.writeLines(new File(testcaseResults), writelines);
			 TestCasesMetric casesMetric = new TestCasesMetric();
			 casesMetric.setNoOfTestCases(noOfTestCases);
			 casesMetric.setTestCasesPassed(noOfTestCases - noOfTestCasesFailed);
			 casesMetric.setProblemStatement(questionMapperInstance.getQuestionMapper().getQuestion().getQuestionText());
			 casesMetric.setCodeQualityLink(codeQualityUrl);
			 casesMetric.setProjDocLink(questionMapperInstance.getUsageDocumentUrl());
			 return casesMetric;
		 }
		 else if(workspaceId.contains("zigca3iu5ynpydhp")){
			 System.out.println("1111111111111111111111111111");
			 String path = "/root/.che-multiuser/instance/data/workspaces/workspacezigca3iu5ynpydhp/JohnDoe-48-47-1568040746461";
			// String path = "/root/.che-multiuser/instance/data/workspaces/workspacek9jw1ghhtr724g7q/console-java-simple";
			 String outputFile = ""+System.currentTimeMillis()+".txt";
			 String[] command = ("/usr/bin/mvn -Dtest=com.problem1.TestProblem1 test --log-file "+outputFile).split("\\s+");
			 System.out.println("command is "+command.toString());
			 ProcessBuilder builder = new ProcessBuilder();
			 builder.command(command);
			 builder.directory(new File(path));
			 Process process = builder.start();
			 LogStreamReader lsr = new LogStreamReader(process.getInputStream());
			 System.out.println("collection problem ");
			 Thread thread = new Thread(lsr, "LogStreamReader");
			 thread.start();
			 try{
				 Thread.sleep(10000);
			 }
			 catch(InterruptedException e){
				 
			 }
			 System.out.println("test cases fired ");
			 String op_path = path+"/"+outputFile;
			 System.out.println("test cases result file"+op_path);
			 List<String> lines = FileUtils.readLines(new File(op_path));
			 System.out.println("no of lines in "+op_path+" is "+lines.size());
			 Integer noOfTestCases = 0;
			 Integer noOfTestCasesFailed = 0;
			 for(String line : lines){
				
				 if(line.contains("Tests run:")){
					 System.out.println("here !!!!!!!!!1 "+line);
					 String split[] = line.split(",");
					 for(String unit : split){
						 String test[] = unit.split(":");
						 System.out.println(test[0]);
						 System.out.println(test[1]);
						 if(test[0].trim().equals("Tests run")){
							 System.out.println("test cases run ");
							 noOfTestCases = Integer.parseInt(test[1].trim());
						 }
						 
						 if(test[0].trim().equals("Failures")){
							 System.out.println("test cases failed ");
							 noOfTestCasesFailed = Integer.parseInt(test[1].trim());
							 break;
						 }
					 }
					 
					break;
				 }
			 }
			 
			 String testcaseResults = "collections_logic.txt";
			 String line1 = "noOfTestCases$$$"+noOfTestCases;
			 String line2 = "noOfTestCasesFailed$$$"+noOfTestCasesFailed;
			 String pb = questionMapperInstance.getQuestionMapper().getQuestion().getQuestionText().replaceAll("\n", "<br/>").replace("\r", "");
			 String line3 = "problem$$$"+pb;
			 String line4 = "name$$$"+user.getFirstName()+" "+user.getLastName();
			 String line5 = "testName$$$"+questionMapperInstance.getTestName();
			 String line6 = "codeQualityLink$$$"+codeQualityUrl;
			 String line7 = "usageLink$$$"+questionMapperInstance.getUsageDocumentUrl();
			 List<String> writelines = new ArrayList<>();
			 writelines.add(line1);
			 writelines.add(line2);
			 writelines.add(line3);
			 writelines.add(line4);
			 writelines.add(line5);
			 writelines.add(line6);
			 writelines.add(line7);
			 
			 FileUtils.writeLines(new File(testcaseResults), writelines);
			 TestCasesMetric casesMetric = new TestCasesMetric();
			 casesMetric.setNoOfTestCases(noOfTestCases);
			 casesMetric.setTestCasesPassed(noOfTestCases - noOfTestCasesFailed);
			 casesMetric.setProblemStatement(questionMapperInstance.getQuestionMapper().getQuestion().getQuestionText());
			 casesMetric.setCodeQualityLink(codeQualityUrl);
			 casesMetric.setProjDocLink(questionMapperInstance.getUsageDocumentUrl());
			 System.out.println("Automation cases run");
			 return casesMetric;
		 }
		 else{
			 return null;
		 }
	 }
	 
	 
	 @RequestMapping(value = "/uploadProjectDocs", method = RequestMethod.POST)
	 public @ResponseBody String doUpload(@RequestParam("addimage") MultipartFile addimage,HttpServletRequest request, HttpServletResponse response, @RequestParam String qMapperInstanceId) throws Exception {     
		 String docUrl = "";
		 ModelAndView mav = null;
			User user = (User) request.getSession().getAttribute("user");
			List<Question> questions = new ArrayList<Question>();
			if(addimage != null){
				String fileName = qMapperInstanceId+(user.getFirstName()+user.getLastName()+System.currentTimeMillis())+addimage.getOriginalFilename();
				 String destination = propertyConfig.getFileServerLocation()+File.separator+"docs"+File.separator+fileName;
				 File file = new File(destination);
				 	if( file.exists()){
				 		if(addimage.getOriginalFilename() != null && addimage.getOriginalFilename().trim().length() > 0){
				 			FileUtils.forceDelete(file);
				 		}
				 		
				 	}
				 	if(addimage.getOriginalFilename() != null && addimage.getOriginalFilename().trim().length() > 0){
				 		 docUrl = propertyConfig.getFileServerWebUrl()+"docs/"+fileName;
						
				 		 addimage.transferTo(file);
				 	}
				
				
			}
			
			QuestionMapperInstance questionMapperInstance = questionMapperInstanceRep.findById(Long.parseLong(qMapperInstanceId)).get();
			questionMapperInstance.setUsageDocumentUrl(docUrl);
			//questionMapperInstance.setWorkspaceSubmitted(true);
			questionMapperInstanceRep.save(questionMapperInstance);
	     return docUrl;
	 }
	 
	 @RequestMapping(value = "/multifileresults", method = RequestMethod.GET)
		public ModelAndView multifileresults(@RequestParam String workspace, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = URLDecoder.decode(workspace);
		url = new String(Base64.getDecoder().decode(url.getBytes()));
		  ModelAndView mav = new ModelAndView("runtimeResults");
		  List<String> lines = null;
		  if(workspace.equals("k9jw1ghhtr724g7q")){
			  //collections
			  
			  lines = FileUtils.readLines(new File("collections_logic.txt"));
		  }
		  else if(workspace.equals("psk2y2afb3ecogbh")){
			  //regex
			  lines = FileUtils.readLines(new File("regex.txt"));
		  }
		  mav.addObject("testGiver", lines.get(3).substring(lines.get(3).indexOf("$$$")+3, (lines.get(3).length())));
		  mav.addObject("problemStatement", lines.get(2).substring(lines.get(2).indexOf("$$$")+3, (lines.get(2).length())).replaceAll("\n", "<br/>"));
		  mav.addObject("testName", lines.get(4).substring(lines.get(4).indexOf("$$$")+3, (lines.get(4).length())));
		  mav.addObject("codeQuality", lines.get(5).substring(lines.get(5).indexOf("$$$")+3, (lines.get(5).length())));
		  mav.addObject("usageLink", lines.get(6).substring(lines.get(6).indexOf("$$$")+3, (lines.get(6).length())));
		  mav.addObject("noOfTestCases", lines.get(0).substring(lines.get(0).indexOf("$$$")+3, (lines.get(0).length())));
		  mav.addObject("noOfTestCasesFailed", lines.get(1).substring(lines.get(1).indexOf("$$$")+3, (lines.get(1).length())));
		  return mav;
		}
	
	
}

class LogStreamReader implements Runnable {
	Logger logger = LoggerFactory.getLogger(LogStreamReader.class);
    private BufferedReader reader;

    public LogStreamReader(InputStream is) {
        this.reader = new BufferedReader(new InputStreamReader(is));
    }

    public void run() {
        try {
            String line = reader.readLine();
            while (line != null) {
            	logger.info(line);
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("error writing stack", e);
        }
    }
}

