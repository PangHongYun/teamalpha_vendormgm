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
<title>Vendor Certificate</title>
</head>
<%@ page import="java.util.*, com.cognizant.domain.*"%>

<%
	VendorCertification cert = (VendorCertification) session.getAttribute("cert");
%>
<body>
	<h1 align="center">Create/Edit Certificate</h1>
	<div class="col-xs-4">
		<div class="well">
			<form:form id="tenderForm" method="post"
				action="certCreationProcess" modelAttribute="cert">
				<div class="form-group">
					<div class="form-group">
						<label for="certificate_name" class="control-label">Certification Name: </label>
						<form:input path="certificate_name" name="certificate_name"
							id="certificate_name" cssClass="form-control" required="required"
							placeholder="Certificate Name"
							title="Please enter a certificate name" />
					</div>
					<!-- company name -->
					<div class="form-group">
						<div class="form-group">
							<label for="certificate_path" class="control-label">Upload Certificate Path: </label>
							<form:input path="certificate_path" name="certificate_path"
								id="certificate_path" cssClass="form-control" required="required"/>
							<form:input type="hidden" path="vendor_Id" id="vendor_Id"
								cssClass="form-control" required="required" value='<%=( (Vendor)session.getAttribute("vendor")).getId()%>' />
							<form:input type="hidden" path="id" name="id"
							id="id" cssClass="form-control" required="required" />
						</div>

				<!--register button -->
				<button type="submit" class="btn btn-success btn-block">Upload Certificate Details</button>
				<!--Cancel button -->
				<button type="cancel" class="btn btn-danger btn-block">Cancel</button>
			</form:form>

		</div>
	</div>
</body>
</html>

<script>
	 $(function() {
  $("#datetimepicker8").datepicker({
    dateFormat: 'yy-MM-dd'
  });});

	</script>