<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
        html,
        body {
            height: 100%;
        }

        body {
            display: -ms-flexbox;
            display: flex;
            -ms-flex-align: center;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        form {
            width: 100%;
            max-width: 500px;
            padding: 15px;
            margin: auto;
        }

        .footer {
            position: fixed;
            left: 41%;
            bottom: 0;
            width: content-box;
            height: 60px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/users/login" method="post">
    <div>
        <h1 class="display-4">Login page</h1>
        <hr class="my-4">
    </div>
    <div class="form-group">
        <label for="exampleInputLogin">Please provide your login:</label>
        <input type="text" class="form-control" name="login" placeholder="Enter your login" id="exampleInputLogin"
               aria-describedby="loginHelp" required
               value="<%=(request.getParameter("login") != null) ? request.getParameter("login") : ""%>">
        <small id="loginHelp" style="color: red">${errorMsg}</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Please provide your password:</label>
        <input type="password" class="form-control" name="pwd" id="exampleInputPassword1"
               placeholder="Enter your password" required>
    </div>
    <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
</form>
<div class="footer">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/registration">Registration page</a>
            </li>
            <li class="breadcrumb-item active" aria-current="${pageContext.request.contextPath}/users/login">Login
                page
            </li>
        </ol>
    </nav>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
