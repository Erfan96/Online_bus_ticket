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
    <link rel="stylesheet" type="text/css" href="buy.css" />
</head>
<body>
  <form action="success" method="post">
    <table id="type">
        <tr>
            <th>Name :</th>
            <td><input id="txt" type="text" placeholder="Enter passenger name" name="passengerName" required></td>
        </tr>
        <tr>
            <th>Gender :</th>
            <td align="center">
                <input type="radio" id="male" name="gender" value="MALE" required>
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="FEMALE">
                <label for="female">Female</label>
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">

                <input id="sub" type="submit" name="save" value="submit">

            </td>
        </tr>
    </table>
  </form>
</body>
</html>
