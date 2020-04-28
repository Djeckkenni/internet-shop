package mate.acadamy.internetshop.controllers;

import java.io.IOException;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String timeValue = LocalTime.now().toString();
        req.setAttribute("time", timeValue);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}


/*<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
<h1>Your bock  data was added to DB</h1>
<a href="${pageContext.request.contextPath}/">Go to the main page</a>
</body>
</html>*/
