<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.assessment.data.*, java.text.*, java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>IIHT</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link href="css/responsive.css" rel="stylesheet" type="text/css">
	<link href="css/pnotify.custom.min.css" rel="stylesheet" type="text/css">
	
	<link href="css/circle.css" rel="stylesheet" type="text/css">
		<script type="scripts/javascript" src="FileSaver.js"></script>
		<script type="scripts/javascript" src="dom-to-image.min.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript" src="scripts/pnotify.custom.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
</script>
		<script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
</script>
    </head>
<!------ Include the above in your HEAD tag ---------->
<body onload="noBack();">

<style>
            .completetest{
                float: left;
                width: 100%;
            }
            .testinformation{
                float: left;
                width: 100%;
                background-color: #e3efff;
                margin-top: 30px;
                margin-bottom: 30px;
                padding: 20px;
            }
            .testinformation ul{
                padding-left: 0px;
            }
            .testinformation li{
                font-size: 18px !important;
                padding-bottom: 10px;
                list-style: none;
            }
            .testinformation p{
                font-size: 18px;
            }
            .testinformation .table{
                background-color: #fff;
                padding: 15px !important;
                border-collapse:inherit;
                font-weight: bold;
            }
            .testinformation .table tbody tr td:first-child{
                color: rgb(0,108,255);
            }
            .testinformation .table td.green{
                color: #7ac142 !important;
            }
            .testinformation .table td.red{
                color: red;
            }
            .pie, .c100 .bar, .c100.p51 .fill, .c100.p52 .fill, .c100.p53 .fill, .c100.p54 .fill, .c100.p55 .fill, .c100.p56 .fill, .c100.p57 .fill, .c100.p58 .fill, .c100.p59 .fill, .c100.p60 .fill, .c100.p61 .fill, .c100.p62 .fill, .c100.p63 .fill, .c100.p64 .fill, .c100.p65 .fill, .c100.p66 .fill, .c100.p67 .fill, .c100.p68 .fill, .c100.p69 .fill, .c100.p70 .fill, .c100.p71 .fill, .c100.p72 .fill, .c100.p73 .fill, .c100.p74 .fill, .c100.p75 .fill, .c100.p76 .fill, .c100.p77 .fill, .c100.p78 .fill, .c100.p79 .fill, .c100.p80 .fill, .c100.p81 .fill, .c100.p82 .fill, .c100.p83 .fill, .c100.p84 .fill, .c100.p85 .fill, .c100.p86 .fill, .c100.p87 .fill, .c100.p88 .fill, .c100.p89 .fill, .c100.p90 .fill, .c100.p91 .fill, .c100.p92 .fill, .c100.p93 .fill, .c100.p94 .fill, .c100.p95 .fill, .c100.p96 .fill, .c100.p97 .fill, .c100.p98 .fill, .c100.p99 .fill, .c100.p100 .fill{
                border: 0.08em solid #7ac142;
            }

            .resultinformation{
                float: left;
                width: 100%;
            }
            .resultinformation h3{
                background-color: rgb(0,108,255);
                padding: 10px;
                color: #fff;
                font-weight: bold;
                margin-bottom: 30px;
            }
            .progress{
                background-color: #cccccc;
            }
            .progress-bar{
                background-color: #7ac142;
            }
            .questionslist{
                float: left;
                width: 100%;
                border: 1px solid #dddddd;
                margin-bottom: 20px;
            }
            .questionslist .table{
                margin-bottom: 0;
            }
            .questionslist .table th{
                padding-top: 0;
                text-align: center;
            }
            .questionslist .table td{
                text-align: center;
            }
            .questionslist p{
                background-color: #006cff;
                padding: 10px;
                color: #fff;
                margin-bottom: 0;
                font-weight: bold;
            }
        </style>

