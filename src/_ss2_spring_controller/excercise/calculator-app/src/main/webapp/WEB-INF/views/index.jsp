<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/15/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>TD'S CALCULATOR</title>
  <style>
    form{
      background: orangered;
      color: white;
      font-weight: bold;
      width: 500px;
      margin: 0 auto;
    }
  </style>
</head>
<body>
<form action="calculate" method="post">
  <fieldset>
    <legend>Calculator</legend>
    <table>
      <tr>
        <td>First operand:</td>
        <td><input type="text" name="firstOperand"></td>
      </tr>
      <tr>
        <td>Operator:</td>
        <td>
          <select name="operator">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand:</td>
        <td><input type="text" name="secondOperand"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"/></td>
      </tr>
    </table>
  </fieldset>
  <h2 style="color: white">${result}</h2>
</form>
</body>
</html>
