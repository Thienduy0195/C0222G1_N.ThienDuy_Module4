<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/15/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CONDIMENT</title>
</head>
<body>
<h2 style="color: orangered">THE CONDIMENT YOU'VE CHOOSE</h2>
<ol>
    <c:forEach items="${condiment}" var="item">
        <li><h3 style="color: green ">${item}</h3></li>
    </c:forEach>
</ol>
</body>
</html>