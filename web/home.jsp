<%@ page import="model.Items" %>
<%@ page import="java.util.List" %>
<%@ page import="db.DBConnection" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container p-0">
    <div class="col-sm-12 mt-3 text-center">
        <h2>Welcome to BITLAB SHOP</h2>
    </div>
</div>
<div class="container p-0">
    <div class="col-sm-12 mt-3 text-center">
        <h6>Electronic devices with high quality and service</h6>
    </div>
</div>
<div class="container-md p-0 ">
    <div class="row justify-content-center">
        <%
            List<Items> items = DBConnection.getItems();
            for(Items item: items) { %>
        <div class="col-sm-4 mt-3">
            <div class="card">
                <h5 class="card-header text-center"><%=item.getName()%></h5>
                <div class="card-body text-center">
                    <h5 class="card-title" style="color: green"><%=item.getPrice()%></h5>
                    <p class="card-text"><%=item.getDescription()%></p>
                    <a href="#" class="btn btn-success">Buy Now</a>
                </div>
            </div>
        </div>
        <% }%>
    </div>
</div>
</body>
</html>