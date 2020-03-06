<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 05.03.2020
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit exercise</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<form action=${actionServlet} method="post">
    Nazwa zadania:    <input name="title" placeholder="${exercise.getTitle()}"> <br>
    Opis:                    <input name="description" placeholder="${exercise.getDescription()}"><br>
    <button>Prześlij</button>
</form>

<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
