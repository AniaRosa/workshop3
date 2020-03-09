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
<br>
${error}
<br>
<form action=${actionServlet} method="post">
    Imie i nazwisko użytkownika:    <input name="name" placeholder="${user.getUserName()}" value="${name}"> <br>
    Adres email:                    <input name="email" placeholder="${user.getEmail()}" value="${email}"><br>
    Numer grupy:                    <select name="group" placeholder="${user.getUserGroupId()}">
                                        <option value="${user.getUserGroupId()}" selected>${user.getUserGroupId()}</option>
                                    <c:forEach items="${groups}" var="group">
                                        <option value="${group.getId()}">${group.getId()}</option>
                                    </c:forEach>
                                    </select><br>
    Hasło:                          <input name="password" type="password"><br>
    <button>Prześlij</button>
</form>

<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
