<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/23/2015
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form action="adduser" method="post">
  Username: <input type="text" name="name">
  <br/>
  Password: <input type="text" name="password">
  <br/>
  Blocked: <input type="checkbox" name="blocked" value="true"/>
  <br/>
  User roles:
    <c:forEach var="roles" items="${roles}">
      ${roles.name()}<input type="checkbox" name="${roles.name()}" value="true"/></br>
    </c:forEach>
  <br/>
  <input type="hidden" name="id" value="${customer.id}">
  <input type="submit" value="Submit"/>
  <INPUT type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<a href="<c:url value="/jsp/users"/>">Back users list</a>
</body>
</html>
