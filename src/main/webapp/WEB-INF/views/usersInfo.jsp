<%@ page contentType="text/html;charset=euc-kr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>userInfo</title>
</head>
<body>
<h1>
	Users!  
</h1>

<c:forEach var="user" items="${users}" varStatus="status">
<table border=1>
<tr>
	<td align="center" class="listtd"><c:out value="${status.count}"/></td>
	<td align="center" class="listtd"><c:out value="${user.id}"/></td>
	<td align="left" class="listtd"><c:out value="${user.name}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.email}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.level}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.login}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.recommend}"/> </td>
</tr>
</table>
</c:forEach>
</body>
</html>

