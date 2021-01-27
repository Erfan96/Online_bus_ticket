<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/24/2021
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search</title>
</head>
<body>

<form action="travel" method="get">

    <label> Origin
        <select name="origin">
            <option value="0">Select your origin...</option>
            <c:forEach items="${list}" var="city">
                <option value="${city.id}">${city.name}</option>
            </c:forEach>
        </select>
    </label>

    <label> Destination
        <select name="destination">
            <option value="0">Select your destination...</option>
            <c:forEach items="${list}" var="city">
                <option value="${city.id}">${city.name}</option>
            </c:forEach>
        </select>
    </label>

    <label> Date
        <input name="date" type="text" placeholder="2021/**/**">
    </label>

    <input type="submit" value="search">

</form>

<form action="ticket">
    <input type="submit" name="show" value="show">
</form>

</body>
</html>
