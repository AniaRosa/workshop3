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
    <title>Grupy</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
<table>
    <tr>
        <th>Numer grupy</th>
        <th>Nazwa grupy</th>
        <th>Edycja</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.getId()}</td>
            <td>${group.getName()}</td>
            <td><a href="/groupEdit?id=${group.getId()}">Edit</a> </td>
        </tr>
    </c:forEach>
    <tr><a href="/addGroup">Dodaj nową grupę</a> </tr>
</table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>