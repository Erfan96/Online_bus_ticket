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
    <title>صفحه ورود</title>
</head>
<body>
<form action="login" method="post">
    <label>نام کاربری :
        <input name="userName" type="text" placeholder="نام کاربری را وارد کنید" required>
    </label><br>
    <label>رمز عبور :
        <input name="password" type="password" placeholder="رمز عبور را وارد کنید" required>
    </label><br>
<input type="submit" value="ورود">
</form>
</body>
</html>
