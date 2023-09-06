<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/09/2023
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Student</h1>
<button><a href="students?action=create">Create</a></button>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Classroom</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${student}" var="student">
        <tr>
            <td>${student.idStudent}</td>
            <td>${student.name}</td>
            <td>${student.dob}</td>
            <td>${student.email}</td>
            <td>${student.address}</td>
            <td>${student.phoneNumber}</td>
            <td>${student.getClassroom().getClassroom()}</td>
            <td><button><a href="students?action=update&&idStudent=${student.idStudent}">Update</a></button></td>
            <td><button><a href="students?action=delete&&idStudent=${student.idStudent}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
<button><a href="students?action=displayClassroom">Class</a></button>
</body>
</html>
