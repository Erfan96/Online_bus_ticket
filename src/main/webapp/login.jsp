<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/23/2021
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Enter</title>
</head>
<body>
<form action="login" method="post">
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
