<%@ page contentType="text/html;charset=euc-kr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>userInfo</title>
</head>
<body>
<h1>
	User!  
</h1>

<P>  User is ${user.id} ${user.name} ${user.level} ${user.login} ${user.recommend}. </P>
</body>
</html>

