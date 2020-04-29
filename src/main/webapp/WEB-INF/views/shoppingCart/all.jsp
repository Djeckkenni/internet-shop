<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo4</title>
</head>
<body>
<h1>Products in shopping cart</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>
                <c:out value="${product.productId}"/>
            </td>
            <td>
                <c:out value="${product.productName}"/>
            </td>
            <td>
                <c:out value="${product.productPrice}"/>
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
