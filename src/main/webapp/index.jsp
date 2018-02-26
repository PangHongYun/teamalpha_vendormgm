<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Hello World!</h2>

<%= java.util.Calendar.getInstance().getTime() %>

<a href="hello">click here</a>

 <li><a href="<c:url value="/treecensus/viewtreename" />" ><spring:message code="label.treename" /></a></li>

</body>
</html>
