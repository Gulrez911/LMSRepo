<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Course</title>
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
<style>
body {
	background-color: #fff;
	height: auto;
}

.addmodulecourse {
	float: left;
	width: 100%;
	padding-top: 30px;
}

.addmodulecourse .heading {
	float: left;
	width: 100%;
	font-weight: bold;
	margin-bottom: 0;
	padding-bottom: 20px;
}

.addmodulecourse .heading a {
	float: right;
	background-color: #3e75f9;
	font-size: 15px;
	color: #fff;
	padding: 10px 30px;
	text-decoration: none;
}

.addmodulecourse table a {
	padding: 0 5px;
	font-size: 20px;
	color: #3e75f9;
}

.modal h3 {
	margin-top: 0;
}

.modal label {
	float: left;
	width: 100%;
	padding-top: 15px;
}

.modal input[type="text"], .modal textarea, .modal select {
	float: left;
	width: 100%;
	border: 1px solid #727780;
	padding: 10px;
	background-color: #fff;
}

.modal-footer {
	display: inline-block;
	margin-top: 20px;
	width: 100%;
}

.modal input[type="submit"] {
	width: auto;
	background-color: #3e75f9;
	padding: 15px 40px;
	margin-top: 15px;
	border: none;
	color: #fff;
	font-weight: bold;
	float: right;
	font-size: 15px;
}

.courselist {
	float: left;
	width: 100%;
	height: 150px;
	overflow-y: scroll;
	border: 1px solid #727780;
	padding: 10px;
}

.courselist input[type="radio"] {
	margin: 0;
	position: relative;
	top: 5px;
	margin-right: 5px;
}

.courselist label {
	padding-top: 0 !important;
}

