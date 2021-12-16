<%--
  Created by IntelliJ IDEA.
  User: vonhatanh
  Date: 16/12/2021
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Spiced with Sandwick</h2>
<c:forEach items='${requestScope["condiment"]}' var="choice">
    <h2 style="color: #652121">${choice}</h2>
</c:forEach>
</body>
</html>
