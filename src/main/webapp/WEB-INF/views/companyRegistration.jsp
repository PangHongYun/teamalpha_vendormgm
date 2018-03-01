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
<%@ page import="java.util.*, com.cognizant.domain.*"%>
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
	<h1 align="cente">Company Registration Page</h1>
	<div class="col-xs-4">
		<div class="well">
			<form:form id="comRegisterForm" method="post"
				action="companyRegProcess" modelAttribute="company">
				<!-- company reg no -->
				<div class="form-group">
					<label for="companyRegistrationNumber" class="control-label">Company
						Registration Number: </label>
					<form:input path="companyRegistrationNumber"
						name="companyRegistrationNumber" id="companyRegistrationNumber"
						cssClass="form-control" required="required"
						placeholder="company Reg. No"
						title="Please enter a valid registration number" />
				</div>
				<!-- company name -->
				<div class="form-group">
					<label for="companyName" class="control-label">Company Name</label>
					<form:input path="companyName" name="companyName" id="companyName"
						cssClass="form-control" required="required" disabled="true"
						title="Please enter your company name" />
					<form:input type="hidden" path="companyName" name="companyName" id="companyName"
						cssClass="form-control" required="required"	title="Please enter your company name" />
				</div>
				<!-- company location Address -->
				<div class="form-group">
					<label for="companyName" class="control-label">Company
						Location Address</label>
					<form:input path="companyAddress" name="companyName"
						id="companyAddress" cssClass="form-control" required="required"
						placeholder="company Location Address"
						title="Please enter your company location address" />
				</div>
				<!-- company email -->
				<div class="form-group">
					<label for="companyEmail" class="control-label">Company
						Email Address:</label>
					<form:input path="companyEmail" name="companyEmail"
						id="companyEmail" cssClass="form-control" required="required"
						placeholder="company Email" title="P" />
				</div>
				<!--error popup for invalid email address -->
				<div id="invalidEmailErrorMsg" class="alert alert-error hide">Invalid
					Email address entered</div>
				<!--notification preference dropdown list--->
				<!-- company contact number -->
				<div class="form-group">
					<label for="companyContactNumber" class="control-label">Company
						Contact Number (Office) </label>
					<form:input path="companyContactNumber" name="companyContactNumber"
						id="companyContactNumber" cssClass="form-control"
						required="required" placeholder="company Contact Number" />
				</div>
				<!-- employee id -->
				<div class="form-group">
					<input type="hidden" name="empId" cssClass="form-control" value='<%=( (Employee)session.getAttribute("employee")).getId()%>'/>
				</div>
				<!--error popup for invalid email address -->
				<div id="invalidContactNoErrorMsg" class="alert alert-error hide">Invalid
					contact number entered, must be a 8-digit number</div>
				<!--register button -->
				<button type="submit" class="btn btn-success btn-block">Register
					a New company</button>
				<!--Cancel button -->
				<button type="cancel" class="btn btn-danger btn-block">Cancel</button>
		</div>
	</div>
	</form:form>
</body>
</html>