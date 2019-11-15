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
                                <a href="learnerHome"><h1>Codecademy</h1></a>
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


            


            <div class="otherblank">
                <img class="blogimg" src="images/Blog.jpg">
            </div>


            <div class="col-md-12">
                

                <div class="onlinecourses">
                    <div class="tab-content">
                        

                        <div id="mycourses">
                            <div class="courselisting">
                                <div class="col-md-12">
                                    
                                    <label>Courses for ${path.name}</label> 
                                    <c:forEach  items="${path.courses}" var="course">
                                    <div class="col-md-4">
                                        <div class="item">
                                            <div class="itemicon">
												<img src="images/online_course.png">
											</div>
                                            <h3><a href="javascript:showModules('${course.id}');">${course.courseName}</a></h3>
                                          
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
			
			
                    </div>
                    <div class="modal-footer" style="margin-top: 10px;float: left;width: 100%;">
		    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
		
		<div class="footer">
            <div class="col-md-12 text-center">
                <p>Copyright © 2018 IIHT. All Rights Reserved Privacy Policy For Enterprise Solutions</p>
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