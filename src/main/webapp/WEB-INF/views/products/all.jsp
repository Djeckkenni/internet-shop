<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
        html,
        body {
            background-image: url("https://wallbox.ru/resize/2560x1600/wallpapers/main2/201721/odezda-vesalka.jpg");
            -moz-background-size: 100% 100%;
            -webkit-background-size: 100% 100%;
            -o-background-size: 100% 100%;
            background-size: 100% 100%;
        }

        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            font-size: 14px;
            text-align: center;
            width: 80%;
            table-layout: auto;
            margin: auto;
        }

        th {
            background: #616a78;
            color: #f5f5f5;
            padding: 10px 20px;
        }

        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }

        td {
            padding: 10px 20px;
            background: #e5e5e5;
        }

        h1 {
            border: 200px;
            font-family: Verdana, Arial, Helvetica, sans-serif;
        }

        .a {
            color: whitesmoke;
        }

        .a:hover {
            color: whitesmoke;
        }
    </style>
</head>
<body>
<h1 align="center">All products page</h1>
<table>
    <thead>
    <tr>
        <th align="center">ID</th>
        <th align="center">NAME</th>
        <th align="center">PRICE</th>
        <th align="center">ADD</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <th scope="row">
                <c:out value="${product.productId}"/>
            </th>
            <td>
                <c:out value="${product.productName}"/>
            </td>
            <td>
                <c:out value="${product.productPrice}"/>
            </td>
            <td>
                <button type="button" class="btn btn-secondary btn-sm">
                    <a href="/addtocart?id=${product.productId}" class="a">add to bucket</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<button type="button" class="btn btn-secondary btn-sm"><a href="${pageContext.request.contextPath}/" class="a">Go to the
    main page</a></button>
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
