<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/19/2024
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/students?action=create">Add New Student</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Student</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <c:forEach var="student" items="${listUser}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.email}"/></td>
                <td><c:out value="${student.address}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
