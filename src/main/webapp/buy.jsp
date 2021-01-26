<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/25/2021
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>buy</title>
</head>
<body>
    <table align="center" border="2" style="width:30%">
        <tr>
            <th>Name :</th>
            <td><input type="text" placeholder="Enter passenger name" name="passengerName" required></td>
        </tr>
        <tr>
            <th>Gender :</th>
            <td align="center">
                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label>
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <form action="" method="post">
                <input type="submit" name="save" value="submit">
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
