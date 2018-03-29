<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<%@ page import="java.util.*, com.cognizant.domain.*"%>

<%
	List<Tender> tenders = (List<Tender>)session.getAttribute("tenders");
%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--Navbar-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<body>
	<!--Navbar-->
	<div class="title-header">
		<h1 align="center">Employee Page View</h1>
	</div>
	<!--end of top header title-->
	<div class="navbar-header" width="auto">
		<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle">Actions<span class="caret"></span></a>
						<ul class=" dropdown-menu">
							<li><a
								href='comEdit?name=<%=((Employee)session.getAttribute("employee")).getCompany_name()%>&id=<%=( (Employee)session.getAttribute("employee")).getId()%>'>Edit
									Company</a></li>
							<li><a href="#">Edit Department^</a></li>
							<li><a
								href='viewTender?id=<%=((Employee)session.getAttribute("employee")).getId()%>'>Show
									Tender</a></li>
							<li><a
								href='tenderCreation?id=<%=((Employee)session.getAttribute("employee")).getId()%>'>Create
									Tender</a></li>
						</ul>
				</ul>
				<ul>
			</div>
			</ul>
			</li>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span>�
						<strong>User</strong> <span
						class="glyphicon glyphicon-chevron-down"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a
							href='passwordChange?id=<%=( (Employee)session.getAttribute("employee")).getId()%>'><button
									type="button" class="btn btn-info btn-medium"
									data-toggle="modal" data-target="#myModal">Change
									Password</button></a> <a
							href='empEdit?id=<%=( (Employee)session.getAttribute("employee")).getId()%>'><button
									type="button" class="btn btn-info btn-medium"
									data-toggle="modal" data-target="#myModal">Edit
									Profile</button></a>
							<button class="btn btn-danger">Logout^</button></li>
					</ul>
		</div>
		</nav>
		<!--  Search bar -->
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2">
					<div class="input-group">
						<div class="input-group-btn search-panel">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<span id="search_concept">Filter by</span> <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#contains">Company Name</a></li>
								<li><a href="#contains">ID</a></li>
								<li><a href="#its_equal">Name</a></li>
								<li><a href="#greather_than"> Person-in-Charge</a></li>
								<li><a href="#less_than"> Department </a></li>
								<li><a href="#all">Expiry Date</a></li>
							</ul>
						</div>
						<input type="hidden" name="search_param" value="all"
							id="search_param"> <input type="text"
							class="form-control" name="x" placeholder="Search term...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<!--tender projects List-->
		<div class="container">
			<div class="row">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Project Name</th>
								<th>Project Creator</th>
								<th>Description</th>
								<th colspan="3">Actions</th>
							</tr>
						</thead>
						<tbody id="vendorsList">
							<c:forEach var="tender" items="${tenders}">
								<tr>
									<td>${tender.project_Name}</td>
									<td>${tender.project_Incharge}</td>
									<td>${tender.project_Description}</td>
									<td><button>View Details</button></td>
									<td><a
										href='tenderEdit?id=<%=((Employee)session.getAttribute("employee")).getId()%>&tenId=${tender.id}'><button>Edit</button></a></td>
									<td><a
										href='tenderDelete?id=<%=((Employee)session.getAttribute("employee")).getId()%>&tenId=${tender.id}'><button>Delete</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-12 text-center">
					<ul class="pagination pagination-lg pager" id="myPager"></ul>
				</div>
			</div>

			<script>
				$(document).ready(
						function(e) {
							$('.search-panel .dropdown-menu').find('a').click(
									function(e) {
										e.preventDefault();
										var param = $(this).attr("href")
												.replace("#", "");
										var concept = $(this).text();
										$('.search-panel span#search_concept')
												.text(concept);
										$('.input-group #search_param').val(
												param);
									});
						});

				$.fn.pageMe = function(opts) {
					var $this = this, defaults = {
						perPage : 7,
						showPrevNext : false,
						hidePageNumbers : false
					}, settings = $.extend(defaults, opts);
					var listElement = $this;
					var perPage = settings.perPage;
					var children = listElement.children();
					var pager = $('.pager');

					if (typeof settings.childSelector != "undefined") {
						children = listElement.find(settings.childSelector);
					}

					if (typeof settings.pagerSelector != "undefined") {
						pager = $(settings.pagerSelector);
					}

					var numItems = children.size();
					var numPages = Math.ceil(numItems / perPage);

					pager.data("curr", 0);
					if (settings.showPrevNext) {
						$('<li><a href="#" class="prev_link">«</a></li>')
								.appendTo(pager);
					}

					var curr = 0;
					while (numPages > curr
							&& (settings.hidePageNumbers == false)) {
						$(
								'<li><a href="#" class="page_link">'
										+ (curr + 1) + '</a></li>').appendTo(
								pager);
						curr++;
					}

					if (settings.showPrevNext) {
						$('<li><a href="#" class="next_link">»</a></li>')
								.appendTo(pager);
					}
					pager.find('.page_link:first').addClass('active');
					pager.find('.prev_link').hide();
					if (numPages <= 1) {
						pager.find('.next_link').hide();
					}
					pager.children().eq(1).addClass("active");
					children.hide();
					children.slice(0, perPage).show();
					pager.find('li .page_link').click(function() {
						var clickedPage = $(this).html().valueOf() - 1;
						goTo(clickedPage, perPage);
						return false;
					});
					pager.find('li .prev_link').click(function() {
						previous();
						return false;
					});
					pager.find('li .next_link').click(function() {
						next();
						return false;
					});

					function previous() {
						var goToPage = parseInt(pager.data("curr")) - 1;
						goTo(goToPage);
					}

					function next() {
						goToPage = parseInt(pager.data("curr")) + 1;
						goTo(goToPage);
					}

					function goTo(page) {
						var startAt = page * perPage, endOn = startAt + perPage;
						children.css('display', 'none').slice(startAt, endOn)
								.show();

						if (page >= 1) {
							pager.find('.prev_link').show();
						}

						else {
							pager.find('.prev_link').hide();
						}

						if (page < (numPages - 1)) {
							pager.find('.next_link').show();
						} else {
							pager.find('.next_link').hide();
						}

						pager.data("curr", page);
						pager.children().removeClass("active");
						pager.children().eq(page + 1).addClass("active");
					}
				};

				$(document).ready(function() {

					$('#vendorsList').pageMe({
						pagerSelector : '#myPager',
						showPrevNext : true,
						hidePageNumbers : false,
						perPage : 4
					});

				});
			</script>
</body>
</html>