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
    <title>Edit user</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<form action=${actionServlet} method="post">
    Imie i nazwisko użytkownika:    <input name="name" placeholder="${user.getUserName()}"> <br>
    Adres email:                    <input name="email" placeholder="${user.getEmail()}"><br>
    Numer grupy:                    <input name="group" placeholder="${user.getUserGroupId()}"><br>
    Hasło:                          <input name="password" placeholder="${user.getPassword()}" type="password"><br>
    <button>Prześlij</button>
</form>

<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
