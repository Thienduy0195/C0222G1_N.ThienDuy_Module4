<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/16/2022
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FORM TO SUBMIT EMAIL</title>
    <link rel="stylesheet" href="/resources/bootstrap/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h3>EMAIL REGISTER</h3>
<form:form action="home/email" method="post" modelAttribute="email">

    <table>
        <tr>
            <th><form:label path="language">Languages:</form:label></th>
            <td>
                <form:select path="language">
                    <form:options items="${language}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page Size:</form:label></th>
            <td>Show
                <form:select path="pageSize">
                    <form:options items="${size}"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th><form:label path="filter">Spams filter:</form:label></th>
            <td><form:checkbox path="filter"/></td>
        </tr>
        <tr>
            <th><form:label path="signature">Signature:</form:label></th>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button class="btn btn-success" type="submit">Update</button>
                <button class="btn btn-danger">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
