<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<h1 align="center">Create a new Employee</h1>
	<div class="col-xs-4">
		<div class="well">
			<form:form id="createEmp" method="post" action="empRegProcess"
				modelAttribute="employee">
				<!-- company name -->
				<div class="form-group">
					<div class="form-group">
						<label for="companyName" class="control-label">Company
							Name </label><span class="mandatory">*</span>
						<form:input path="company_name" name="companyName"
							id="companyName" cssClass="form-control" required="required" />
					</div>
					<!-- Employee Name -->
					<div class="form-group">
						<label for="empName" class="control-label">Name </label><span
							class="mandatory">*</span>
						<form:input path="employeeName" name="empName" id="empName"
							cssClass="form-control" required="required" />
					</div>
					<!-- Employee Email -->
					<div class="form-group">
						<label for="empName" class="control-label">Email </label><span
							class="mandatory">*</span>
						<form:input path="employeeEmail" id="employeeEmail"
							cssClass="form-control" required="required" disabled="true" />
						<form:input type="hidden" path="employeeEmail" id="employeeEmail"
							cssClass="form-control" required="required"/>
					</div>
					<!-- employee contact number -->
					<div class="form-group">
						<label for="companyContactNo" class="control-label">Contact
							Number (Office) </label><span class="mandatory">*</span>
						<form:input path="employeeContactNumber" name="empContactNo"
							id="empContactNo" cssClass="form-control" required="required" />
					</div>
					<!-- employee department -->
					<div class="form-group">
						<label for="companyName" class="control-label">Department
						</label><span class="mandatory">*</span>
						<form:input path="employeeDepartment" name="empDept" id="empDept"
							cssClass="form-control" required="required" />
					</div>
					<!--create new employee button -->
					<button type="submit" class="btn btn-success btn-block">Register
						a New Employee</button>
					<!--Cancel button -->
					<button type="cancel" class="btn btn-danger btn-block">Cancel</button>
			</form:form>
		</div>
	</div>
</body>
</html>