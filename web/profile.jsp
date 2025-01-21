<%@ page import="model.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container text-center">
    <%
        Users user = (Users) request.getAttribute("user");
        if (user == null) { %>
    <h1 class ="mt-2 mb-2" style="color: red;">Пройдите аутентификацию</h1>
    <% } else { %>
    <h1 class ="mt-2 mb-2">Hello <%= user.getFullName() %></h1>
    <h5 class ="mt-2 mb-2">This is your profile page</h5>
    <% } %>
</div>
</body>
</html>