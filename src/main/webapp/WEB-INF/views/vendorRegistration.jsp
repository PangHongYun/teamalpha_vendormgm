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
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
<body>
	<h1 align="center">Vendor Registration Page</h1>
	<div class="col-xs-4">
		<div class="well">
			<form:form id="vendorRegisterForm" method="post"
				action="vendorRegistrationProcess" modelAttribute="vendor">
				<!-- vendor reg no -->
				<div class="form-group">
					<label for="vendorRegistrationNumber" class="control-label">Vendor
						Registration Number </label><span class="mandatory">*</span>
					<form:input path="vendorRegistrationNumber"
						name="vendorRegistrationNumber" id="vendorRegistrationNumber"
						cssClass="form-control" required="required"
						placeholder="Vendor Reg. No"
						title="Please enter a valid registration number" />
				</div>
				<!-- vendor name -->
				<div class="form-group">
					<label for="vendorName" class="control-label">Vendor Name</label><span
						class="mandatory">*</span>
					<form:input path="vendorName" name="vendorName" id="vendorName"
						cssClass="form-control" required="required" />
				</div>
				<!-- vendor location Address -->
				<div class="form-group">
					<label for="vendorName" class="control-label">Vendor
						Location Address</label>
					<form:input path="vendorAddress" name="vendorAddress"
						id="vendorAddress" cssClass="form-control" required="required"
						placeholder="Vendor Location Address"
						title="Please enter your vendor location address" />
				</div>
				<!-- vendor email -->
				<div class="form-group">
					<label for="vendorEmail" class="control-label">Vendor Email
						Address</label><span class="mandatory">*</span>
					<form:input path="vendorEmail" name="vendorEmail" id="vendorEmail"
						cssClass="form-control" required="required" title="P" disabled="true" />
						<form:input type="hidden" path="vendorEmail" name="vendorEmail" id="vendorEmail"
						cssClass="form-control" required="required" title="P" />
				</div>
				<!--error popup for invalid email address -->
				<div id="invalidEmailErrorMsg" class="alert alert-error hide">Invalid
					Email address entered</div>
				<!-- 				notification preference dropdown list- -->
				<!-- 				<div class="form-group"> -->
				<!-- 					<label for="vendorNotification" class="control-label">Vendor -->
				<!-- 						Notification Preference</label><span class="mandatory">*</span> <label -->
				<!-- 						class="radio-inline"><input type="radio" name="optradio">Email</label> -->
				<!-- 					<label class="radio-inline"><input type="radio" -->
				<!-- 						name="optradio">SMS</label> -->
				<%-- 					<form:input path="vendor.noticePreference" name="noticePreference" --%>
				<%-- 						id="noticePreference" cssClass="form-control" required="required" /> --%>
				<!-- 				</div> -->
				<!-- vendor contact number -->
				<div class="form-group">
					<label for="vendorContactNo" class="control-label">Vendor
						Contact Number (Office) </label><span class="mandatory">*</span>
					<form:input path="vendorContactNumber" name="vendorContactNumber"
						id="vendorContactNumber" cssClass="form-control"
						required="required" />
				</div>
				<!--register button -->
				<button type="submit" class="btn btn-success btn-block">Register
					a New Vendor</button>
				<!--Cancel button -->
				<button type="cancel" class="btn btn-danger btn-block">Cancel</button>
			</form:form>
		</div>
	</div>

</body>
</html>