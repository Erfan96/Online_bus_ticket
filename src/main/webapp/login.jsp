<%@ page import="java.lang.reflect.Method" %><%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/23/2021
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int count = 0;

    Cookie[] cookie = request.getCookies();
    for (Cookie value : cookie) {
        if (value.getName().equals("user") || value.getName().equals("pass")) {
            count++;
        }
    }

    if (count >= 2) {
        request.getRequestDispatcher("/login").forward(request, response);
    }
%>
<html>
<head>
    <title>Enter</title>
</head>
<body>
<form action="login" >
    <label> UserName :
        <input name="userName" type="text" placeholder="Enter your username" required>
    </label><br>
    <label>  Password :
        <input name="password" type="password" placeholder="Enter your password" required>
    </label><br>
<input type="submit" value="Login">
</form>
</body>
</html>
