<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 06.03.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Exercises List</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
<table>
    <tr>
        <th>Numer id zadania</th>
        <th>Nazwa zadania</th>
        <th>Opis</th>
        <th>Edycja
    </tr>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.getId()}</td>
            <td>${exercise.getTitle()}</td>
            <td>${exercise.getDescription()}</td>
            <td><a href="/exerciseEdit?id=${exercise.getId()}">Edit</a> </td>
        </tr>
    </c:forEach>
    <tr><a href="/addExercise">Dodaj nowe zadanie</a> </tr>
</table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
