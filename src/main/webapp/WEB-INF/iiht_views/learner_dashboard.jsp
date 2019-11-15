<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Codecademy</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="css/pnotify.custom.min.css" rel="stylesheet" type="text/css">
        <link href="css/lms_style.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div class="learnercourse">

            <div class="header">
                <div class="headertop">
                    <div class="col-md-12">
                        <div class="col-md-2 col-xs-6">
                            <div class="logo">
                                <a href="#"><h1>Codecademy</h1></a>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <div class="rightsideinfo">
                                <ul>
                                    <li><a href="#"><img src="images/user.png"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="userinfo">
                <div class="col-md-12">
                    <div class="image">
                        <img src="images/user.png">
                    </div>
                    <div class="content">
                        <h4>Sreeram Gopal</h4>
                        <span>Free Member</span>
                    </div>
                </div>
            </div>


            <div class="coursesprogress">
                <div class="col-md-12">
                    <div class="col-md-6 col-xs-6">
                        <label>No of courses enrolled</label>
                        <div class="progress">
                            <div class="progress-bar" style="width:${dto.noOfCoursesEnrolled}%">${dto.noOfCoursesEnrolled}%</div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-6">
                        <label>No of courses completed</label>
                        <div class="progress">
                            <div class="progress-bar" style="width:${dto.noOfCoursesCompleted}%">${dto.noOfCoursesCompleted}%</div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-6">
                        <label>No of learning paths enrolled</label>
                        <div class="progress">
                            <div class="progress-bar" style="width:${dto.noOfLearningPathsEnrolled}%">${dto.noOfLearningPathsEnrolled}%</div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-6">
                        <label>No of learning paths completed</label>
                        <div class="progress">
                            <div class="progress-bar" style="width:${dto.noOfLearningPathsCompleted}%">${dto.noOfLearningPathsCompleted}%</div>
                        </div>
                    </div>
                    <div class="col-md-12 col-xs-12">
                        <label style="width: 24.2%;">Your Weighted Knowledge Score</label>
                        <div class="progress" style="float: left;width: ${dto.weightedScorePercentage}%">
                            <div class="progress-bar" style="width:80%">${dto.weightedScorePercentage}%</div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="otherblank">
                <img class="blogimg" src="images/Blog.jpg">
            </div>


            <div class="col-md-12">
                <div class="coursetabs">
                    <div class="col-md-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#mylearningpaths">My Learning Paths</a></li>
                            <li class="completed"><a data-toggle="tab" href="#mycourses">My Courses</a></li>
                        </ul>
                    </div>
                </div>

                <div class="onlinecourses">
                    <div class="tab-content">
                        <div id="mylearningpaths" class="tab-pane fade in active">
                            <div class="courselisting">
                                <div class="col-md-12">

                                    <div class="searchheader">
                                        <form action="#">
                                            <input type="text" placeholder="Search">
                                            <input type="submit" value="submit" style="display: none;">
                                            <i class="fa fa-search"></i>
                                        </form>
                                    </div>

                                   <!-- <label>My Learning Paths</label> -->
									<c:forEach  items="${dto.enrolledLearningPaths}" var="path">
                                    <div class="col-md-4">
                                        <div class="item">
											<img src="images/learningPath.png">
                                            <!--<span>Learning Path</span> -->
                                            <h3><a href="goToLearningPath?lpid=${path.learningObjectId}">${path.learningObjectName}</a></h3>
                                           
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>

                                
                            </div>
                        </div>

                        <div id="mycourses" class="tab-pane fade in">
                            <div class="courselisting">
                                <div class="col-md-12">
                                    <div class="searchheader">
                                        <form action="#">
                                            <input type="text" placeholder="Search">
                                            <input type="submit" value="submit" style="display: none;">
                                            <i class="fa fa-search"></i>
                                        </form>
                                    </div>
                                    <!-- <label>My Courses</label> -->
                                    <c:forEach  items="${dto.enrolledCourses}" var="enrolledCourse">
                                    <div class="col-md-4">
                                        <div class="item">
                                            <div class="itemicon">
												<img src="images/online_course.png">
											</div>
                                            <h3><a href="javascript:showModules('${enrolledCourse.learningObjectId}');">${enrolledCourse.learningObjectName}</a></h3>
                                          
                                        </div>
                                    </div>
                                    </c:forEach>
                                    
                                </div>

                                
                            </div>
                        </div>
                    </div>
                </div>


                <div class="coursetabs">
                    <div class="col-md-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#popularlearningpaths">Popular Learning Paths</a></li>
                            <li class="completed"><a data-toggle="tab" href="#popularcourses">Popular Courses</a></li>
                        </ul>
                    </div>
                </div>

                <div class="onlinecourses">
                    <div class="tab-content">
                        <div id="popularlearningpaths" class="tab-pane fade in active">
                            <div class="courselisting">
                                <div class="col-md-12">
                                    <div class="searchheader">
                                        <form action="#">
                                            <input type="text" placeholder="Search">
                                            <input type="submit" value="submit" style="display: none;">
                                            <i class="fa fa-search"></i>
                                        </form>
                                    </div>
                                    <label>Popular Learning Paths</label>
                                    <c:forEach  items="${dto.popularLearningPaths}" var="lpath">
                                    <div class="col-md-4">
                                        <div class="item">
                                           <img src="images/learningPath.png">
											<!--<img  src="images/enroll.png" onClick="enrollLearningPath('${lpath.id}', '${lpath.name}')"/> -->
                                             <!--<h3><a data-toggle="modal" data-target="#myModal" href="javascript:voi(0);">${lpath.name}</a></h3> -->
											<h3><a href="javascript:showCoursesForLearningPath('${lpath.id}', '${lpath.name}');">Show Courses</a></h3>
											<h3><a href="javascript:enrollLearningPath('${lpath.id}', '${lpath.name}');">Enroll to ${lpath.name} </a></h3>
											
                                            <p>${lpath.description} </p>
											
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>

                                
                            </div>
                        </div>

                        <div id="popularcourses" class="tab-pane fade in">
                            <div class="courselisting">
                                <div class="col-md-12">
                                    <div class="searchheader">
                                        <form action="#">
                                            <input type="text" placeholder="Search">
                                            <input type="submit" value="submit" style="display: none;">
                                            <i class="fa fa-search"></i>
                                        </form>
                                    </div>
                                    <label>Popular Courses</label>
                                    <c:forEach  items="${dto.popularCourses}" var="course">
                                    <div class="col-md-4">
											
                                        <div class="item">
                                            <span>Course</span>
											<div class="itemicon">
												<a href="javascript:onlyshowcourseModules('${course.id}');" ><img src="images/online_course.png"></a>
											</div>
                                            <!-- <h3><a data-toggle="modal" data-target="#myModal" href="javascript:voi(0);">${course.courseName}</a></h3> -->
											<!-- <h3><a href="javascript:showModules('${course.id}');">${course.courseName}</a></h3> -->
								<h3><a href="javascript:enrollCourse('${course.id}', '${course.courseName}');">Enroll to ${course.courseName}</a></h3>
                                            <p>${course.courseDesc}</p>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>

                                
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
		
		<div class="footer">
            <div class="col-md-12 text-center">
                <p>Copyright © 2018 IIHT. All Rights Reserved Privacy Policy For Enterprise Solutions</p>
            </div>
        </div>

        <!-- Video Popup Modal -->
        <!-- Modules info Popup Modal to display-->
        <div class="modal fade recentcoursespopup" id="myModalModules" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content" style="padding: 10px;display: inline-block;">
		      <button type="button" class="close"  onClick="hideDialog()" id="closeModulesWin">&times;</button> 
                    <div class="modal-body">
                        <div class="progreses">
                           
                            
                        </div>
                        <div id="modulesDiv">
                          
						</div>
			
			
                    </div>
                    <div class="modal-footer" style="margin-top: 10px;float: left;width: 100%;">
		    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
		
		<!-- For showing learning paths -- >
		<!-- Modules info Popup Modal to display-->
        <div class="modal fade recentcoursespopup" id="myModalLearningPaths" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content" style="padding: 10px;display: inline-block;">
		      <button type="button" class="close"  onClick="hideLearningPathsDialog()" id="closeModulesWin">&times;</button> 
                    <div class="modal-body">
                        <div class="progreses">
                           
                            
                        </div>
                        <div id="pathsDiv">
                          
						</div>
			
			<input type="hidden" id="hiddencourseId" />
			<input type="hidden" id="hiddencourseInstanceId" />
			<input type="hidden" id="onlyCourseId" />
                    </div>
                    <div class="modal-footer" style="margin-top: 10px;float: left;width: 100%;">
		    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>


        <div class="modal fade" id="myModalvideo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <iframe id="iframeYoutube" width="560" height="315"  src="" frameborder="0" allowfullscreen></iframe> 
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="scripts/jquery.min.js"></script>
        <script src="scripts/bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/pnotify.custom.min.js"></script>

        <script>
			$(document).ready(function () {
				$("#myModalvideo").on("hidden.bs.modal", function () {
					$("#iframeYoutube").attr("src", "#");
				})
			})
			
			function changeVideo(vId) {
				var iframe = document.getElementById("iframeYoutube");
				iframe.src = vId;
				$("#myModalvideo").modal("show");
				$("#myModal").modal("hide");
			}
				
			function onlyshowcourseModules(cid){
				$.get("onlyshowcourseModules?cid="+cid, function(data, status){
				   console.log(data);
				$("#modulesDiv").empty();
				$("#modulesDiv").append(data);
					$("#myModalModules").modal("show");
				}); 
			}
				
			function showModules(cid){
				$.get("courseModules?cid="+cid, function(data, status){
				   console.log(data);
				$("#modulesDiv").empty();
				$("#modulesDiv").append(data);
					$("#myModalModules").modal("show");
				}); 
			}
			
			function enrollCourse(cid, cname){
				console.log(cname);
				$.get("enrollCourse?cid="+cid, function(data, status){
				   console.log(data);
				notify('Information', 'You have enrolled to the following course - '+cname+'. Refresh the page to see your enrollments');
				}); 
			}
			
			function enrollLearningPath(lid, lname){
				console.log(lname);
				$.get("enrollLearningPath?lid="+lid, function(data, status){
				   console.log(data);
				notify('Information', 'You have enrolled to the following Learning Path - '+lname+'. Refresh the page to see your enrollments');
				}); 
			}
			
			function showCoursesForLearningPath(lpathid){
				$.get("showCoursesForLearningPath?lid="+lpathid, function(data, status){
				   console.log(data);
				$("#pathsDiv").empty();
				$("#pathsDiv").append(data);
					$("#myModalLearningPaths").modal("show");
				});
			}
			
			function notify(messageType, message){
		 var notification = 'Information';
			 $(function(){
				 new PNotify({
				 title: notification,
				 text: message,
				 type: messageType,
				 styling: 'bootstrap3',
				 hide: true
			     });
			 }); 	
		}
			
			function hideDialog(){
			  $("#myModalModules").modal("hide");
			}
			
			function hideLearningPathsDialog(){
			  $("#myModalLearningPaths").modal("hide");
			}
			
        </script>
		<c:if test="${msgtype != null}">
		 <script>
		 var notification = 'Information';
		 $(function(){
			 new PNotify({
			 title: notification,
			 text: '${message}',
			 type: '${msgtype}',
			 styling: 'bootstrap3',
			 hide: true
		     });
		 }); 	 
	      </script>
	</c:if>

    </body>
</html>