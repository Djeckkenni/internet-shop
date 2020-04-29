<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1>All users page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user.userId}"/>
            </td>
            <td>
                <c:out value="${user.userName}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/users/delete?id=${user.userId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p>
    <button type="button">
        <a href="${pageContext.request.contextPath}/">Go to the main page</a>
    </button>
</p>
</body>
</html>
