<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.assessment.data.*, java.text.*, java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IIHT</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/responsive.css" rel="stylesheet" type="text/css">
<link href="css/pnotify.custom.min.css" rel="stylesheet" type="text/css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/pnotify.custom.min.js"></script>
<script type="text/javascript" src="scripts/custom.js"></script>

<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div class="maincontainer">

		<div class="wrapper">
			<div class="row row-offcanvas row-offcanvas-left">
				<!-- sidebar -->
				<%
					User user = (User) request.getSession().getAttribute("user");
					System.out.println("user is " + user.getEmail());
					if (user == null) {
						response.sendRedirect("login");
					}

					if (user.getUserType().getType().equals("LMS_ADMIN")) {

						System.out.println("LMS_ADMIN true");
				%>
				<jsp:include page="side_lms_admin.jsp" />
				<%
					} else {
				%>
				<jsp:include page="side.jsp" />
				<%
					}
				%>

				<!-- /sidebar -->

				<div class="column col-sm-10 col-xs-11" id="main">
					<div class="rightside">
						<div class="topmenu text-right">
							<a class="add_test" href="addLearningPath">Add New</a> <a
								href="javascript:showFileDialog();" id="uploadTest">Import</a> <a
								href="signoff">Sign Off</a>
						</div>
						<div class="questiontable">
							<div class="questionheading">
								<div class="left">
									<h3>Learning Path</h3>
								</div>
								<div class="right">
									<div class="searchdata">

										<input type="text" placeholder="Search a Test"
											name="searchText" id="searchText"> <i
											class="fa fa-search" id="search"></i>
									</div>
									<div class="filter">
										<a
											href="javascript:notify('Information', 'Feature coming soon')"><img
											src="images/ic_sort.png">Sort</a> <a
											href="javascript:notify('Information', 'Feature coming soon')"><img
											src="images/ic_filter.png">Filter</a>
									</div>
								</div>
							</div>
							<div class="questiontablelist" style="overflow-x: auto;">
								<table class="table">
									<thead>
										<tr>
											<th><input type="checkbox"></th>
											<th><img src="images/icon-selectionmode.png">Name</th>

											<th>Description</th>
											<th>Image URL</th>
											<th>Search Label</th>
											<th>Technology</th>
											<th>No of Enrollmet</th>
										</tr>
									</thead>
									<tbody>
									<tbody>

										<c:forEach items="${list}" var="li">
											<tr>
												<td><input type="checkbox"></td>
												<td>${li.name}</td>
												<td>${li.description}</td>
												<td>${li.imageUrl}</td>
												<td>${li.searchLabel}</td>
												<td>${li.technology}</td>
												<td>${li.noOfEnrollments}</td>

											</tr>
										</c:forEach>
									</tbody>

									</tbody>
								</table>
							</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
						</div>
					</div>
				</div>
				<!-- /main -->
			</div>
		</div>
	</div>
	 
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
