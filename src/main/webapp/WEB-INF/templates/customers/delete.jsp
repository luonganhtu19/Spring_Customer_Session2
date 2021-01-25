<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 1/25/2021
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div align="center" class="header">
    <h1>User Management</h1>
    <h2>
        <a href="/customers">List All Customer</a>
    </h2>
    <c:if test="${message!=null}">
        <p style="color: red">${message}</p>
    </c:if>
</div>
<div align="center" class="body">
    <form method="post" action="/customers/${customer.id}/delete">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Delete User</h2>
            </caption>
            <tr>
                <th>User Name</th>
                <td>
                    <input type="text" name="name" size="45" value="${customer.name}" disabled>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" size="45" value="${customer.email}" disabled>
                </td>
            </tr>
            <tr>
                <th>User Address</th>
                <td>
                    <input type="text" name="address" size="45" value="${customer.address}" disabled>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Delete"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
