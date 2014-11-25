<%@ page contentType="text/html;charset=euc-kr"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
	<h1>Welcome!!!</h1> 
	<br/>
	<a href="login">Log in</a>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')">
		<!-- For login user -->
		<form id="logoutForm" action="j_spring_security_logout" method="post">
		</form>
 
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
</sec:authorize>

<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
</body>
</html>