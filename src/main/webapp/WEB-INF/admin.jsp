<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 05.03.2020
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp"%>
<h1>Admin</h1>
<a href="${exercises}">Lista zadań</a><br>
<a href="${groups}">Lista grup użytkowników</a><br>
<a href="${users}">Lista użytkowników</a>

<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
