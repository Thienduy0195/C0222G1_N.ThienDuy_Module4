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
        form {
            background-color: orangered;
            width: 30%;
            margin: 5em auto;
        }

        th {
            text-align: left;
            color: #ffffff;
            font-size: 2em;
        }

        td {
            font-size: 2em;
        }

        .head {
            font-size: 1.5em;
            color: white;
            background-color: brown;
            padding: 2px 0;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="/translate" method="post">
    <div class="head">
        <p>OXFORD DICTIONARY</p>
    </div>
    <table>
        <tr>
            <th>English:</th>
            <th><input type="text" name="english"></th>
        </tr>
        <tr>
            <th>Vietnamese:</th>
            <td>
                <p style="color: #ffffff"></p>
            </td>
        </tr>
    </table>
    <div>
        <input type="submit" value="TRANSLATE">
    </div>
  <div>
    <p style="color: white; background-color: brown">@Oxford Learner's Dictionaries</p>
  </div>
</form>
</body>
</html>
