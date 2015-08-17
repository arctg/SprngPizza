<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/12/2015
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose the pizza</title>
</head>
<br>
<form action="order" method="post">
    Pizza:
    <select name="id" id="input">
        <c:forEach var="item" items="${pizzas}">
            <option value="${item.id}" ${item == pizza.pizzaType ? 'selected="selected"' : ''}>${item.name} ${item.pizzaType} ${item.price}</option>
        </c:forEach>
    </select>
    <br/>
    Pizzas count: <input required type="number" name="count" min="1" max="10" value=""/>
    <br/>
    <input type="hidden" name="id" value="${pizza.id}">
    <input type="submit" value="Add to order"/>
    <sec:csrfInput/>
</form>
Your order:</br>
<table border="1" style="border-style: solid;">
    <td><c:out value="id"/></td>
    <td><c:out value="name"/></td>
    <td><c:out value="price"/></td>
    <td><c:out value="type"/></td>
    <td><c:out value="count"/></td>
    <c:forEach items="${pizzasToOrder}" var="entry">
        <tr>
            <td><c:out value="${entry.key.id}"/></td>
            <td><c:out value="${entry.key.name}"/></td>
            <td><c:out value="${entry.key.price}"/></td>
            <td><c:out value="${entry.key.pizzaType}"/></td>
            <td><c:out value="${entry.value}"/></td>
        </tr>
    </c:forEach>
</table>
Summ: <c:out value="${summ}"/> </br>
<c:out value="${msg}"/>
<form action="submit" method="post">
    <input type="submit" value="OK"/>
    <sec:csrfInput/>
</form>
<a href="<c:url value="/jsp/pizzas"/>">Back to pizzas list</a>
</body>
</html>
