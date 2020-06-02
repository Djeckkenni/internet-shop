<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
        html,
        body {
            height: 100%;
            background-color: #f5f5f5;
        }

        .header {
            overflow: hidden;
            background-image: url("https://i.pinimg.com/originals/cc/0e/3d/cc0e3dbd54aaf1301535e50065924961.jpg");
            height: 100px;
            color: whitesmoke;
        }

        .footer {
            position: fixed;
            left: 40%;
            bottom: 0;
            width: content-box;
            height: 60px;
        }

        .div {
            margin-left: 25px;
            margin-top: 25px;
        }

        .a {
            color: black;
        }
    </style>
</head>
<body>
<header class="header">
    <h2>Welcome! ${time}</h2>
</header>
<div class="div">
    <p><a href="${pageContext.request.contextPath}/products/all" class="a">Get all products from DB</a></p>
    <p><a href="${pageContext.request.contextPath}/products/all" class="a">Add product to the bucket</a></p>
    <p><a href="${pageContext.request.contextPath}/cart" class="a">Watch the bucket</a></p>
    <p><a href="${pageContext.request.contextPath}/orders/all" class="a">Watch all orders</a></p>
    <p><a href="${pageContext.request.contextPath}/users/all" class="a">Get all users from DB <span
            class="badge badge-warning">admin</span></a>
    </p>
    <p><a href="${pageContext.request.contextPath}/users/all" class="a">Delete user from DB <span
            class="badge badge-warning">admin</span></a>
    </p>
    <p><a href="${pageContext.request.contextPath}/products/admin" class="a">Watch all products <span
            class="badge badge-warning">admin</span></a>
    </p>
</div>
<div class="div">
    <a href="${pageContext.request.contextPath}/injectUser">Please,
        inject test admin and test user to data base.
        <span
                class="badge badge-success">TEST ADMIN
        </span>
    </a>
</div>
<div class="footer">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/registration">Registration</a>
            </li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/users/login">Login</a>
            </li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>
            <li class="breadcrumb-item active" aria-current="${pageContext.request.contextPath}/">Home
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
