<%--
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
    <link rel="stylesheet" type="text/css" href="login.css" />
</head>
<body>
<div class="container">
<form action="login" >
    <label> UserName :
        <input name="userName" type="text" placeholder="Enter your username" required>
    </label><br>
    <label>  Password :
        <input name="password" type="password" placeholder="Enter your password" required>
    </label><br>
<input id="butt" type="submit" value="Login">
</form>
</div>
</body>
</html>
