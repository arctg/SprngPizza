<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/24/2015
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All orders</title>
</head>
<body>
<table border="1" style="border-style: solid;">
  <td><c:out value="id"/></td>
  <td><c:out value="Order Date"/></td>
  <td><c:out value="Pizza"/></td>
  <td><c:out value="Count"/></td>
  <td><c:out value="Address"/></td>
  <td><c:out value="Summ"/></td>
  <td><c:out value="Completed"/></td>
  <td><c:out value="WhoIs"/></td>
  <c:forEach var="order" items="${orders}">
    <tr>
      <td><c:out value="${order.pizzaOrderId}"/></td>
      <td><c:out value="${order.orderDateTime.getTime()}"/></td>
      <td>
        <c:forEach var="pizza" items="${order.pizzas}">
          <c:out value="${pizza.key.name}"/></br>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="pizza" items="${order.pizzas}">
          <c:out value="${pizza.value}"/></br>
        </c:forEach>
      </td>
      <td>
        <c:out value="${order.address}"/>
      </td>
      <td>
        <c:out value="${order.summ/100}"/>
      </td>
      <td>
        <c:out value="${order.isCompleted()}"/>
      </td>
      <td>
        <c:out value="${order.customerId}"/>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
