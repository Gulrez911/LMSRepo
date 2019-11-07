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
        <style>
            body{
                background-color: #fff;
                height: auto;
            }
            .coursetabs{
                float: left;
                width: 100%;
            }
            .learnercourse{
                float: left;
                width: 100%;
            }
            .coursetabs{
                margin-top: 30px;
            }
            .courselisting{
                float: left;
                width: 100%;
                padding-top: 30px;
                padding-bottom: 50px;
            }
            .courselisting .item{
                float: left;
                width: 100%;
                padding: 20px;
                margin-bottom: 30px;
                position: relative;
                border: 1px solid #3e75f9;
                border-top: 8px solid #3e75f9;

            }
            .courselisting label{
                color: #000;
                float: left;
                width: 100%;
                padding-left: 15px;
                font-size: 20px;
                padding-bottom: 10px;
                font-weight: normal;
            }
            .courselisting .item i{
                position: absolute;
                top: 20px;
                right: 20px;
                background-color: #3e75f9;
                padding: 10px 15px;
                text-align: center;
                border-radius: 50%;
                font-size: 20px;
                color: #fff;
            }
            .courselisting .item h3{
                float: left;
                width: 100%;
                font-size: 20px;
                height: 50px;
                overflow: hidden;
            }
            .courselisting .item h3 a{
                color: #3e75f9;
                text-decoration: none;
            }
            .courselisting .item p{
                color: #000;
                float: left;
                width: 100%;
            }
            .courselisting .item img{
                position: absolute;
                top: 20px;
                right: 20px;
                border-radius: 50%;
            }
            .header{
                padding: 20px 0;
            }
            .logo {
                padding: 0 !important;
            }
            .logo h1{
                color: #000;
                font-weight: bold;
                font-size: 25px;
                margin: 0;
            }
            .logo a{
                text-decoration: none;
            }
            .rightsideinfo{
                float: left;
                width: 100%;
            }
            .rightsideinfo ul{
                float: right;
            }
            .rightsideinfo ul li{
                display: inline-block;
                padding: 0 20px;
            }
            .rightsideinfo ul li.trybtn a{
                background-color: #3e75f9;
                padding: 10px 25px;
                color: #fff;
                border-radius: 25px;
                text-decoration: none;
            }
            .rightsideinfo ul li a{
                color: #fff;
            }
            .rightsideinfo ul li i{
                font-size: 20px;
            }
            .rightsideinfo ul li img{
                width: 35px;
                border-radius: 50%;
            }
            .navigationmenu li a{
                padding-top: 0 !important;
                color: #fff;
            }
            .userinfo{
                float: left;
                width: 100%;
                background-color: #3e75f9;
                padding: 20px 0;
                color: #fff;
            }
            .userinfo .image{
                float: left;
                width: 80px;
            }
            .userinfo .image img{
                width: 50px;
                border-radius: 50%;
            }
            .userinfo .content{
                float: left;
            }
            .userinfo .content h4{
                margin-top: 0;
            }
            .userinfo ul{
                float: right;
            }
            .userinfo ul li{
                display: inline-block;
                text-align: center;
                padding: 0 20px;
            }
            .userinfo ul li h4{
                font-weight: bold;
                font-size: 20px;
                margin-bottom: 0;
            }
            .searchheader{
                float: left;
                width: 100%;
                padding-left: 15px;
            }
            .searchheader form{
                float: left;
                width: 30%;
                position: relative;
            }
            .searchheader input[type="text"] {
                width: 100%;
                border-radius: 25px;
                padding: 10px 20px;
                font-family: 'Poppins' !important;
                font-size: 16px;
                border: 1px solid #727780;
            }
            .searchheader i {
                position: absolute;
                right: 15px;
                top: 12px;
                cursor: pointer;
                font-size: 20px;
                color: #727780;
            }
            .coursetabs{
                background: none;
            }
            .coursetabs .nav-tabs li.active:first-child a, .coursetabs .nav-tabs li:first-child a.active{
                border-radius: 100px 0 0 100px;
            }
            .coursetabs .nav-tabs{
                float: left;
                width: 100%;
                text-align: center;
            }
            .coursetabs .nav-tabs li{
                display: inline-block;
                float: none;
            }
            .coursesprogress{
                float: left;
                width: 100%;
                padding-top: 30px;
            }
            .coursesprogress label{
                float: left;
                font-weight: normal;
                font-size: 16px;
                width: 50%;
            }
            .progress{
                float: right;
                width: 50%;
                height: 18px;
                margin-bottom: 30px;
                border-radius: 35px;
            }
            .progress-bar{
                background-color: #3e75f9;
            }
            .otherblank{
                float: left;
                width: 100%;
            }
            .otherblank .blogimg{
                width: 100%;
            }
            .modal .modal-footer button{
                background-color: #3e75f9;
                color: #fff;
                border: none;
                padding: 10px 30px;
                font-weight: bold;
                border-radius: 20px;
            }
            .recentcoursespopup .courseitem .itemicon img{
                cursor: pointer;
            }
            .coursetabs .nav-tabs {
                border: none;
                float: left;
            }
            .coursetabs .nav-tabs li.active a, .coursetabs .nav-tabs li a.active {
                background: #3E75F9;
                border-radius: 100px;
                border: none;
                padding: 5px 30px;
                color: #fff;
                opacity: 100;
            }
            .coursetabs .nav-tabs li a {
                background-color: #373e4b;
                border: none;
                padding: 5px 30px;
                border-radius: 0;
                opacity: 0.7;
                font-size: 16px;
                color: #FFFFFF;
                letter-spacing: 0.06px;
            }
            .coursetabs .nav-tabs li:last-child a {
                border-radius: 0px 20px 20px 0;
            }
            .coursetabs .nav-tabs li:first-child a {
                border-radius: 20px 0px 0px 20px;
            }
            .recentcoursespopup .progreses label {
                font-size: 18px;
            }
            .progress {
                height: 18px;
                background: #666666;
            }
            .recentcoursespopup .progreses span {
                float: left;
                margin-left: 10px;
                position: relative;
                top: -4px;
            }
            .progress-bar {
                border-radius: 5px;
            }
            .recentcoursespopup .progreses label{
                font-size: 18px;
            }
            .recentcoursespopup .progreses span {
                float: left;
                margin-left: 10px;
                position: relative;
                top: -4px;
            }
            .recentcoursespopup .corecontent label{
                float: left;
                font-weight: normal;
            }
            .recentcoursespopup .corecontent label:last-child{
                float: right;
            }
            .recentcoursespopup .courseitem{
                float: left;
                width: 100%;
                border: 1px solid;
                padding: 5px;
            }
            .recentcoursespopup .courseitem .itemicon{
                float: left;
                width: 10%;
            }
            .recentcoursespopup .courseitem .itemname{
                float: left;
                width: 70%;
            }
            .recentcoursespopup .courseitem .itemname h5,
            .recentcoursespopup .courseitem .itemname p{
                margin: 0;
            }
            .recentcoursespopup .courseitem .lastvisit{
                float: left;
                width: 20%;
            }
            .recentcoursespopup .courseitem .lastvisit p{
                margin: 0;
            }
            .recentcoursespopup .courseitem .lastvisit span{
                color: #f37254;
            }
        </style>
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
                                            <span>Learning Path</span>
                                            <h3><a data-toggle="modal" data-target="#myModal" href="javascript:voi(0);">${path.name}</a></h3>
                                            <p>${path.description}</p>
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
                                            <span>Course</span>
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
                                            <span>Learning Path</span>
                                             <h3><a data-toggle="modal" data-target="#myModal" href="javascript:voi(0);">${lpath.name}</a></h3> 
											
                                            <p>${lpath.description}</p>
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
												<img src="images/play1.png">
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
