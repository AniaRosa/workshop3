<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 05.03.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html><html>
<head>
    <title>User Details</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
<table>
    <tr>
        <th>Numer id</th>
        <th>Imię i nazwisko</th>
        <th>Adres email</th>
        <th>Numer grupy</th>
    </tr>
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getUserName()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getUserGroupId()}</td>
    </tr>
</table>
<br>
<table>
    <tr>
        <th>Rozwiązania użytkownika</th>
    </tr>
    <tr>
        <th>Zadanie</th>
        <th>Data utworzenia rozwiązania</th>
        <th>Data poprawienia rozwiązania</th>
        <th>Treść rozwiązania</th>
    </tr>
    <c:forEach items="${solutionsToView}" var="solution">
        <tr>
            <td>${solution.getExerciseTitle()}</td>
            <td>${solution.getCreated()}</td>
            <td>${solution.getUpdated()}</td>
            <td>${solution.getDescription()}</td>
        </tr>
    </c:forEach>
</table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>

