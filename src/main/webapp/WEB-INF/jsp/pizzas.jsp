<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<table border="1" style="border-style: solid;">
    <td><c:out value="id"/></td>
    <td><c:out value="name"/></td>
    <td><c:out value="price"/></td>
    <td><c:out value="type"/></td>
    <c:forEach var="pizza" items="${pizzas}">
        <tr>
            <td><c:out value="${pizza.id}"/></td>
            <td><c:out value="${pizza.name}"/></td>
            <td><c:out value="${pizza.price}"/></td>
            <td><c:out value="${pizza.pizzaType}"/></td>
            <td>
                <FORM action="edit" method="POST">
                    <INPUT TYPE="hidden" name="id" value="${pizza.id}">
                    <INPUT TYPE="submit" value="edit">
                </FORM>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/jsp/create"/>">Add new pizza</a>
</body>
</html>