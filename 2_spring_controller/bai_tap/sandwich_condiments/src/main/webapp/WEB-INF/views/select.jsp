<%--
  Created by IntelliJ IDEA.
  User: vonhatanh
  Date: 16/12/2021
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="save" method="post">
    <div>
        <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
        <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
        <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
        <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
    </div>
    <hr>
    <p><input type="submit" value="Save"></p>
</form>
</body>
</html>
