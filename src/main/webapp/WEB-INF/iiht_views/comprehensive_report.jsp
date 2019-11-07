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
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="scripts/pnotify.custom.min.js"></script>
	<script type="text/javascript" src="scripts/custom.js"></script>
	
	 <link href="css/font-awesome.css" rel="stylesheet" type="text/css">

        <style>
            body{
                background-color: #01052C;
                height: auto;
            }
            .reportstablediv{
                float: left;
                width: 100%;
                padding-bottom: 30px;
            }
            .reporttabledata .title{
                color: #fff;
                float: left;
                width: 100%;
            }
            .reporttabledata .tagline{
                color: #fff;
            }
            .reporttabledata table {
                float: left;
                width: 100%;
                margin-bottom: 30px;
            }
            .reporttabledata table tr {
                border-bottom: 1px solid;
            }
            .reporttabledata table th, 
            .reporttabledata table tr th {
                font-size: 18px;
                font-weight: normal;
            }
            .reporttabledata table th {
                background-color: #282f3d;
                padding: 10px 10px;
                opacity: 0.8;
                font-size: 16px;
                color: #FFFFFF;
                font-weight: bold;
            }
            .reporttabledata table td {
                padding: 10px 10px;
                font-size: 15px;
                color: #FFFFFF;
            }
        </style>
    </head>
    <body>
        <div class="reportstablediv">
            <div class="col-md-12">
                <div class="reporttabledata ">
                    <h3 class="title">Detailed Assessment Report</h3>
                    <h4 class="tagline">${courseContext}</h4>
                    <table class="table-responsive">
                        <tr>
                            
                            <th style="width: 30%;">Course Topics</th>
                            <th style="width: 12%;">Topic Level Score (%)</th>
                            <th style="width: 40%;">Further recommendations</th>
                        </tr>
						
						<c:forEach  items="${mcqTraits}" var="mcq" >  
                        <tr>
                            <td> ${mcq.traitSpecifics}</td>
                            <td>${mcq.percent}</td>
                           
                            <td>
                               ${mcq.description}
                            </td>
                        </tr>
                        </c:forEach>   
                    </table>
                    
                    <c:if test = "${fullstackTraitsPresent != null && fullstackTraitsPresent == true}">
                    <h3 class="title">Behaviour Compliance</h3>
                    <table class="table-responsive">
                        <tr>
                            <th style="width: 33%;">Topic</th>
                            <th style="width: 33%;">No Of Test Cases</th>
                            <th style="width: 33%;">Behaviour Compliance %</th>
                        </tr>
						<c:forEach  items="${fullstackTraits}" var="fullstack" >  
                        <tr>
                            <td>${fullstack.problemDesc}</td>
                            <td>${fullstack.noOfTestCases}</td>
                            <td>${fullstack.percent}</td>
                        </tr>
                       </c:forEach>
                    </table>
                    </c:if>
                    
					
					<c:if test = "${fullstackTraitsPresent != null && fullstackTraitsPresent == true}">
                    <h3 class="title">Code Metrics %</h3>
                    <table class="table-responsive">
                        <tr>
                            <th>Syntax Awareness</th>
                            <th>Basic Code Integrity</th>
                            <th>Code Validations</th>
                            <th>Code withstand Low inputs</th>
                            <th>Code withstand High inputs</th>
                            <th>Production Grade</th>
                        </tr>
                        <tr>
                            <td>${codingTraits.syntaxAwarenessPercent}</td>
                            <td>${codingTraits.codeIntegrityPercent}</td>
                            <td>${codingTraits.codeValidationsPercent}</td>
                            <td>${codingTraits.lowInputPercent}</td>
                            <td>${codingTraits.highInputPercent}</td>
                            <td>${codingTraits.productionGradePercent}</td>
                        </tr>
                    </table>
                    </c:if>
                    
                    <table class="table-responsive">
                        <tr>
                            <td>Overall Score</td>
                            <td>43%</td>
                        </tr>
                        <tr>
                            <td>Hands On Quotient</td>
                            <td>50%</td>
                        </tr>
                        <tr>
                            <td>Knowledge score</td>
                            <td>30%</td>
                        </tr>
                        <tr>
                            <td>Normal Score - </td>
                            <td>(30 x 12 + 50 x 17) /(12 + 17) </td>
                        </tr>
                        <tr>
                            <td>Weighted Score</td>
                            <td>(30 x 1 + 50 x 2) / (1 + 2)</td>
                        </tr>
                    </table>
                    
                </div>
            </div>
        </div>

        

    </body>
</html>
