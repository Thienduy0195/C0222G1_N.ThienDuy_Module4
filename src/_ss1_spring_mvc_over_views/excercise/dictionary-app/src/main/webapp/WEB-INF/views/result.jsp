<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/14/2022
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>DICTIONARY</title>
  <style>
    form{
      background-color: orangered;
      width: fit-content;
      margin: 0 auto;
    }
    th{
      text-align: left;
      color: #ffffff;
    }
  </style>
</head>
<body>
<form action="/translate" method="post">
  <table>
    <tr>
      <th>English:</th>
      <th><input type="text" name="english" value="${english}"></th>
    </tr>
    <tr>
      <th>Vietnamese: </th>
      <td>
        <p style="color: #ffffff">${vietnamese}</p>
      </td>
    </tr>
  </table>
  <div>
    <input type="submit" value="TRANSLATE">
  </div>
</form>
</body>
</html>
