<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.03.2020
  Time: 14:46
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
        <th>Szczegóły</th>
    </tr>
    <tr>
        <c:forEach items="${groups}" var="group">
            <td>${group.getId()}</td>
            <td>${group.getName()}</td>
            <td><a href="/groupDetails?id=${group.getId()}">Details</a> </td>
        </c:forEach>
    </tr>
</table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
