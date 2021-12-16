<%--
  Created by IntelliJ IDEA.
  User: vonhatanh
  Date: 15/12/2021
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form method="post" action="/caculator">
    <div>Number 1 </div>
    <input type="text" name="num1" value="${num1}">
    <div>Number 2 </div>
    <input type="text" name="num2" value="${num2}">
    <hr>
    <p>
        <input type="submit" name="calculator" value="Addition(+)">
        <input type="submit" name="calculator" value="Subtraction(-)">
        <input type="submit" name="calculator" value="Multiplication(X)">
        <input type="submit" name="calculator" value="Division(/)">
    </p>
</form>
<h2 style="color : #c00e0e">Result : ${result}</h2>
</body>
</html>
