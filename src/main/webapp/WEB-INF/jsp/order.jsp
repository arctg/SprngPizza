<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title></title>
</head>
<body>
<form action="order" method="post">
    Your name: <input type="text" name="name" value="${sessionScope.customer.name}">
    <br/>
    Pizza:
    <select name="pizzaType" id="input">
        <c:forEach var="item" items="${pizzas}">
            <option value="${item.id}" ${item == pizza.pizzaType ? 'selected="selected"' : ''}>${item.name} ${item.pizzaType} ${item.price}</option>
        </c:forEach>
    </select>
    <br/>
    Pizzas count: <input type="number" name="price" value=""/>
    <br/>
    <input type="hidden" name="id" value="${pizza.id}">
    <input type="submit" value="Add to order"/>
</form>
<a href="<c:url value="/jsp/pizzas"/>">Back to pizzas list</a>
</body>
</html>
