<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/09/2023
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create</h1>
<form action="students?action=create" method="post">
<input type="text" name="name">
<input type="text" name="email">
<input type="date" name="dob">
<input type="text" name="phoneNumber">
<select name="idClassroom">
    <c:forEach items="${classroom}" var="classroom">
  <option value="${classroom.getIdClassroom()}">${classroom.getClassroom()}</option>
    </c:forEach>
</select>
<input type="text" name="address">
<button>Create</button>
</form>
</body>
</html>
