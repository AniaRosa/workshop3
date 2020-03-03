<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 18.01.2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
    <table>
        <tr>
            <th>Nazwa</th>
            <th>Autor</th>
            <th>Data dodania</th>
            <th>Akcje</th>
        </tr>
        <c:forEach items="${exercisesToView}" var="exercise">
            <tr>
                <td>${exercise.getExerciseTile()}</td>
                <td>${exercise.getExerciseAuthor()}</td>
                <td>${exercise.getExerciseCreationDate()}</td>
                <td><a href="/details?id=${exercise.getExerciseSolutionId()}&title=${exercise.getExerciseTile()}">Details</a> </td>
            </tr>
        </c:forEach>
    </table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
