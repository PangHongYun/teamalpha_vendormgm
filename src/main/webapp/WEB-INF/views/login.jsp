<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html>

<head>
<title>Login to Report Server</title>  



<link href="${pageContext.request.contextPath}/resources/bootstrap.min.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/resources/twenty20.min.css" rel="stylesheet" >

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
	
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" > </link>


</head>  

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<body>
    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel">Login to MyCompManager.com</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-6">
                      <div class="well">
                          <form id="loginForm" method="post" action="loginProcess"  modelAttribute="login">
                              <div class="form-group">
                                  <label for="username" class="control-label">Username</label>
                                 <!--  <input type="text" class="form-control" id="username" name="username" value="" required="" title="Please enter you username" placeholder="example@gmail.com"> -->
                                  <form:input path="login.acc_email" name="username" id="username" cssClass="form-control" required="true"/>
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="password" class="control-label">Password</label>
                                 <!--  <input type="password" class="form-control" id="password" name="password" value="" required="" title="Please enter your password"> -->
                                 <form:password path="login.acc_password" name="password" id="password" />
                                  <span class="help-block"></span>
                              </div>
                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username or password</div>
                              <div class="checkbox">
                                  <label>
                                      <input type="checkbox" name="remember" id="remember"> Remember login
                                  </label>
                                  <p class="help-block">(if this is a private computer)</p>
                              </div>
                              <button type="submit" class="btn btn-success btn-block">Login</button>
                              <a href="/forgot/" class="btn btn-default btn-block">Help to login</a>
                          </form>
                      </div>
                  </div>
                  <div class="col-xs-6">
                      <p class="lead">Register now for <span class="text-success">FREE</span></p>
                      <ul class="list-unstyled" style="line-height: 2">
                          <li><span class="fa fa-check text-success"></span> Set Up Vendor Processes</li>
                          <li><span class="fa fa-check text-success"></span> Efficient Tendering</li>
                          <li><span class="fa fa-check text-success"></span> Company Management on the Cloud</li>
                          <li><span class="fa fa-check text-success"></span> APIs for Backoffice</li>
                          <li><span class="fa fa-check text-success"></span> Vendor Ratings <small>(Choose the right one)</small></li>
                         <li><a href="${pageContext.request.contextPath}/static/readMe.html"><u>Read more</u></a></li>
                      </ul>
                      <p><a href="/registration" class="btn btn-info btn-block">Yes please, register now!</a></p>
                  </div>
              </div>
          </div>
      </div>
  </div>
  </body>
</html>  