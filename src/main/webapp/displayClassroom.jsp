<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/09/2023
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Classroom</h1>
<button><a href="students?action=createClassroom">Create</a></button>
<table>
    <tr>
        <td>Id</td>
        <td>Classroom</td>
        <td>update</td>
    </tr>
    <c:forEach items="${classroom}" var="classroom">
        <tr>
            <td>${classroom.idClassroom}</td>
            <td>${classroom.classroom}</td>
            <td><button><a href="students?action=updateClassroom&&idClassroom=${classroom.idClassroom}">Update</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
