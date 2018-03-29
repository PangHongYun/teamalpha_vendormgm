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
<title>Change Password</title>
</head>
<%@ page import="java.util.*, com.cognizant.domain.*"%>

<%
	Account account = (Account) session.getAttribute("account");
%>

<script>
	function validateChangePassword() {
		var originalPassword = $('#password').val();
		var oldPassword = $('#oldPassword').val();
		var newPassword = $('#newPassword').val();
		var confirmNewPassword = $('#confirmNewPassword').val();
		if (originalPassword==oldPassword) {
			if (newPassword==confirmNewPassword) {
				alert("Password is changed.");
				document.getElementById("passwordForm").submit();
			} else {
				alert("New password confirmation failure.");
				newPassword.focus();
			}
		} else {
			alert("Old password is wrong.");
			oldPassword.focus();
		}
	}
</script>
<body>
	<h1 align="center">Change Password</h1>
	<div class="col-xs-4">
		<div class="well">
			<form id="passwordForm" method="post" action="changePasswordProcess">
				<div class="form-group">
					<div class="form-group">
						<label for="oldPW" class="control-label">Old Password: </label>
						<input type="hidden" id="password" class="form-control" required="required"
							value="${account.acc_password}" />
						<input name="oldPassword" type="password" id="oldPassword" class="form-control" required="required"
							placeholder="Enter old password" title="Enter old password" />
					</div>
					<div class="form-group">
						<div class="form-group">
							<label for="newPW" class="control-label">New Password: </label>
							<input name="newPassword" type="password" id="newPassword" class="form-control" required="required"
							placeholder="Enter new password" title="Enter new password"/>
							<input type="hidden" value="${account.id}" name="userId" class="form-control" required="required" />
						</div>

						<div class="form-group">
							<div class="form-group">
								<label for="newPW2" class="control-label">Confirm New
									Password: </label>
								<input name="confirmNewPassword" type="password" id="confirmNewPassword" class="form-control" required="required"
							placeholder="Confirm new password" title="Confirm new password"/>
							</div>
							<!--register button -->
							<button type="button" class="btn btn-success btn-block"
								onclick="validateChangePassword()">Change Password</button>
							<!--Cancel button -->
							<button type="cancel" class="btn btn-danger btn-block">Cancel</button>
			</form>

		</div>
	</div>
</body>
</html>