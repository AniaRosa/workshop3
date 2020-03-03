<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.03.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html><html>
<head>
    <title>Users</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
<table>
    <tr>
        <th>Numer id</th>
        <th>Imię i nazwisko</th>
        <th>Szczegóły</th>
    </tr>
    <tr>
        <c:forEach items="${users}" var="user">
            <td>${user.getId()}</td>
            <td>${user.getUserName()}</td>
            <td><a href="/userDetails?id=${user.getId()}">Details</a> </td>
        </c:forEach>
    </tr>
</table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
