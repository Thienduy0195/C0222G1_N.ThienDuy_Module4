<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/14/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TRANSFERRING MONEY</title>
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
<form action="/transfer" method="post">
    <table>
        <tr>
            <th>ENTER USD:</th>
            <th><input type="number" name="usd" value="${usd}"></th>
        </tr>
        <tr>
            <th>RESULT: </th>
            <td>
                <p style="color: #ffffff">${usdToVnd}</p>
            </td>
        </tr>
    </table>
    <div>
            <input type="submit" value="EXCHANGE">
    </div>
</form>
</body>
</html>

