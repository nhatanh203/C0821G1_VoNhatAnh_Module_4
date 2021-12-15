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
<form method="post" action="/currency">
    <h2><strong>Rate : </strong></h2>
    <input type="text" name="rate" placeholder="Rate" value="23000"><br>
    <h2><strong>USD : </strong></h2>
    <input type="text" name="usd" placeholder="Usd" value="0"><br>
    <input type="submit" id="submit" value="Convert">
</form>
</body>
</html>
