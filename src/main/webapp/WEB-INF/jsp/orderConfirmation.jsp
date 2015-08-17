<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/14/2015
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm order</title>
</head>
<body>
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

<form action="confirm" method="post">
  City:<input type="text" name="city" min="1" max="32" value=""/>
  <br/>
  Street: <input type="text" name="street" min="1" max="32" value=""/>
  <br/>
  Building: <input type="text" name="building" min="1" max="32" value=""/>
  <br/>
  Apartment: <input type="text" name="apartment"  max="4" value=""/>
  <br/>
  Porch: <input type="text" name="porch"  max="2" value=""/>
  <br/>
  <input type="submit" value="i'm hangry!"/>
  <sec:csrfInput/>
</form>

</body>
</html>
