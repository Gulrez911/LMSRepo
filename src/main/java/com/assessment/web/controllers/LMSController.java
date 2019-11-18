package com.assessment.web.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.assessment.data.Course;
import com.assessment.data.CourseModule;
import com.assessment.data.Enrollment;
import com.assessment.data.LearningObjectType;
import com.assessment.data.LearningPath;
import com.assessment.data.Test;
import com.assessment.data.User;
import com.assessment.data.UserType;
import com.assessment.repositories.CourseModuleRepository;
import com.assessment.repositories.CourseRepository;
import com.assessment.repositories.LearningPathRepository;
import com.assessment.services.CourseModuleService;
import com.assessment.services.CourseService;
import com.assessment.services.EnrollmentService;
import com.assessment.services.LearningPathService;
import com.assessment.services.TestService;
import com.assessment.web.dto.LMSLearnerDashboardDTO;

@Controller
public class LMSController {
	@Autowired
	LearningPathService learningPathService;

	@Autowired
	CourseService courseService;

	@Autowired
	CourseRepository courseRep;

	@Autowired
	EnrollmentService enrollmentService;

	@Autowired
	CourseModuleService courseModuleService;

	@Autowired
	LearningPathRepository pathRep;

	@Autowired
	TestService testService;

	@Autowired
	CourseModuleRepository courseModuleRepository;

	@Autowired
	LMSController lmsController;

	@RequestMapping(value = "/learnerDashboard", method = RequestMethod.GET)
	public ModelAndView goToLearnerDashboard(@RequestParam String email, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model;
		User user = (User) request.getSession().getAttribute("user");
		if (!user.getUserType().getType().equalsIgnoreCase(UserType.STUDENT.getType())) {
			model = new ModelAndView("login");
			return model;
		}
		LMSLearnerDashboardDTO dashboardDTO = new LMSLearnerDashboardDTO();
		Integer noOfLearningPathsEnrolled = enrollmentService.getCountOfEnrollemntsForUserByType(email,
				LearningObjectType.LEARNING_PATH, user.getCompanyId());
		Integer noOfCoursesEnrolled = enrollmentService.getCountOfEnrollemntsForUserByType(email,
				LearningObjectType.COURSE, user.getCompanyId());

		Integer noOfLearningPathsCompleted = enrollmentService.getCountOfEnrollemntsForUserByTypeAndStatus(
				email, LearningObjectType.LEARNING_PATH, true, user.getCompanyId());
		Integer noOfCoursesCompleted = enrollmentService.getCountOfEnrollemntsForUserByTypeAndStatus(email,
				LearningObjectType.COURSE, true, user.getCompanyId());
		Float weightedPercentage = enrollmentService.getWeightedScore(email, user.getCompanyId());

		List<Enrollment> paths = enrollmentService.getEnrollemntsForUserByType(email,
				LearningObjectType.LEARNING_PATH, user.getCompanyId());
		List<Enrollment> courses = enrollmentService.getEnrollemntsForUserByType(email,
				LearningObjectType.COURSE, user.getCompanyId());

		List<LearningPath> popularPaths = learningPathService.getPopularLearningPaths(user.getCompanyId());
		List<Course> popularCourses = courseService.getPopularCourses(user.getCompanyId());
		// dashboardDTO.set
		dashboardDTO.setEnrolledCourses(courses);
		dashboardDTO.setEnrolledLearningPaths(paths);
		dashboardDTO.setNoOfCoursesCompleted(noOfCoursesCompleted);
		dashboardDTO.setNoOfCoursesEnrolled(noOfCoursesEnrolled);
		dashboardDTO.setNoOfLearningPathsCompleted(noOfLearningPathsCompleted);
		dashboardDTO.setNoOfLearningPathsEnrolled(noOfLearningPathsEnrolled);

		dashboardDTO.setPopularCourses(popularCourses);
		dashboardDTO.setPopularLearningPaths(popularPaths);
		dashboardDTO.setWeightedScorePercentage("" + weightedPercentage);
		model = new ModelAndView("learner_dashboard");
		model.addObject("dto", dashboardDTO);
		return model;

	}

