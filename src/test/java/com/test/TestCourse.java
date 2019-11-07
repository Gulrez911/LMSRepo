package com.test;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.contour.ContourDataset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.Exceptions.AssessmentGenericException;
import com.assessment.data.Course;
import com.assessment.data.CourseModule;
import com.assessment.data.CourseType;
import com.assessment.data.LearningPath;
import com.assessment.services.CourseModuleService;
import com.assessment.services.CourseService;
import com.assessment.services.LearningPathService;
import com.assessment.services.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestCourse {
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseModuleService courseModuleService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	LearningPathService learningPathService;
	
	static int count = 1;
	
	private static String returnRandom(){
		String ret = "";
		if(count == 1){
			ret =  "Java";
		}
		else if(count == 2){
			ret =  "Dot Net";
		}
		else if(count == 3){
			ret =  "Python";
		}
		else if(count == 4){
			ret =  "Big Data";
		}
		count ++;
		if(count > 4){
			count = 1;
		}
		return ret;
	}
	
	@Test
	@Rollback(value=false)
	public void testCreateCourse(){
		for(int i=1 ; i<=100;i++){
		Course course = new Course();
		course.setActiveStatus(true);
		course.setCourseName("Course "+i);
		course.setCourseType(CourseType.ONLINE);
		course.setDuration(1800);
		course.setImageUrl("http://13.233.2.169/file-server/lms/learn-1.png");
		course.setNoOfEnrollemnts(0);
		String ret = returnRandom();
		course.setSearchLabel(ret);
		course.setTechnology(ret);
		course.setCompanyId("IH");
		course.setCompanyName("IIHT");
		courseService.saveOrUpdate(course);
		}
	}
	
	@Test
	@Rollback(value=false)
	public void testCreateModule(){
		String testName = "Java_Course_Test_26Sep_Basics";
		com.assessment.data.Test test = testService.findbyTest(testName, "IH");
		for(int i=1 ; i<=100;i++){
			String str = "Course "+i;
			Course course = courseService.findByPrimaryKey(str, "IH");
			for(int j=1; j<=10;j++){
				CourseModule courseModule = new CourseModule();
				courseModule.setCompanyName("IIHT");
				courseModule.setCompanyId("IH");
				courseModule.setContentLink("https://www.youtube.com/embed/s3Ejdx6cIho");
				courseModule.setDuration(8);
				
				courseModule.setCourseName(str);
				
				if(course == null){
					throw new AssessmentGenericException();
				}
				courseModule.setCourseId(course.getId());
				courseModule.setDuration(8);
				courseModule.setModuleName("Module "+j);
				courseModule.setTestId(test.getId());
				courseModule.setTestName(test.getTestName());
				courseModuleService.saveOrUpdate(courseModule);
			}
			
			
		}
		
	}
	
	@Test
	@Rollback(value=false)
	public void testCreateLearningPath(){
		List<Course> courses = new ArrayList<Course>();
		for(int l = 16; l <=20 ; l++){
			LearningPath path = new LearningPath();
			path.setCompanyId("IH");
			path.setCompanyName("IIHT");
			path.setImageUrl("http://13.233.2.169/file-server/lms/learn-3.png");
			path.setName("Learning Path"+l);
			path.setSearchLabel("Big Data");
			path.setTechnology("Big Data");
			int count = 4;
			String courseName = "Course "+count;
			Course course1 = courseService.findByPrimaryKey(courseName, "IH");
			if(course1 == null){
				throw new AssessmentGenericException();
			}
			path.getCourses().add(course1);
			
			count += 4;
			courseName = "Course "+count;
			Course course2 = courseService.findByPrimaryKey(courseName, "IH");
			if(course2 == null){
				throw new AssessmentGenericException();
			}
			path.getCourses().add(course2);
			
			count += 4;
			courseName = "Course "+count;
			Course course3 = courseService.findByPrimaryKey(courseName, "IH");
			if(course3 == null){
				throw new AssessmentGenericException();
			}
			path.getCourses().add(course3);
			
			count += 4;
			courseName = "Course "+count;
			Course course4 = courseService.findByPrimaryKey(courseName, "IH");
			if(course4 == null){
				throw new AssessmentGenericException();
			}
			path.getCourses().add(course4);
			
			count += 4;
			courseName = "Course "+count;
			Course course5 = courseService.findByPrimaryKey(courseName, "IH");
			if(course5 == null){
				throw new AssessmentGenericException();
			}
			path.getCourses().add(course5);
			learningPathService.saveOrUpdate(path);
		}
		
	}

}
