<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Department Name</title>
</head>
<%@ page import="java.util.*, com.cognizant.domain.*"%>

<%

%>
<body>
	<h1 align="center">Edit Department Name</h1>
	<div class="col-xs-4">
		<div class="well">
			<form:form id="departmentForm" method="post"
				action="editDepartmentProcess" modelAttribute="department">
				<div class="form-group">
					<!-- company name -->
					<div class="form-group">
						<div class="form-group">
							<label for="department_name" class="control-label">Department Name: </label>
							<form:input path="dept_name" name="department_name"
								id="department_name" cssClass="form-control"/>
							<form:input type="hidden" path="com_id"
								id="com_id" cssClass="form-control"
								required="required"/>
							<form:input type="hidden" path="id" name="id"
							id="id" cssClass="form-control" required="required" />
						</div>
				
				<!-- employee id -->
				<div class="form-group">
					<input type="hidden" name="empId" cssClass="form-control" 
					value='<%=( (Employee)session.getAttribute("employee")).getId()%>'/>					
					<input type="hidden" name="odName" cssClass="form-control" 
					value='<%=( (String)session.getAttribute("old_dept_name"))%>'/>
				</div>
				
				<!--register button -->
				<button type="submit" class="btn btn-success btn-block">Edit Department Name</button>
				
				<!--Cancel button -->
				<button type="cancel" class="btn btn-danger btn-block">Cancel</button>
			</form:form>

		</div>
	</div>
</body>
</html>