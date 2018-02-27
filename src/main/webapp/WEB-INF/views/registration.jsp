<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<title>Login to Report Server</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap.min.css"
	rel="stylesheet">
	<link
		href="${pageContext.request.contextPath}/resources/twenty20.min.css"
		rel="stylesheet">

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
			integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
			crossorigin="anonymous"></script>

		<link
			href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
			rel="stylesheet"></link>
</head>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script>
			function validateChangePassword(){
		  		var password1 = $('#password1').val();
		  		var password2 = $('#password2').val();
				if(password1!= password2) {
					alert("password confirmations dont match, please re-enter a new password");
					password1.focus();
				}
				else{
					document.getElementById("regForm").submit();
				}
			}
			</script>
		<body>
			<h1 align="center">Create a new Account</h1>
			<div class="col-xs-4">
				<div class="well">
					<form id="regForm" method="post" action="registrationProcess"
						modelAttribute="createTender">

						<!-- Account Email -->
						<div class="form-group">
							<label for="acc_email" class="control-label">Account
								Email:</label>
							<form:input path="registration.acc_email" name="acc_email"
								id="acc_email" cssClass="form-control"
								title="Please enter your company name" required="true"
								placeholder="Email" />
						</div>


						<!-- Account Type -->
						<div class="form-group">
							<label for="acc_type" class="control-label">Account Type:
							</label>

							<form:select path="registration.acc_type" name="acc_type"
								id="acc_type"
								cssClass="form-control btn btn-default dropdown-toggle"
								required="true">
								<form:option label="Vendor" value="1" />
								<form:option label="Employee" value="2" />
							</form:select>
						</div>

						<!-- account password-->
						<div class="form-group">
							<label for="password" class="control-label">Password</label>
							<input type="password" class="form-control" id="password1" name="password1" value=""
								required="true" placeholder="Password"
								title="Please enter your password" />
							<span class="help-block"></span>
						</div>

						<!-- re-confirm password -->
						<div class="form-group">
							<label for="confirmPassword" class="control-label">Re-Confirm
								Password:</label>
							<form:password path="registration.acc_password"
								cssClass="form-control" id="password2" name="password2" value=""
								required="true" placeholder="Re-Enter Password"
								title="Please enter your password" />
							<span class="help-block"></span>
						</div>

						<span class="spinner"><i class="icon-spin icon-refresh"></i></span>
						<button type="button" class="btn btn-success btn-block"
							onclick="validateChangePassword()">Create a new Account</button>

						<!--Cancel button -->
						<button type="cancel" class="btn btn-danger btn-block">Cancel</button>


					</form>
				</div>
			</div>

		</body>
</html>
