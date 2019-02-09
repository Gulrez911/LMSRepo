<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.assessment.data.*, java.text.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IIHT</title>
<link href='http://fonts.googleapis.com/css?family=Roboto:300,400,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Muli:300,400,700'
	rel='stylesheet' type='text/css'>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="css/responsive.css" rel="stylesheet" type="text/css">
<link href="css/font-awesome_new.css" rel="stylesheet" type="text/css">
<link href="css/style_new.css" rel="stylesheet" type="text/css">
<link href="css/responsive_new.css" rel="stylesheet" type="text/css">
<link href="css/style_testjourney.css" rel="stylesheet" type="text/css">
<link href="css/pnotify.custom.min.css" rel="stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="scripts/custom.js"></script>
<script type="text/javascript" src="scripts/pnotify.custom.min.js"></script>
<script type="text/javascript" src="scripts/html2canvas.js"></script>
<script src="scripts/src-min-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>



<script type="text/javascript">
		var active = 'true';
		var studentNameTaken = localStorage.getItem('${studentTestForm.firstName}${studentTestForm.lastName}');
		var testNameTaken = localStorage.getItem('testName-${studentTestForm.firstName}${studentTestForm.lastName}');
		var tc= localStorage.getItem('timeCounter-${studentTestForm.firstName}${studentTestForm.lastName}');
			
			
			if(studentNameTaken == 'yes' && testNameTaken == '${studentTestForm.firstName}${studentTestForm.lastName}-${studentTestForm.testName}'  && tc != null){
			timeCounter=tc;
			}
			else{
				timeCounter = 0;
			}
			
			if(tc == null){
				timeCounter= 0;
			}
			
		function setTimeOnLoad(){
		timeProcess();
		}	
		
		function timeProcess(){
		timeCounter = parseInt(timeCounter) + 1;
		var end = new Date();
		var hours =  (${studentTestForm.duration}/60) % 60;
		var minutes = (${studentTestForm.duration}) % 60;
		var seconds = (${studentTestForm.duration} * 60) % 60;
		
		end.setMinutes(minutes);
		end.setHours(hours);
		end.setSeconds(seconds);
		
		var start = new Date();
		start.setMinutes((timeCounter/60) % 60);
		start.setHours((timeCounter/(60*60)) % 60);
		start.setSeconds(timeCounter % 60);
		
		var t = Date.parse(end) - Date.parse(start);
		seconds = Math.floor( (t/1000) % 60 );
		minutes = Math.floor( (t/1000/60) % 60 );
		hours = Math.floor( (t/(1000*60*60)) % 24 );
		
		 if (hours   < 10) {hours   = "0"+hours;}
		 
		  if (minutes < 10) {minutes = "0"+minutes;}
		  
		   if (seconds < 10) {seconds = "0"+seconds;}
		
		//document.getElementById("examTimer").innerHTML = hours+":"+minutes+":"+seconds;
		document.getElementById("hours").innerHTML = hours;
		document.getElementById("min").innerHTML = minutes;
		document.getElementById("sec").innerHTML = seconds;
			
		}
		 	
		var submitTest = 'false';
		
		function examTimer(){
			if(submitTest == 'true'){
				return;
			}
			timeProcess();
		
			if((${studentTestForm.duration} * 60) - timeCounter <= 3 ){
				notify('Info', 'Test Time exceeding shortly! Your test will be auto submitted');
			}		
				
			if( timeCounter >= (${studentTestForm.duration} * 60)  ){
			submitTest();
			}
		}
		
		function takeScreenShot(){
			if(active == 'false'){
				notify('Info', 'The exam window looks to be in the background. This is a non-compliance. We are recording it in our system. If number of non-'+

	'compliances exceed a threshold, the Test Admin may mark this attempt as void. Please beware! ');
				var datasend="user=${studentTestForm.emailId}\ntestName=${studentTestForm.testName}\ncompanyId=${studentTestForm.companyId}";
				$.ajax({
				    type: "POST",
				    url: "registerNonCompliance",
				    data: { 
					data:datasend
				    }
				}).done(function(fileName) {
					alert("done");

				}); 
			}
			else if(active == 'true'){
				this.window.focus();
				 html2canvas(document.querySelector("#screenShotId"), {
				logging: true,
				allowTaint: true
			    }).then(function(canvas) {
				var dataImage = canvas.toDataURL("image/png");
				$.ajax({
				    type: "POST",
				    url: "uploadScreenSnapShot?testName=${studentTestForm.testName}",
				    data: { 
					data:dataImage
				    }
				}).done(function(fileName) {
					alert("done");

				}); 
			    });
			}
		
		
		}
		
		function activeScreen(){
		active = 'true';
		//alert(' active ' +active);
		}
		
		function passiveScreen(){
		active = 'false';
		//alert(' passicve ' +active);
		}
		window.addEventListener('focus', activeScreen);
		window.addEventListener('blur', passiveScreen);

		
		var myVar = setInterval(examTimer, 1000);
		var myVar2 = setInterval(takeScreenShot, 45000);
		
		</script>
		
		<style>
		body * { font-family: monospace !important }
		</style>
