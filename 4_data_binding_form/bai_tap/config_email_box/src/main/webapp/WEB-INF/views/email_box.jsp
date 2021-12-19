<%--
  Created by IntelliJ IDEA.
  User: vonhatanh
  Date: 19/12/2021
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<form:form action="config" method="post" modelAttribute="emailBox">
    <h1>Settings</h1>
    <div>
        <span>
            Languages :
        </span>
        <span>
              <form:select path="language">
                  <form:options items="${language}"/>;
              </form:select>
        </span>
    </div>
    <div>
        <span>
            Page Size :
        </span>
        <span>
                <form:select path="pageSize">
                    <form:options items="${pageSize}"/>;
                </form:select>
        </span>
    </div>

    <div>
        <span>
           Spams filter :
        </span>
        <span>
               <form:radiobutton path="spamFilter" value="on"/> Enable spams filter
        </span>
    </div>
    <div>
        <span>
         Signature :
        </span>
        <span>
                <form:textarea path="signature"/>
        </span>
    </div>
    <div>
        <form:button>Update</form:button>
    </div>
</form:form>
</body>
</html>