	@RequestMapping(value = "/enrollCourse", method = RequestMethod.GET)
	@ResponseBody
	public String enrollCourse(@RequestParam(name = "cid", required = true) Long cid, HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		Enrollment enrollment = new Enrollment();
		enrollment.setCompanyId(user.getCompanyId());
		enrollment.setCompanyName(user.getCompanyName());
		enrollment.setLearningObjectType(LearningObjectType.COURSE);
		Course course = courseRep.findById(cid).get();
		enrollment.setLearningObjectName(course.getCourseName());
		enrollment.setLearningObjectId(cid);
		enrollment.setStartDate(new Date());
		enrollment.setEmail(user.getEmail());
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date nextYear = cal.getTime();
		enrollment.setCompletionDate(nextYear);
		enrollment.setCompletionPercentage(0f);
		enrollment.setCompletionStatus(false);
		enrollmentService.saveOrUpdate(enrollment);
		return "OK";
	}

	// enrollLearningPath
	@RequestMapping(value = "/enrollLearningPath", method = RequestMethod.GET)
	@ResponseBody
	public String enrollLearningPath(@RequestParam(name = "lid", required = true) Long lid,
			HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		Enrollment enrollment = new Enrollment();
		enrollment.setCompanyId(user.getCompanyId());
		enrollment.setCompanyName(user.getCompanyName());
		enrollment.setLearningObjectType(LearningObjectType.LEARNING_PATH);
		LearningPath path = pathRep.findById(lid).get();
		enrollment.setLearningObjectName(path.getName());
		enrollment.setLearningObjectId(lid);
		enrollment.setStartDate(new Date());
		enrollment.setEmail(user.getEmail());
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date nextYear = cal.getTime();
		enrollment.setCompletionDate(nextYear);
		enrollment.setCompletionPercentage(0f);
		enrollment.setCompletionStatus(false);
		enrollmentService.saveOrUpdate(enrollment);
		return "OK";
	}

	@RequestMapping(value = "/goToLearningPath", method = RequestMethod.GET)
	public ModelAndView goToLearningPath(@RequestParam Long lpid, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("learner_learningPath");
		User user = (User) request.getSession().getAttribute("user");
		LearningPath learningPath = pathRep.findById(lpid).get();
		model.addObject("path", learningPath);
		return model;
	}

	@RequestMapping(value = "/learnerHome", method = RequestMethod.GET)
	public ModelAndView learnerHome(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		return lmsController.goToLearnerDashboard(user.getEmail(), request, response);
	}