</head>
<body onload="setTimeOnLoad()">



	<form:form id="testForm" name="testForm" method="POST"
		modelAttribute="currentQuestion">
		<div class="header">
			<div class="col-md-12">
				<div class="col-md-6">
					<div class="logo">
						<a href="#"><img src="images/logoiiht.png"></a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="userheader">
						<div class="userinfo">
							<h4>
								Welcome ${studentTestForm.userName}<span>${studentTestForm.emailId}</span>
							</h4>
							<img src="images/userimg.png">
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="testheader"  id="screenShotId">
			<div class="testinfo">
				<div class="testimg">
					<img src="images/testimage.png">
				</div>
				<div class="testname">
					<h3>${studentTestForm.testName}</h3>
					<span>Assessment</span>
				</div>
			</div>
			<div class="durationinfo">
				<span><i class="fa fa-clock-o">
				<span class="time" id="timer"><i id="hours"></i><sub>h</sub><i id="min"></i><sub> min</sub><i id="sec"></i> <sub> sec</sub></span> </i>
				   <!-- <c:choose>
						 <c:when test="${currentSection.last==true}">
						<span class="finish"><a href="javascript:submitTest();"><i></i>END</a></span>
						 </c:when>    
				    <c:otherwise>
				   		 <span class="finish">
						<a href="javascript:next();"><iclass="fa fa-flag-checkered"></i>FINISH</a></span>
				    </c:otherwise>
						</c:choose>
						-->
			</div>
		</div>


		<div class="examquestions">
			<div class="menuitem">
				<ul>
				<c:forEach var="sectionInstance" varStatus="status"
					items="${sectionInstanceDtos}">
					<li ${sectionInstance.style}
						onclick="javascript:changeSection('${sectionInstance.section.sectionName}');">

						<a>${sectionInstance.section.sectionName}</a></li>

				</c:forEach>
				</ul>
			</div>
			
			<c:choose>
					    <c:when test="${currentQuestion.questionMapperInstance.questionMapper.question.type=='MCQ' || currentQuestion.questionMapperInstance.questionMapper.question.type ==null}">
						
						<div class="queanscenter" id="section1_content">
							<div class="queprogress">
								<span style="float: left; width: 100%;">${noAnswered} of ${totalQuestions} answered</span>
								<div class="progressing">
									<span style="width: ${percentage}%;"></span>
								</div>
								<span class="quepercent">${percentage}%</span>
							</div>

							<div class="questionname">
								<div class="verticalline"></div>
								<div class="queno">
									<span>${currentQuestion.position}</span>
								</div>
								<h3 class="qname">${currentQuestion.questionMapperInstance.questionMapper.question.questionText}</h3>

								<div class="answers">
									<ul>
										<li
											style="${currentQuestion.questionMapperInstance.questionMapper.question.choice1 == null || 

			currentQuestion.questionMapperInstance.questionMapper.question.choice1.trim().length() == 0? 'display: none;':'clear:left; font-size: 14px;'}">

											<form:checkbox path="one" />
											${currentQuestion.questionMapperInstance.questionMapper.question.choice1}
										</li>
										<li
											style="${currentQuestion.questionMapperInstance.questionMapper.question.choice2 == null || 

			currentQuestion.questionMapperInstance.questionMapper.question.choice2.trim().length() == 0? 'display: none;':'clear:left;font-size: 14px;'}">

											<form:checkbox path="two" />
											${currentQuestion.questionMapperInstance.questionMapper.question.choice2}
										</li>
										<li
											style="${currentQuestion.questionMapperInstance.questionMapper.question.choice3 == null || 

			currentQuestion.questionMapperInstance.questionMapper.question.choice3.trim().length() == 0? 'display: none;':'clear:left;font-size: 14px;'}">
											<form:checkbox path="three" />
											${currentQuestion.questionMapperInstance.questionMapper.question.choice3}
										</li>

										<li
											style="${currentQuestion.questionMapperInstance.questionMapper.question.choice4 == null || 

			currentQuestion.questionMapperInstance.questionMapper.question.choice4.trim().length() == 0? 'display: none;':'clear:left;font-size: 14px;'}">
											<form:checkbox path="four" />
											${currentQuestion.questionMapperInstance.questionMapper.question.choice4}
										</li>
										<li
											style="${currentQuestion.questionMapperInstance.questionMapper.question.choice5 == null || 

			currentQuestion.questionMapperInstance.questionMapper.question.choice5.trim().length() == 0? 'display: none;':'clear:left;font-size: 14px;'}">
											<form:checkbox path="five" />
											${currentQuestion.questionMapperInstance.questionMapper.question.choice5}
										</li>
										<li
											style="${currentQuestion.questionMapperInstance.questionMapper.question.choice6 == null || 

			currentQuestion.questionMapperInstance.questionMapper.question.choice6.trim().length() == 0? 'display: none;':'clear:left;font-size: 14px;'}">
											<form:checkbox path="six" />
											${currentQuestion.questionMapperInstance.questionMapper.question.choice6}
										</li>
									</ul>
								</div>

								

							</div>
						
					    </c:when>    
					    <c:when test="${currentQuestion.questionMapperInstance.questionMapper.question.type=='CODING'}">
						
						
						<!--Code for coding Q -->
						<div class="queanscenter" id="section2_content" >

						<div class="col-md-12">
						    <div class="col-md-7 leftside">
							<b>Java</b>
							<a class="runcode" href="javascript:runCodeSystemTestCase();">Run System Test Case  </a>
							<a class="runcode" href="javascript:runCode();">Run Code</a>
							<label>Code</label>
							
							<form:textarea id="editor" path="code"/>
							<form:hidden path="code" id="codeOfEditor"/>
							   
							
							
							

							<label>Input</label>
							 <form:textarea path="input"  style="height:30px" id="input" placeholder="Enter input"/>

							<label>Output</label>
							<form:textarea  style="overflow-y: scroll" path="output"   id="output" disabled="true"/>
						    </div>
						    <div class="col-md-5 rightside">
							<div class="description">
							    <label>DESCRIPTION</label>
							    <p>${currentQuestion.questionMapperInstance.questionMapper.question.questionText}</p>
							    <code>
								Update code in Code Editor 
							    </code>
							    <p>${currentQuestion.questionMapperInstance.questionMapper.question.instructionsIfAny}</p>
							    <h4>Constraint</h4>
							    <p>${currentQuestion.questionMapperInstance.questionMapper.question.constrnt}</p>

							    <h4>Input</h4>
							    <code>
								${currentQuestion.questionMapperInstance.questionMapper.question.hiddenInputPositive}
							    </code>

							    <h4>Output</h4>
							    <code>
								${currentQuestion.questionMapperInstance.questionMapper.question.hiddenOutputPositive}
							    </code>
							   
							</div>
						    </div>
						</div>

					    </div>

						
					    </c:when>   
					</c:choose>
			
			

				

			</div>


			<!-- <div class="flagdiv">
				<a href="#"><i class="fa fa-flag-checkered"></i>FLAG</a>
			</div> -->

		</div>
		
		
            <div class="flagdiv">
                <a href="#"><i class="fa fa-flag-checkered"></i>FLAG</a>
            </div>

        </div>
		
		<!--  End code for coding Q-->


		<div class="backprevbtn">
			
			<div class="center">
				<c:choose>
					<c:when test="${currentSection.first==true}">
					</c:when>
					<c:otherwise>
						<a class="back" href="javascript:prev();">Back</a>
						<!-- <i class="fa fa-long-arrow-left"></i> -->
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${currentSection.last==true}">
					
					<a class="next" href="javascript:submitTest();" id="next">SUBMIT TEST</a>
					</c:when>
					<c:otherwise>
						<a class="next" href="javascript:next();" id="next">Next</a>
						<!-- <i class="fa fa-long-arrow-right"></i>-->
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	<div class="logincopyright">
		<div class="col-md-12">
			<p>Copyrigh Â© 2018 IIHT. All Rights Reserved â Privacy Policy
				For enterprise solutions</p>
		</div>
	</div>

	<!-- <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script> -->

	<!-- <script>
			$(document).ready(function(){
				$('.questionname .answers input').change(function(){
					$('.backprevbtn .center a.next').show();
					$('li.highlight').removeClass('highlight');
					$(this).closest('li').addClass('highlight');
				});
			});
		</script> -->
		
	<script>
	    var editor = ace.edit("editor");
	    editor.setTheme("ace/theme/solarized_light");
	   //editor.setTheme("ace/theme/theme-github");
	    editor.session.setMode("ace/mode/java");
		console.log('code is ${currentQuestion.code}');
		editor.setValue('${currentQuestion.code}');
	    editor.setOptions({
	   enableBasicAutocompletion: true, // the editor completes the statement when you hit Ctrl + Space
	   enableLiveAutocompletion: true, // the editor completes the statement while you are typing
	   showPrintMargin: false, // hides the vertical limiting strip
	   maxLines: Infinity,
	   fontSize: "100%" // ensures that the editor fits in the environment
	});

	</script>

	<style>
	
	.ace_editor div {
	    font: inherit!important
	}
	
	  #editor {
	    height: 400px;
	    width: 100%;
	    color: #000;
	   margin: 0;
       
	    }
	    
    #editor {
	    font-family:monospace
	}
		
	.ace_editor {
	    font-family:monospace!important
	}
	
	editor.container.style.fontFamily = "monospace";
	</style>
		
