<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 05.03.2020
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <title>Uzytkownicy</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
<table>
    <tr>
        <th>Numer id użytkownika</th>
        <th>Nazwisko użytkownika</th>
        <th>Adres email użytkownika</th>
        <th>Numer grupy</th>
        <th>Edycja
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUserName()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getUserGroupId()}</td>
            <td><a href="/userEdit?id=${user.getId()}">Edit</a> </td>
        </tr>
    </c:forEach>
    <tr><a href="/addUser">Dodaj nowego uzytkownika</a> </tr>
</table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>