	@RequestMapping(value = "/courseModules", method = RequestMethod.GET)
	@ResponseBody
	public String courseModules(@RequestParam(name = "cid", required = true) Long cid, HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		try {
			Course course = courseRep.findById(cid).get();
			System.out.println("course object " + course);
			String res = "";

			String init = " <label style=\"float: left;width: 100%;\">Modules for the course - ${coursename}</label>\r\n"
					+ "	\r\n" + "                        <div class=\"corecontent\">\r\n"
					+ "                            <label>Online content</label>\r\n"
					+ "                            <label>${course.hours} minutes</label>\r\n"
					+ "                        </div>";

			String base = "<p style=\"float: left;width: 100%;\">${course.overView} </p>";
			base = base.replace("${course.overView}",
					course.getCourseDesc() == null ? "Overview NA" : course.getCourseDesc());
			init = init.replace("${coursename}", course.getCourseName());
			init = init.replace("${course.hours}",
					course.getDuration() == null ? "NA" : "" + course.getDuration());

			String block = "<div class=\"courseitem\">\r\n" + " <div class=\"itemicon\">\r\n"
					+ "                <img onclick=\"changeVideo('${moduleVideo}')\" src=\"images/play1.png\">  "
					+ "            </div>"
					+ "				    <div class=\"itemname\">\r\n"
					+ "					<h5>${module.name}</h5>\r\n" +
					// " <p>Resource Type - ${module.resourceType}</p>\r\n" +
					"				    </div>\r\n"
					+ "  <div class=\"lastvisit\"> \r\n"
					+ "   <a href=\"${TEST_URL}\" target=\"_blank\"><img src=\"images/icon-self1.png\"></a>\r\n"
					+ "</div>\r\n" +
					// "<a href=\"${TEST_URL}\" target=\"_blank\">Test Yourself</a>" +
					"				   \r\n" + "				</div>";

			// res += base +"\n"+ init +"\n";
			String newClass = "<div class=\"innerpopuppart\"> \n";
			User user = (User) request.getSession().getAttribute("user");
			List<CourseModule> courseModules = courseModuleService
					.findModulesByCourseName(course.getCourseName(), user.getCompanyId());

			res += base + "\n" + init + "\n" + newClass;
			for (CourseModule module : courseModules) {
				String mod = block.replace("${module.name}", module.getModuleName());
				mod = mod.replace("${moduleVideo}", module.getContentLink());
				// mod = mod.replace("${moduleImage}", "images/play1.png");
				Long testId = module.getTestId();
				String testUrl = testService.getTestUrlForUser(user.getEmail(), testId,
						user.getCompanyId());
				mod = mod.replace("${TEST_URL}", testUrl);
				res += mod + "\n";
			}
			// return mav;
			res += "</div>";
			return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	@RequestMapping(value = "/onlyshowcourseModules", method = RequestMethod.GET)
	@ResponseBody
	public String onlyshowcourseModules(@RequestParam(name = "cid", required = true) Long cid,
			HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		try {
			Course course = courseRep.findById(cid).get();
			System.out.println("course object " + course);
			String res = "";

			String init = " <label style=\"float: left;width: 100%;\">Modules for the course - ${coursename}</label>\r\n"
					+ "	\r\n" + "                        <div class=\"corecontent\">\r\n"
					+ "                            <label>Online content</label>\r\n"
					+ "                            <label>${course.hours} minutes</label>\r\n"
					+ "                        </div>";

			String base = "<p style=\"float: left;width: 100%;\">${course.overView} </p>";
			base = base.replace("${course.overView}",
					course.getCourseDesc() == null ? "Overview NA" : course.getCourseDesc());
			init = init.replace("${coursename}", course.getCourseName());
			init = init.replace("${course.hours}",
					course.getDuration() == null ? "NA" : "" + course.getDuration());

			String block = "<div class=\"courseitem\">\r\n"
					+ "			<div class=\"itemname\">\r\n"
					+ "					<h5>${module.name}</h5>\r\n" +
					// " <p>Resource Type - ${module.resourceType}</p>\r\n" +
					"			</div>\r\n" + "  <div class=\"lastvisit\"> \r\n"
					+ "   <a href=\"${TEST_URL}\" target=\"_blank\"><img src=\"images/icon-self1.png\"></a>\r\n"
					+ "</div>\r\n" +
					// "<a href=\"${TEST_URL}\" target=\"_blank\">Test Yourself</a>" +
					"				   \r\n" + "				</div>";

			// res += base +"\n"+ init +"\n";
			String newClass = "<div class=\"innerpopuppart\"> \n";
			User user = (User) request.getSession().getAttribute("user");
			List<CourseModule> courseModules = courseModuleService
					.findModulesByCourseName(course.getCourseName(), user.getCompanyId());

			res += base + "\n" + init + "\n" + newClass;
			for (CourseModule module : courseModules) {
				String mod = block.replace("${module.name}", module.getModuleName());
				mod = mod.replace("${moduleVideo}", module.getContentLink());
				// mod = mod.replace("${moduleImage}", "images/play1.png");
				Long testId = module.getTestId();
				String testUrl = testService.getTestUrlForUser(user.getEmail(), testId,
						user.getCompanyId());
				mod = mod.replace("${TEST_URL}", testUrl);
				res += mod + "\n";
			}
			// return mav;
			res += "</div>";
			return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	@RequestMapping(value = "/showCoursesForLearningPath", method = RequestMethod.GET)
	@ResponseBody
	public String showCoursesForLearningPath(@RequestParam(name = "lid", required = true) Long lid,
			HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		try {
			LearningPath learningPath = pathRep.findById(lid).get();
			User user = (User) request.getSession().getAttribute("user");
			List<Course> courses = learningPath.getCourses();
			Integer totalDuration = 0;
			for (Course course : courses) {
				totalDuration += (course.getDuration() == null ? 0 : course.getDuration());
			}

			int hours = totalDuration / 60;
			int minutes = totalDuration % 60;
			String duration = hours + " Hours and " + minutes + " Minutes";

			// Course course = courseRep.findById(cid).get();
//			System.out.println("course object "+course);
			String res = "";

			String init = " <label style=\"float: left;width: 100%;\">Courses for the Learning Path - ${learningPathName}</label>\r\n"
					+ "	\r\n" + "                        <div class=\"corecontent\">\r\n"
					+ "                            <label>Online content</label>\r\n"
					+ "                            <label> ${path.hours}.</label>\r\n"
					+ "                            <label> Total number of Enrollments - ${totalEnrollments}.</label>\r\n"
					+ "                        </div>";

			String base = "<p style=\"float: left;width: 100%;\">${path.overView} </p>";
			base = base.replace("${path.overView}", learningPath.getDescription() == null ? "Overview NA"
					: learningPath.getDescription());
			init = init.replace("${learningPathName}", learningPath.getName());
			init = init.replace("${path.hours}", duration);
			init = init.replace("${totalEnrollments}", "" + learningPath.getNoOfEnrollments());

			String block = "<div class=\"courseitem\">\r\n" + " <div class=\"itemicon\">\r\n"
					+ "            </div>"
					+ "				    <div class=\"itemname\">\r\n"
					+ "					<h5>${course.name}</h5>\r\n"
					+ "					<h6>${course.overiew}</h6>\r\n"
					+ "					<p>Course Duration - ${course.duration}</p>\r\n"
					+ "				    </div>\r\n"
					+ "				   \r\n" + "				</div>";

			// res += base +"\n"+ init +"\n";
			String newClass = "<div class=\"innerpopuppart\"> \n";

			res += base + "\n" + init + "\n" + newClass;
			for (Course course : courses) {
				String mod = block.replace("${course.name}", course.getCourseName());
				mod = mod.replace("${course.overiew}",
						course.getCourseDesc() == null ? "NA" : course.getCourseDesc());
				mod = mod.replace("${course.duration}", course.getDuration() == null ? "NA"
						: "" + course.getDuration() + " minutes");
				// mod = mod.replace("${moduleImage}", "images/play1.png");
				res += mod + "\n";
			}
			// return mav;
			res += "</div>";
			return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@GetMapping(value = "/addLearningPath")
	public ModelAndView addLearningPath(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("learningPath");
		User user = (User) request.getSession().getAttribute("user");
		List<Course> listCourse = courseRep.findByCompanyId(user.getCompanyId());
		System.out.println("Found: " + listCourse);
		mav.addObject("listCourse", listCourse);
		LearningPath lp = new LearningPath();
		mav.addObject("learningPath", lp);
		return mav;
	}

	@PostMapping(value = "/saveLearningPath")
	public ModelAndView saveLearningPath(@ModelAttribute("course") Course course,
			@ModelAttribute("learningPath") LearningPath learningPath, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("learningPath");
		User user = (User) request.getSession().getAttribute("user");
		learningPath.setCompanyId(user.getCompanyId());
		learningPath.setCompanyName(user.getCompanyName());
		List<Course> listCourse = new ArrayList<Course>();
		for(String name:learningPath.getCourse()) {
			Course cs = courseService.findByPrimaryKey(name, user.getCompanyId());
			listCourse.add(cs);
		}
		learningPath.setCourses(listCourse);
		learningPathService.saveOrUpdate(learningPath);
		System.out.println("Found: " + listCourse);
		mav.addObject("listCourse", listCourse);
		mav.addObject("learningPath", new LearningPath());
		return mav;
	}

	@GetMapping(value = "/addCourse")
	public ModelAndView addCourse(@RequestParam(name = "courseName", required = false) String courseName,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("addCourse");
		User user = (User) request.getSession().getAttribute("user");
		List<Course> listCourse = courseRep.findByCompanyId(user.getCompanyId());
		long id = 0;
		List<CourseModule> listCourseModules = new ArrayList<>();
		String courseName2=null;
		if (!listCourse.isEmpty()) {
			  courseName2 = listCourse.get(0).getCourseName();
			
			id = listCourse.get(0).getId();
			listCourseModules = courseModuleService.findModulesByCourseName(courseName2, user.getCompanyId());
		}
		if (courseName != null) {
			listCourseModules = courseModuleService.findModulesByCourseName(courseName, user.getCompanyId());
			Course cs = courseRep.findBycourseName(courseName);
			id = cs.getId();
		}
		if(courseName==null) {
			courseName = courseName2;
		}
		List<Test> listTest = testService.findByCompanyId(user.getCompanyId());
		mav.addObject("testList", listTest);
		mav.addObject("cname", courseName);
		mav.addObject("listCourseModules", listCourseModules);
		mav.addObject("course", new Course());
		mav.addObject("courseModule", new CourseModule());
		mav.addObject("listCourse", listCourse);
		mav.addObject("id", id);
		return mav;
	}

	@PostMapping(value = "/saveCourse")
	public ModelAndView saveCourse(@ModelAttribute("course") Course course,
			@RequestParam(name = "courseName", required = false) String courseName,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("addCourse");
		User user = (User) request.getSession().getAttribute("user");
		course.setCompanyId(user.getCompanyId());
		course.setCompanyName(user.getCompanyName());
		Course cs =courseService.saveOrUpdate(course);
		List<Course> listCourse = courseRep.findByCompanyId(user.getCompanyId());
		List<CourseModule> listCourseModules = new ArrayList<>();
		if (!listCourse.isEmpty()) {
			listCourseModules = courseModuleService.findModulesByCourseName(cs.getCourseName(), user.getCompanyId());
		}
		List<Test> listTest = testService.findByCompanyId("ih");
		mav.addObject("testList", listTest);
		mav.addObject("cname", courseName);
		mav.addObject("listCourseModules", listCourseModules);
		mav.addObject("course", new Course());
		mav.addObject("courseModule", new CourseModule());
		mav.addObject("listCourse", listCourse);
		mav.addObject("id", cs.getId());
		return mav;
	}

	@PostMapping(value = "/saveCourseModule")
	public ModelAndView saveCourseModule(@ModelAttribute("courseModule") CourseModule courseModule,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("addCourse");
		User user = (User) request.getSession().getAttribute("user");
		List<Course> listCourse = courseRep.findByCompanyId(user.getCompanyId());
		courseModule.setCompanyId(user.getCompanyId());
		courseModule.setCompanyName(user.getCompanyName());
		Test test = testService.findbyTest(courseModule.getTestName(), user.getCompanyId());
		courseModule.setTestId(test.getId());
		courseModuleService.saveOrUpdate(courseModule);
		List<CourseModule> listCourseModules = courseModuleService.findModulesByCourseName(courseModule.getCourseName(), user.getCompanyId());
		Course cs = courseRep.findBycourseName(courseModule.getCourseName());
		List<Test> listTest = testService.findByCompanyId(user.getCompanyId());
		mav.addObject("testList", listTest);
		mav.addObject("cname", courseModule.getCourseName());
		mav.addObject("listCourseModules", listCourseModules);
		mav.addObject("course", new Course());
		mav.addObject("courseModule", new CourseModule());
		mav.addObject("listCourse", listCourse);
		mav.addObject("id", cs.getId());
		return mav;
	}
	
	@GetMapping(value = "/deleteCourse")
	public ModelAndView deleteCourse(@RequestParam Long id2,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("addCourse");
		User user = (User) request.getSession().getAttribute("user");
		courseRep.deleteById(id2);
		List<Course> listCourse = courseRep.findByCompanyId(user.getCompanyId());
		long id = 0;
		List<CourseModule> listCourseModules = new ArrayList<>();
		String courseName ="";
		if (!listCourse.isEmpty()) {
			 courseName = listCourse.get(0).getCourseName();
			id = listCourse.get(0).getId();
			listCourseModules = courseModuleService.findModulesByCourseName(courseName, user.getCompanyId());
		}
		List<Test> listTest = testService.findByCompanyId(user.getCompanyId());
		mav.addObject("testList", listTest);
		mav.addObject("cname", courseName);
		mav.addObject("listCourseModules", listCourseModules);
		mav.addObject("course", new Course());
		mav.addObject("courseModule", new CourseModule());
		mav.addObject("listCourse", listCourse);
		mav.addObject("id", id);
		return mav;
	}
	
	@GetMapping(value = "/deleteModule")
	public ModelAndView deleteModule(@RequestParam Long id2,HttpServletRequest request) {
		ModelAndView mav = new  ModelAndView("addCourse");
		User user = (User) request.getSession().getAttribute("user");
		courseModuleRepository.deleteById(id2);
		List<Course> listCourse = courseRep.findByCompanyId(user.getCompanyId());
		long id = 0;
		List<CourseModule> listCourseModules = new ArrayList<>();
		String courseName ="";
		if (!listCourse.isEmpty()) {
			 courseName = listCourse.get(0).getCourseName();
			id = listCourse.get(0).getId();
			listCourseModules = courseModuleService.findModulesByCourseName(courseName, user.getCompanyId());
		}
		List<Test> listTest = testService.findByCompanyId(user.getCompanyId());
		mav.addObject("testList", listTest);
		mav.addObject("cname", courseName);
		mav.addObject("listCourseModules", listCourseModules);
		mav.addObject("course", new Course());
		mav.addObject("courseModule", new CourseModule());
		mav.addObject("listCourse", listCourse);
		mav.addObject("id", id);
		return mav;
	}
	
	@GetMapping(value = "learningpath")
	public ModelAndView learningPath(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("learningPath_list");
		User user = (User) request.getSession().getAttribute("user");
		 List<LearningPath> list =pathRep.findByCompanyId(user.getCompanyId());
		 
		 mav.addObject("list",list);
		return mav;
	}
}