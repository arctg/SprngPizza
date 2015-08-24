<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/10/2015
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add/Edit pizza</title>
</head>
<body>
<form action="create" method="post">
    Name of pizza: <input type="text" name="name" value="${pizza.name}">
    <br/>
    Pizzas price: <input type="text" name="pricel" value="${pizza.price/100}" pattern="\d+(\.\d{1,2})?"/>
    <br/>
    Pizzas type:
    <select name="pizzaType" id="input" >
        <c:forEach var="item" items="${pizzaTypes}">
            <option value="${item}" ${item == pizza.pizzaType ? 'selected="selected"' : ''}>${item}</option>
        </c:forEach>
    </select><br/>
    <input type="hidden" name="id" value="${pizza.id}">
    <input type="submit" value="Submit"/>
    <INPUT type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<a href="<c:url value="/jsp/pizzas"/>">Back to pizzas list</a>
</body>
</html>
