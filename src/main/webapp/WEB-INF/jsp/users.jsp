<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/23/2015
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<table border="1" style="border-style: solid;">
    <td><c:out value="id"/></td>
    <td><c:out value="name"/></td>
    <td><c:out value="password"/></td>
    <td><c:out value="blocked"/></td>
    <td><c:out value="roles"/></td>
    <c:forEach var="users" items="${users}">
        <tr>
            <td><c:out value="${users.id}"/></td>
            <td><c:out value="${users.name}"/></td>
            <td><c:out value="${users.password}"/></td>
            <td><c:out value="${users.isBlocked()}"/></td>
            <td><c:forEach var="roles" items="${users.roles}">
                <c:out value="${roles.name()}"/>
            </c:forEach></td>
            <td>
                <FORM action="edit" method="POST">
                    <INPUT type="hidden" name="id" value="${users.id}">
                    <INPUT type="submit" value="edit">
                    <sec:csrfInput/>
                </FORM>
            </td>
            <td>
                <FORM action="delete" method="POST">
                    <INPUT type="hidden" name="id" value="${users.id}">
                    <INPUT type="submit" value="delete">
                    <sec:csrfInput/>
                </FORM>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/jsp/adduser"/>">Add new user</a>

<c:url var="logoutUrl" value="/logout"/>
<FORM action="${logoutUrl}" method="post">
    <INPUT type="submit" value="logout">
    <INPUT type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</FORM>
</body>
</html>
