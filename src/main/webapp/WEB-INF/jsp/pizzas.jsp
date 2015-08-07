<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 8/7/2015
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizzas List</title>
</head>
<body>

<c:forEach var="pizza" items="${pizzas}">
  <c:out value="${pizza}"/><br/>
</c:forEach>

</body>
</html>
