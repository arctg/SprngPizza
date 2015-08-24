<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/7/2015
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <title>Pizzas List</title>
</head>

User: <c:out value="${prin.getUsername()}"/></br>
<%--<c:out value="${auth}"/>--%>
Roles:
<c:forEach var="au" items="${auth}">
    <c:out value="${au}"/>
</c:forEach>
<table border="1" style="border-style: solid;">
    <td><c:out value="id"/></td>
    <td><c:out value="name"/></td>
    <td><c:out value="price"/></td>
    <td><c:out value="type"/></td>
    <c:forEach var="pizza" items="${pizzas}">
        <tr>
            <td><c:out value="${pizza.id}"/></td>
            <td><c:out value="${pizza.name}"/></td>
            <td><c:out value="${pizza.price/100}"/></td>
            <td><c:out value="${pizza.pizzaType}"/></td>
            <td>
                <FORM action="edit" method="POST">
                    <INPUT type="hidden" name="id" value="${pizza.id}">
                    <INPUT type="submit" value="edit">
                    <sec:csrfInput/>
                </FORM>
            </td>
            <td>
                <FORM action="delete" method="POST">
                    <INPUT type="hidden" name="id" value="${pizza.id}">
                    <INPUT type="submit" value="delete">
                    <sec:csrfInput/>
                </FORM>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/jsp/create"/>">Add new pizza</a>

<c:url var="logoutUrl" value="/logout"/>
<FORM action="${logoutUrl}" method="post">
    <INPUT type="submit" value="logout">
    <INPUT type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</FORM>

</body>
</html>