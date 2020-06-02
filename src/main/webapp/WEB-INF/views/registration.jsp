<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
            max-width: 1000px;
            padding: 15px;
            margin: auto;
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registration">
    <div>
        <h4 class="display-4">Hello! Please provide your user details</h4>
        <hr class="my-4">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Please provide your name:</label>
            <input type="text" name="name" class="form-control" id="inputEmail4" placeholder="Enter your name" required
                   value="<%=(request.getParameter("name") != null) ? request.getParameter("name") : ""%>">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Please provide your login:</label>
            <input type="text" name="login" class="form-control" id="inputPassword4" placeholder="Enter your login"
                   required value="<%=(request.getParameter("login") != null) ? request.getParameter("login") : ""%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress"> Please provide your password:</label>
        <input type="password" name="pwd" class="form-control" id="inputAddress" placeholder="Enter your password"
               required>
        <small id="loginHelp" style="color: #ff0000">${message}</small>
    </div>
    <div class="form-group">
        <label for="inputAddress2">Please repeat your password:</label>
        <input type="password" name="pwd-repeat" class="form-control" id="inputAddress2"
               placeholder="Repeat your password" required>
    </div>
    <button type="submit" class="btn btn-primary btn-lg btn-block">Registration</button>
</form>
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
