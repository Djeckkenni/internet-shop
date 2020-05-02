<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login page</h1>
<h4 style="color:red">${errorMsg}</h4>
<form action="${pageContext.request.contextPath}/users/login" method="post" >
    Please provide your login: <input type="text" name="login" placeholder="Enter your login" required>
    Please provide your password: <input type="password" name="pwd" placeholder="Enter your password" required>
    <button type="submit">Login</button>
</form>
</body>
</html>