.example {
	/* 	font-style: italic; */
	background-color: #C7C7C7;
	font-family: Georgia, serif;
	/* 	font-weight: bold; */
	/* 	color: blue; */
}
</style>
</head>
<body>

	<div class="addmodulecourse">
		<div class="container">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<h3 class="heading">
					Module <a  href="javascript:resetModule();"><i class="fa fa-plus"></i> Add</a>
				</h3>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Module Name</th>
							<th scope="col">Duration</th>
							<th scope="col">Description</th>
							<th scope="col">Content Link</th>
							<th scope="col">Test Name</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCourseModules }" var="module">
							<tr>
								<td>${module.moduleName}</td>
								<td>${module.duration}</td>
								<td>${module.moduleDesc}</td>
								<td>${module.contentLink}</td>
								<td>${module.testName}</td>
								<td width="12%"><a href="#"
									onclick="editCourseModule('${module.moduleName}','${module.duration}','${module.moduleDesc}','${module.contentLink}','${module.testName}')"><i
										class="fa fa-edit"></i></a> <a
									href="javascript:deleteCourseModule(${module.id})"><i
										class="fa fa-trash-o"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>


			<div class="col-md-12 col-sm-12 col-xs-12">
				<h3 class="heading">
					Course
					<!-- 					 <a data-toggle="modal" data-target="#modal_course" -->
					<!-- 						href="javascript:voi(0);"><i class="fa fa-plus"></i> Add</a> -->
					<a href="javascript:resetForm();"><i class="fa fa-plus"></i>
						Add</a>
				</h3>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Course Name</th>
							<th scope="col">Type</th>
							<th scope="col">Description</th>
							<!-- 							<th scope="col">Image URL</th> -->
							<th scope="col">Search Label</th>
							<th scope="col">Technology</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody id="tbodyclass">
						<c:forEach items="${listCourse}" var="course">
							<%-- <tr class="select${course.id}" onclick="called(this.id)" id="${course.courseName}"> --%>
							<tr class="select${course.id}">
								<th width="12%" id="${course.courseName}"
									onclick="called(this.id)">${course.courseName}</th>
								<td width="10%" id="${course.courseName}"
									onclick="called(this.id)">${course.courseType}</td>
								<td width="35%" id="${course.courseName}"
									onclick="called(this.id)">${course.courseDesc}</td>
								<%-- 								<td width="14%" id="${course.courseName}" --%>
								<%-- 									onclick="called(this.id)">${course.imageUrl}</td> --%>
								<td width="12%" id="${course.courseName}"
									onclick="called(this.id)">${course.searchLabel}</td>
								<td width="10%" id="${course.courseName}"
									onclick="called(this.id)">${course.technology}</td>
								<td width="12%"><a href="#"
									onclick="editCourse('${course.courseName}','${course.courseDesc}','${course.imageUrl}','${course.searchLabel}','${course.technology}')"><i
										class="fa fa-edit"></i></a> <a
									href="javascript:deleteCourse(${course.id})"><i
										class="fa fa-trash-o"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>

	<div class="modal fade" id="modal_courseModule">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<h3>Add new module</h3>
					<form:form action="saveCourseModule" method="post"
						modelAttribute="courseModule">
						<form:hidden path="courseId" value="${id}" />
						<label>Module Name</label>
						<form:input path="moduleName" id="mname" />
						<label>Duration</label>
						<form:input path="duration" id="duration" />
						<label>Description</label>
						<form:textarea path="moduleDesc" id="mdesc" />
						<label>Content Link</label>
						<form:input path="contentLink" id="contLink" />
						<label>Course Name</label>
						<form:input path="courseName" value="${cname}" readonly="true"
							required="true" />
						<label>Test</label>
						<%-- 						<form:input path="testName" /> --%>
						<input type="text" placeholder="Search Test" id="test">
						<div class="courselist">
							<div class="item">
								<label class="test"> <form:radiobuttons path="testName"
										items="${testList}" itemLabel="testName" itemValue="testName"
										onclick="setValue(this.value)" id="tname"/>
								</label>
							</div>
						</div>
						<input type="submit" value="SAVE">
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modal_course" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body new">
					<h3>Add new course</h3>
					<form:form action="saveCourse" modelAttribute="course"
						method="post" id="myform">
						<label>Name</label>
						<form:input path="courseName" id="cname" />
						<label>Type</label>
						<select>
							<option value="type1">Type 1</option>
							<option value="type2">Type 2</option>
							<option value="type3">Type 3</option>
						</select>
						<label>Description</label>
						<form:input path="courseDesc" id="cdesc" />
						<label>Image URL</label>
						<form:input path="imageUrl" id="iurl" />
						<label>Search label</label>
						<form:input path="searchLabel" id="slab" />
						<label>Technology</label>
						<form:input path="technology" id="tech" />
						<input type="submit" value="SAVE">
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(":radio").each(
				function() {
					$(this).add(this.nextSibling).add(
							this.nextSibling.nextSibling).wrapAll(
							"<label class='test'></label>")
				})
		$("#test").keyup(function() {
			var re = new RegExp($(this).val(), "i")
			$('.test').each(function() {
				var text = $(this).text(), matches = !!text.match(re);
				$(this).toggle(matches)
			})
		})

		function selectCourse() {
			// 			console.log("called"+id)
			var id = ${id}
			console.log("Id: " + id)
			// 			 $( ".select"+id ).each(function() {
			$(".select" + id).toggleClass("example");
		}

		// 		calling when load
		selectCourse();

		function called(value) {
			console.log("called" + value)
			location.href = "addCourse?courseName=" + value;
		}

		$("#myInput").on(
				"keyup",
				function() {
					var value = $(this).val().toLowerCase();
					$(".tr").filter(
							function() {
								$(this).toggle(
										$(this).text().toLowerCase().indexOf(
												value) > -1)
							});
				});

		function editCourse(name, description, url, label, technology) {
			$("#cname").val(name);
			$("#cname").prop("readonly", true);
			$("#cdesc").val(description)
			$("#iurl").val(url)
			$("#slab").val(label)
			$("#tech").val(technology)
			$("#modal_course").modal();
		}

		function resetForm() {
			$("#cname").val("");
			$("#cname").prop("readonly", false);
			$("#cdesc").val("")
			$("#iurl").val("")
			$("#slab").val("")
			$("#tech").val("")
			$("#modal_course").modal();
		}

// 		function deleteCourse(id) {
// 			console.log("id:>   " + id)
// 			location.href = "deleteCourse?id2=" + id;
// 		}

		function editCourseModule(name, duration, description,content, tname) {
			console.log("called: " + name + ": d" + duration + ": C" + content
					+ ":tname  " + tname+": desc"+description)
			$("#mname").val(name);
			$("#duration").val(duration);
			$("#mdesc").val(description);
			$("#contLink").val(content);
			$("#tname").val(tname);
			$("#modal_courseModule").modal();
// 			$("#manme").val(name);
		}

// 		function deleteCourseModule(id) {
// 			console.log("Delete Called: " + id)
// 			location.href="deleteModule?id2="+id;
// 		}

		function resetModule(){
			$("#mname").val("");
			$("#duration").val("");
			$("#mdesc").val("");
			$("#tname").val("");
			$("#modal_courseModule").modal();
			}
	</script>



</body>
</html>