<script>
	function changeSection(sectionName){
		window.location = 'changeSection?sectionName='+sectionName+"&timeCounter="+timeCounter;
		localStorage.setItem('timeCounter', timeCounter);
	}
	
	function runCode(){
	//editor
	//var editor = ace.edit("editor");
	var code = editor.getValue();
	var input = document.getElementById('input').value;
	var lang = '8';
	var url = 'compile';
	var data = {}; 
	data.language = lang;
	data.code = code;
	data.stdin = input;
	//var json = "{language:"+lang+", code:"+code+", stdin:"+input+"}";
	document.getElementById('output').value = 'Executing your code...';	
	document.getElementById("output").focus();
	document.getElementById("output").scrollIntoView();
	dta = JSON.stringify(data);
	//dta = dta.slice(1,-1);
	//dat = "'"+dta+"'";
		$.ajax({
				type : 'POST',
				url : url,
				contentType: "application/json; charset=utf-8",
				data: dta,
				success : function(data) {
					
					document.getElementById('output').value = data;
					//document.getElementById('output').value = 'eee';
					console.log("SUCCESS: ", data);
				},
				error : function(e) {
					console.log("ERROR: ", e);
					
				}
			});
	}
	
	function runCodeSystemTestCase(){
		//var editor = ace.edit("editor");
	var code = editor.getValue();
	var input = '${currentQuestion.questionMapperInstance.questionMapper.question.hiddenInputPositive}';
	document.getElementById('input').value = input;
	var lang = '8';
	var url = 'compileAndRunSystemTest';
	
	var data = {}; 
	data.language = lang;
	data.code = code;
	data.stdin = input;
	document.getElementById('output').value = 'Executing your code...';	
	document.getElementById("output").focus();
	document.getElementById("output").scrollIntoView();
	dta = JSON.stringify(data);
	
		$.ajax({
				type : 'POST',
				url : url,
				contentType: "application/json; charset=utf-8",
				data: dta,
				success : function(data) {
					console.log("SUCCESS: ", data);
					//document.getElementById('output').value = data;
					if(data == '${currentQuestion.questionMapperInstance.questionMapper.question.hiddenOutputPositive}'){
						document.getElementById('output').value = (data + '\n' +'SUCCESS');
					}
					else{
					document.getElementById('output').value = (data + '\n' +'FAILED');
					}
					
				},
				error : function(e) {
					console.log("ERROR: ", e);
					
				}
			});
	}
	
	function next(){
	var qType = '${currentQuestion.questionMapperInstance.questionMapper.question.type}';
	if(qType == 'CODING'){
		var textarea = document.getElementById('codeOfEditor');
 		edt = editor.getSession().getValue();
		textarea.value = edt;
	}
 
//edt.value = editor.getSession().getValue();
	var linktext=document.getElementById('next').text;
		if(linktext == 'Finish Test'){
		submitTest();
		}
		else{
		document.testForm.action = "nextQuestion?questionId=${currentQuestion.questionMapperInstance.questionMapper.id}&timeCounter="+timeCounter;
		storeTimeLocal();
	 document.testForm.submit();
		}
	
	}
	
	function prev(){
	var qType = '${currentQuestion.questionMapperInstance.questionMapper.question.type}';
	if(qType == 'CODING'){
		var textarea = document.getElementById('codeOfEditor');
 		edt = editor.getSession().getValue();
		textarea.value = edt;
	}
	var textarea = document.getElementById('codeOfEditor');
 	edt = editor.getSession().getValue();
	textarea.value = edt;
	document.testForm.action = "prevQuestion?questionId=${currentQuestion.questionMapperInstance.questionMapper.id}&timeCounter="+timeCounter;
	storeTimeLocal();
	document.testForm.submit();
	}
	
	function submitTest(){
	var qType = '${currentQuestion.questionMapperInstance.questionMapper.question.type}';
	if(qType == 'CODING'){
		var textarea = document.getElementById('codeOfEditor');
 		edt = editor.getSession().getValue();
		textarea.value = edt;
	}
	var textarea = document.getElementById('codeOfEditor');
 	edt = editor.getSession().getValue();
	textarea.value = edt;
	document.testForm.action = "submitTest?questionId=${currentQuestion.questionMapperInstance.questionMapper.id}&timeCounter="+timeCounter;
	resetTimeLocal();
	//modal.style.display = "block";
	//document.getElementById("showAlert").innerHTML = 'You have exceeded your time limit to complete the test. The test will auto submit in a moment...';
	document.testForm.submit();
	submitTest = 'true';
	
	}
	
	function storeTimeLocal(){
	localStorage.setItem('${studentTestForm.firstName}${studentTestForm.lastName}', 'yes');
	localStorage.setItem('testName-${studentTestForm.firstName}${studentTestForm.lastName}', '${studentTestForm.firstName}${studentTestForm.lastName}-'+

'${studentTestForm.testName}');
	localStorage.setItem('timeCounter-${studentTestForm.firstName}${studentTestForm.lastName}', timeCounter);
	}
	
	function resetTimeLocal(){
	localStorage.setItem('${studentTestForm.firstName}${studentTestForm.lastName}', 'no');
	localStorage.setItem('testName-${studentTestForm.firstName}${studentTestForm.lastName}', null);
	localStorage.setItem('timeCounter-${studentTestForm.firstName}${studentTestForm.lastName}', 0);
	}
	

	</script>
	
	<!-- The Modal -->
	<div id="myModal" class="modal">

	  <!-- Modal content -->
	  <div class="modal-content">
	    <span class="close">&times;</span>
	    <p id="showAlert">Some text in the Modal..</p>
	  </div>

	</div>
	
	<script>
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
			
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		    modal.style.display = "none";
		}	
		
		function notify(messageType, message){
		 var notification = 'Information';
			 $(function(){
				 new PNotify({
				 title: notification,
				 text: message,
				 type: messageType,
				 styling: 'bootstrap3',
				 hide: false
			     });
			 }); 	
		}


		$(document).ready(function () {
    			//Disable cut copy paste
    			$('body').bind('cut copy paste', function (e) {
        			e.preventDefault();
    			});
   
    			//Disable mouse right click
    			$("body").on("contextmenu",function(e){
       				return false;
    			});
		});
	</script>
</body>
</html>
