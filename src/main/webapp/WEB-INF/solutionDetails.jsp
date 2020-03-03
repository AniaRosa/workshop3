<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 03.03.2020
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Solution Details</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
    <table>
        <tr><th>${title}</th></tr>
        <tr>
            <th>Szczegóły rozwiązania</th>
            <th>Data dodania</th>
        </tr>
        <tr>
            <td>${solution.getDescription()}</td>
            <td>${solution.getCreated()}</td>
        </tr>
    </table>
<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
