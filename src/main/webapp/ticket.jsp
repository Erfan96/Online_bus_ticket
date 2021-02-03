<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/26/2021
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of tickets</title>
    <link rel="stylesheet" type="text/css" href="ticket.css" />
</head>
<body>
<table id="table">
    <tr>
        <th align="center" colspan="3">
            List of purchased tickets
        </th>
    </tr>
    <tr>
        <th align="center">Select</th>
        <th align="center">Ticket id</th>
        <th align="center">Date</th>
    </tr>
    <c:forEach var="ticket" items="${list}">
        <tr>
            <td align="center"><a href="showTicket?value=${ticket.get(0)}">Show ticket</a></td>
            <td align="center"><c:out value="${ticket.get(0)}" /></td>
            <td align="center"><c:out value="${ticket.get(1)}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
