<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h1>Order</h1>
<p>
    Order id: <c:out value="${order.orderId}"/>,
    Buyer id: <c:out value="${order.userId}"/>
</p>
<h3>Order list</h3>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${order.products}">
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
        <a href="${pageContext.request.contextPath}/orders/all">Go to the all orders page</a>
    </button>
</p>
</body>
</html>
