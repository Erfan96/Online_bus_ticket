<%--
  Created by IntelliJ IDEA.
  User: efsam
  Date: 1/27/2021
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail ticket</title>
    <link rel="stylesheet" type="text/css" href="detailTicket.css" />
</head>
<body>

  <table id="table">
  <c:forEach var="ticket" items="${list}">
      <tr>
       <th colspan="4">
         Bus ticket
       </th>
     </tr>
      <tr>
          <th>Ticket id:</th>
          <td><c:out value="${ticket.get(0)}" /></td>
      </tr>
      <tr>
          <th>Name:</th>
          <td><c:out value="${ticket.get(1)}" /></td>
      </tr>
      <tr>
          <th>Gender:</th>
          <td><c:out value="${ticket.get(2)}" /></td>
      </tr>
      <tr>
          <th>Origin:</th>
          <td><c:out value="${ticket.get(3)}" /></td>
      </tr>
      <tr>
          <th>Destination:</th>
          <td><c:out value="${ticket.get(4)}" /></td>
      </tr>
      <tr>
          <th>Departure date:</th>
          <td><c:out value="${ticket.get(5)}" /></td>
      </tr>
      <tr>
          <th>Departure time:</th>
          <td><c:out value="${ticket.get(6)}" /></td>
      </tr>
      <tr>
          <th>Travel id:</th>
          <td><c:out value="${ticket.get(7)}" /></td>
      </tr>
      <tr>
          <th colspan="4"><a href="cancel?value=${ticket.get(0)}">Cancel ticket</a></th>
      </tr>
  </c:forEach>
  </table>

</body>
</html>
