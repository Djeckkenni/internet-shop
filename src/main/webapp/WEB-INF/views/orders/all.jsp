<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h1>All orders:</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>User id</th>
        <th>User name</th>
        <th>Details</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                <c:out value="${order.orderId}"/>
            </td>
            <td>
                <c:out value="${order.user.userId}"/>
            </td>
            <td>
                <c:out value="${order.user.userName}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/order?id=${order.orderId}">
                    details
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/order/delete?id=${order.orderId}">Delete</a>
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
