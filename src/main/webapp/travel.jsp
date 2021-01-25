<%@ page import="entities.Travel" %><%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/25/2021
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <td colspan="2"><lable>Direction : ${list[0]}</lable></td>
            <td><lable>Departure date :<br><c:out value="${requestScope.list[0].departureDate}" /></lable></td>
        </tr>

        <tr>
            <th>Departure time</th>
            <th>Travel id</th>
            <th>Select</th>
        </tr>
        <c:forEach var="travel" items="${list}">
            <tr>
                <td align="center"><c:out value="${travel.departureTime}" /></td>
                <td align="center"><c:out value="${travel.travelId}" /></td>
               <form action="">
                <td align="center" ><input type="submit" id="${travel.travelId}" value="buy"></td>
               </form>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
