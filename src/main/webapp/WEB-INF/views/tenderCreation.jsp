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
<title>Create a new Tender Project</title>
</head>
<%@ page import="java.util.*, com.cognizant.domain.*"%>

<%
	Tender tender = (Tender) session.getAttribute("tender");
%>
<body>
	<h1 align="center">Create a new Tender Project</h1>
	<div class="col-xs-4">
		<div class="well">
			<form:form id="tenderForm" method="post"
				action="tenderCreationProcess" modelAttribute="tender">
				<div class="form-group">
					<div class="form-group">
						<label for="projId" class="control-label">Project Name: </label>
						<form:input path="Project_Name" name="Project_Name"
							id="Project_Name" cssClass="form-control" required="required"
							placeholder="Project Name"
							title="Please enter a tender project name" />
					</div>
					<!-- company name -->
					<div class="form-group">
						<div class="form-group">
							<label for="companyName" class="control-label">Company
								Name: </label>
							<form:input path="createdBy" name="companyName"
								id="companyName" cssClass="form-control" disabled="true" />
							<form:input type="hidden" path="Project_Dept" id="Project_Dept"
								cssClass="form-control" required="required" value="${tender.project_Dept}" />
							<form:input type="hidden" path="Project_Incharge"
								id="Project_Incharge" cssClass="form-control"
								required="required" value="${tender.project_Incharge}" />
							<form:input type="hidden" path="id" name="id"
							id="id" cssClass="form-control" required="required" />
						</div>

						<!-- Tender Project Description -->

						<div class="form-group">
							<div class="form-group">
								<label for="companyName" class="control-label">Tender
									Project Description: (max. 250 characters)</label>
								<form:textarea path="Project_Description"
									name="Project_Description" id="Project_Description"
									cssClass="form-control" required="required" rows="5" cols="50" placeholder="Tender Project Description" title="Please enter tender project details" />
							</div>

							<div class="form-group">
								<div class="form-group">
									<label for="companyName" class="control-label">Tender
										Project Expiry Date: </label>
									<div class="input-group date">
										<input type="text" class="form-control" id="projExpiry"
											name="projExpiry" value="" required="required"
											placeholder="Tender Project Expiry"
											title="Please enter a valid expiry date ">
										<div class="input-group-addon">
											<span class="glyphicon-calendar glyphicon"></span>
										</div>
									</div>
									<%-- 											<form:input path="tender.description" name="description" --%>
									<%-- 												id="description" cssClass="form-control" required="required" /> --%>
								</div>
								<!-- employee id -->
				<div class="form-group">
					<input type="hidden" name="empId" cssClass="form-control" value='<%=( (Employee)session.getAttribute("employee")).getId()%>'/>
				</div>
				<!--register button -->
				<button type="submit" class="btn btn-success btn-block">Create Tender</button>
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