<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 1/23/2021
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div style="text-align: center">
    <h1>User Management</h1>
    <h2>
        <a href="/customers/create" >Add New Users</a>
    </h2>
</div>
<c:set var="id" value="${0}"/>
<div align="center">
<table border="1" >
    <caption><h2>List of Users</h2></caption>
    <c:if test="${message!=null}">
        <p style="color: red">${message}</p>
    </c:if>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>
                <c:out value="${id=id+1}"/>
            </td>
            <td>
                <a href="/show/${customer.getId()}">${customer.name}</a>
            </td>
            <td>
                <c:out value="${customer.email}"/>
            </td>
            <td>
                <c:out value="${customer.address}"/>
            </td>
            <td>
                <a href="/customers/${customer.id}/edit">Edit</a>
                <a href="/customers/${customer.id}/delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
