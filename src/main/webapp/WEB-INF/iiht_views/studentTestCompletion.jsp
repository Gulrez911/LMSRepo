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
		<script type="text/javascript" src="scripts/FileSaver.js"></script>
		<script type="text/javascript" src="scripts/dom-to-image.min.js"></script>
	
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
                width: 80%;
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
			
			.wrapper, .row {
				height: 50%;
				margin-left: 0;
				margin-right: 0;
			}
			
			.container {
				width: 1400px;
			}
        </style>

<div class="completetest" >

	<div class="container" id="dom">
                <div class="testinformation">
                    <div class="text-center">
                        <img src="images/process_complete.png">
                        <h1 style="color: #7ac142;text-align: center;margin-top: 0;font-weight: bold;">${studentTestForm.firstName} ${studentTestForm.lastName} - You have completed the test</h1>
                    </div>
                    <h3 style="text-align: center;">Your completed the test in ${studentTestForm.noOfAttempts == null || studentTestForm.noOfAttempts.trim().length() == 0?"1":studentTestForm.noOfAttempts} ${studentTestForm.noOfAttempts == null || studentTestForm.noOfAttempts.trim().length() == 0?"attempt":"attempts"}</h3>
                    <h3 style="text-align: center;padding-bottom: 20px;">Your results have been shared by email to the Test Administrator - ${studentTestForm.testCreatedBy}</h3>
	
	
	
			<c:if test="${showResults}">
					<div class="row">

                        <div class="resultinformation">
                            <h3><i class="fa fa-bar-chart-o"></i> Result</h3>
                        </div>
                        <div class="col-md-5 text-center">
                            <img style="width: 250px;" src="images/result.png">
                        </div>
                        <div class="col-md-4">
                            <ul>
                                <li><b>Total Questions</b> : ${TOTAL_QUESTIONS}</li>
                                <li><b>Total Marks</b> : ${TOTAL_MARKS}</li>
                                <li><b>Pass Percentage</b> : ${PASS_PERCENTAGE}</li>
                                <li><b>Result Percentage</b> : ${RESULT_PERCENTAGE}</li>
                                <li><b>Status</b> : ${STATUS}</li>
                            </ul>
                        </div>
                        <div class="col-md-3">
                            <div class="c100 p${RESULT_PERCENTAGE_WITHOUT_FRACTION}">
                                <span>${TOTAL_MARKS}/${TOTAL_QUESTIONS}</span>
                                <div class="slice">
                                    <div class="bar"></div>
                                    <div class="fill"></div>
                                </div>
                            </div>
                        </div>
                    </div>
		
		 <h3 style="font-weight: bold;background-color: rgb(0,108,255);padding: 10px;color: #fff;margin-bottom: 0;">Topic Wise Performance - See below</h3>
					<table class="table" style="border: 1px solid #dddddd;">
                        <thead>
                            <tr>
                                <th>Section Name</th>
                                <th>Percentage Got</th>
                            </tr>
                        </thead>
						<tbody>
                        ${rows}
						</tbody>
                    </table>
		 
					<c:forEach var="ins" items="${codingInstances}"> 
					<div class="questionslist">
                        <p>
                           ${ins.questionMapper.question.questionText}
                        </p>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Compilation Errors</th>
                                    <th>Runtime Errors</th>
                                    <th>Basic Test Case 1</th>
                                    <th>* Basic Test Case 2</th>
                                    <th>Test Case (Minimal Value)</th>
                                    <th>Test Case (High Value)</th>
                                    <th>Test Case (Invalid Data)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="${ins.codeCompilationErrors == true? "color:red":"color:green"}">${ins.codeCompilationErrors == true?"YES":"NO"}</td>
                                    <td class="${ins.codeRunTimeErrors == true? "color:red":"color:green"}">${ins.codeRunTimeErrors == true?"YES":"NO"}</td>
                                    <td class="${ins.testCaseInputPositive == true? "color:green":"color:red"}">${ins.testCaseInputPositive == true?"YES":"NO"}</td>
                                    <td class="${ins.testCaseInputNegative == true? "color:green":"color:red"}">${ins.testCaseInputNegative == true?"YES":"NO"}</td>
                                    <td class="${ins.testCaseMinimalValue == true? "color:green":"color:red"}">${ins.testCaseMinimalValue == true?"YES":"NO"}</td>
                                    <td class="${ins.testCaseMaximumValue == true? "color:green":"color:red"}">${ins.testCaseMaximumValue == true?"YES":"NO"}</td>
                                    <td class="${ins.testCaseInvalidData == true? "color:green":"color:red"}">${ins.testCaseInvalidData == true?"YES":"NO"}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
					</c:forEach>
		 
						
				</div>
            </div>
			
			<div class="container">
			<div class="text-center">
                        <input type="button" value="Download" onclick="javascript:download()" />
                    </div>
			</div>
			
       
					
				
		
	   
	
	
	
		</c:if>
		
	</div>
	
   


    
	<script>
		function download(){
			domtoimage.toBlob(document.getElementById('dom'))
			.then(function (blob) {
				//var FileSaver = require('file-saver');
				//window.saveAs(blob, 'image.png');
				console.log('blob is '+blob);
				saveAs(blob, "image.png");
			});
		}
		</script>

</body>
</html>