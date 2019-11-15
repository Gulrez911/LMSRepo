<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Learning Path</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IIHT</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
<!-- <link href="css/style.css" rel="stylesheet" type="text/css"> -->
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
<style>
body {
	background-color: #fff;
	height: auto;
}

.mylearningpath {
	float: left;
	width: 100%;
	padding-top: 30px;
}

.mylearningpath h3 {
	text-align: center;
	color: #3e75f9;
	font-weight: bold;
}

.mylearningpath form {
	float: left;
	width: 100%;
}

.mylearningpath form label {
	float: left;
	width: 100%;
	padding-top: 15px;
}

.mylearningpath form input[type='text'] {
	float: left;
	width: 100%;
	border: 1px solid #727780;
	padding: 10px;
}

.mylearningpath form input[type="submit"] {
	width: auto;
	background-color: #3e75f9;
	padding: 15px 40px;
	margin-top: 15px;
	border: none;
	color: #fff;
	font-weight: bold;
}

.mylearningpath form select {
	float: left;
	width: 100%;
}

.courselist {
	float: left;
	width: 100%;
	height: 200px;
	overflow-y: scroll;
	border: 1px solid #727780;
	padding: 10px;
}

.courselist input[type="checkbox"] {
	margin: 0;
	position: relative;
	top: 5px;
	margin-right: 5px;
}

.courselist label {
	padding-top: 0 !important;
}
</style>
<body>
	<div class="mylearningpath">
		<div class="container">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h3>My Learning Path</h3>
				<form:form action="saveLearningPath" method="post"
					modelAttribute="learningPath">
					<label>Name</label>
					<form:input path="name" />
					<label>Description</label>
					<form:input path="description" />
					<label>Image URL</label>
					<form:input path="imageUrl" />
					<label>Search label</label>
					<form:input path="searchLabel" />
					<label>Technology</label>
					<form:input path="technology" />
					<label>Course</label>
					<input type="text" placeholder="Search Course" id="course">
					<div class="courselist">
												<form:checkboxes items="${listCourse}" itemLabel="courseName"
						  							itemValue="courseName" path="course" />
					</div>
					<input type="submit" value="SAVE">
				</form:form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<script type="text/javascript">
		$(":checkbox").each(
				function() {
					$(this).add(this.nextSibling).add(
							this.nextSibling.nextSibling).wrapAll(
							"<label class='course'></label>")
				})
		$("#course").keyup(function() {
			var re = new RegExp($(this).val(), "i")
			$('.course').each(function() {
				var text = $(this).text(), matches = !!text.match(re);
				$(this).toggle(matches)
			})
		})
	</script>
</body>
</html>