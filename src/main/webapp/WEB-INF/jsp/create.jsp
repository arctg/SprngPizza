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
    <title>Add new pizza</title>
</head>
<body>
<form action="create" method="post">
  Name of pizza: <input type="text" name="name" value="${pizza.name}">
  <br/>
  Pizzas price <input type="number" name="price" value="${pizza.price}"/>
  <br/>
  Pizzas type <input type="text" name="pizzaType" value="${pizza.pizzaType}"/>
    <input type="hidden" name="id" value="${pizza.id}">
  <input type="submit" value="Submit" />
</form>
</body>
</html>
