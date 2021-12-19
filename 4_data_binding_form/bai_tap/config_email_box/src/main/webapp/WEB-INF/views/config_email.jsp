<%--
  Created by IntelliJ IDEA.
  User: vonhatanh
  Date: 19/12/2021
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
<h1>Config Email</h1>

<table>
    <tr>
        <td>
            Languages :
        </td>
        <td>
            ${language}
        </td>
    </tr>
    <tr>
        <td>
            Page Size:
        </td>
        <td>
            ${pageSize}
        </td>
    </tr>
    <tr>
        <td>
            Spam Filter :
        </td>
        <td>
            ${spamFilter}
        </td>
    </tr>
    <tr>
        <td>
            Signature :
        </td>
        <td>
            ${signature}
        </td>
    </tr>

</table>
</body>
</html>