<div class="container">
	
	<div class="jumbotron">
	 <h2 style="color:blue">Thanks ${studentTestForm.firstName} ${studentTestForm.lastName} - You have completed the test</h2>
    <h3>Your completed the test in ${studentTestForm.noOfAttempts == null || studentTestForm.noOfAttempts.trim().length() == 0?"1":studentTestForm.noOfAttempts} ${studentTestForm.noOfAttempts == null || studentTestForm.noOfAttempts.trim().length() == 0?"attempt":"attempts"}</h3>
    <h3>Your results have been shared by email to the Test Administrator - ${studentTestForm.testCreatedBy}</h3>
	
	<c:if test="${showResults}">
		<p style="font-size:17px;line-height:24px;margin:0 0 16px">
                     Total Questions - ${TOTAL_QUESTIONS} <br/>
					 Total  Marks - ${TOTAL_MARKS} <br/>
					 Pass Percentage - ${PASS_PERCENTAGE} <br/>
					 Result Percentage - ${RESULT_PERCENTAGE} <br/>
					 Status - ${STATUS} <br/>
						<c:if test="${confidencePercent != null}">
						Overall Confidence Percentage - ${confidencePercent} <br/>
						</c:if>
					 Topic Wise Performance - See below 
		<table width="100%" style="border-collapse:collapse;border: 1px solid black">
                                          <tbody>
					  <thead>
                                            <tr style="border-collapse:collapse;border: 1px solid black">
						<th style="border: 1px solid black">Section Name</th>
						<th style="border: 1px solid black">Percentage Got </th>
					    </tr>
					    </thead>
			 ${rows}
			 
		  </tbody>
	   </table>
		</p>
		
		
                    
						
						<p style="font-size:17px;line-height:24px;margin:0 0 16px">
						<table width="100%" style="border-collapse:collapse;border: 1px solid black">
                                          <tbody>
					  <thead>
                        <tr style="border-collapse:collapse;border: 1px solid black">
						
						<th style="border: 1px solid black">Compilation Errors </th>
						<th style="border: 1px solid black">Runtime Errors </th>
						<th style="border: 1px solid black">Basic Test Case 1 </th>
						<th style="border: 1px solid black">* Basic Test Case 2 </th>
						<th style="border: 1px solid black">Test Case (Minimal Value) </th>
						<th style="border: 1px solid black">Test Case (High Value) </th>
						<th style="border: 1px solid black">Test Case (Invalid Data) </th>
					    </tr>
					    </thead>
			  <c:forEach var="ins" items="${codingInstances}">   
			  <tr>  
			   <label style="font-size:17px;line-height:24px;margin:0 0 16px"> ${ins.questionMapper.question.questionText}</label>
		<td style="${ins.codeCompilationErrors == true? "color:red":"color:green"}">${ins.codeCompilationErrors == true?"YES":"NO"}</td>  
			  <td style="${ins.codeRunTimeErrors == true? "color:red":"color:green"}">${ins.codeRunTimeErrors == true?"YES":"NO"}</td>  
	<td style="${ins.testCaseInputPositive == true? "color:green":"color:red"}">${ins.testCaseInputPositive == true?"YES":"NO"}</td>  
	<td style="${ins.testCaseInputNegative == true? "color:green":"color:red"}">${ins.testCaseInputNegative == true?"YES":"NO"}</td>  
			   <td style="${ins.testCaseMinimalValue == true? "color:green":"color:red"}">${ins.testCaseMinimalValue == true?"YES":"NO"}</td>  
			   <td style="${ins.testCaseMaximumValue == true? "color:green":"color:red"}">${ins.testCaseMaximumValue == true?"YES":"NO"}</td>  
			   <td style="${ins.testCaseInvalidData == true? "color:green":"color:red"}">${ins.testCaseInvalidData == true?"YES":"NO"}</td>  
			   </tr>  
			  </c:forEach>
			 
		  </tbody>
		  </table>
		</p>
					
				
		
	   
	</div>
	
	
		</c:if>
		
		<c:if test="${justification}">
	<br/><br/>
	<p style="font-size: large"><b> Detailed Answer Summary </b></p>
		    <div class="accordiansections">
		<c:forEach var="section"  items="${sectionInstanceDtos}" >
                    <label>${section.section.sectionName}</label>
				<div class="panel">
					<%
					int count = 1;
					%>
				<c:forEach var="ques" varStatus="status" items="${section.questionInstanceDtos}" >
						<div class="title">
							<span><%= count %></span>
							<p>Question - <br/> ${ques.questionMapperInstance.questionMapper.question.questionText}  </p>
						</div>
                        <div class="options">
                            <ul>
								<li> Your Choice -${ques.questionMapperInstance.userChoices} </li>
								<li><b> Correct Choice -${ques.questionMapperInstance.questionMapper.question.rightChoices} 
<li style="${ques.questionMapperInstance.correct == true? "color:green":"color:red"}"> <i class="${ques.questionMapperInstance.correct == true? "fa fa-check":"fa fa-close"}"></i> ${ques.questionMapperInstance.correct == true? "Correct":"Not Correct"} </b></li>
                                <li><b> ${ques.questionMapperInstance.questionMapper.question.justification}</b></li>
								
                            </ul>
                            
                        </div>
					<%
						count ++;
					%>
				</c:forEach>
		        </div>
		</c:forEach>           
       </div>
   </c:if>
	</div>
	
   
<div class="container">
  <div class="page-header" style="background-color:#DAA300;color:#fff">
    <h3>If you want to try this test again <a href="mailto:jatin.sutaria@thev2technologies.com">Write to Us</a></h3>      
  </div>
  <p>If you want to provide any feedback on the test  <a href="mailto:feedback@iiht.com">Write to Us</a></p>      
   
</div>

    


</body>
</html>