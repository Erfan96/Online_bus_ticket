<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/26/2021
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p></p>
<c:out value="${requestScope.type}"></c:out>
<c:out value="${requestScope.passenger}"></c:out>
<c:out value="${requestScope.id}"></c:out>
</body>
</html>
