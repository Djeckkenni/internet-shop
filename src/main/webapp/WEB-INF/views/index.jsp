<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mate Academy!</title>
</head>
<body>
<h1>Hello mates!</h1> <h4>Current time is ${time}</h4>
<p>
    <a href="${pageContext.request.contextPath}/registration">Registration</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/injectUser">Inject test Data into the DB</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/users/all">Get all users from test DB</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/users/all">Delete user from test DB</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/injectProduct">Inject test Product into the DB</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/products/all">Get all products from test DB</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/products/all">Add product to the shoppingCart</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/shoppingCart/all">Watch the shoppingCart</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/orders/all">Watch the all orders</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/products/admin">Watch the all products (admin page)</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</p>
</body>
</html>
