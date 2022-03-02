<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.02.2022
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>User page</h1><br><br><br><br>

<%User user = (User) request.getSession().getAttribute("user");%>
<% if (user != null) {%>
<p>user name is: <%=user.getName()%>
</p>
<p>user lastname is:<%=user.getLastName()%>
</p>
<p>user age is:<%=user.getAge()%>
</p>
<p>user email is:<%=user.getEmail()%>
</p>
<%} else {%>
<p>user is not found</p>
<%}%>


<a href="login.jsp">Log out </a><br><br>
<a href="/delete?id=<%=user.getId()%>">delete</a><br>
<form action="/formUpdate" method="post">
    <input type="hidden" value="<%=user.getId()%>" name="id">
    <input type="submit" value="update">
</form>
<%--<a href="/formUpdate?id=">update</a>--%>

</body>
</html>
