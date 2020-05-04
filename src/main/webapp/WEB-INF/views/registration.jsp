<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Hello! Please provide your user details</h1>
<h4 style="color:red">${message}</h4>
<form method="post" action="${pageContext.request.contextPath}/registration">
    Please provide your login: <input type="text" name="name" placeholder="Enter your name" required value="<%=(request.getParameter("name") != null)
    ? request.getParameter("name") : ""%>">
    Please provide your login: <input type="text" name="login" placeholder="Enter your login" required value="<%=(request.getParameter("login") != null)
    ? request.getParameter("login") : ""%>">
    Please provide your password: <input type="password" name="pwd" placeholder="Enter your password" required>
    Please repeat your password: <input type="password" name="pwd-repeat" placeholder="Repeat your password" required>
    <button type="submit">Register</button>
</form>
</body>
</html>
