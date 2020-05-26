<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
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

        .footer {
            position: fixed;
            left: 42%;
            bottom: 0;
            width: content-box;
            height: 60px;
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
<h1 align="center">All orders</h1>
<table>
    <thead>
    <tr>
        <th align="center">ID</th>
        <th align="center">USER ID</th>
        <th align="center">DETAILS</th>
        <th align="center">DELETE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <th>
                <c:out value="${order.orderId}"/>
            </th>
            <td>
                <c:out value="${order.userId}"/>
            </td>
            <td>
                <button type="button" class="btn btn-secondary btn-sm">
                    <a href="${pageContext.request.contextPath}/order?id=${order.orderId}" class="a">details</a>
                </button>
            </td>
            <td>
                <button type="button" class="btn btn-secondary btn-sm">
                    <a href="${pageContext.request.contextPath}/order/delete?id=${order.orderId}" class="a">delete</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="footer">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a>
            </li>
            <li class="breadcrumb-item active" aria-current="${pageContext.request.contextPath}/orders/all">
                Orders all
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
