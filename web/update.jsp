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
<%String msg = (String) request.getSession().getAttribute("msg");
request.getSession().removeAttribute("msg");%>
<% if (msg != null && !msg.equals("")){%>
<span style="color: red"><%=msg%></span>
<%}%>
<% User user = (User) request.getAttribute("user"); %>
<form action="/update" method="post">
  <input type="text" placeholder="<%=user.getName()%>" name="name" ><br>
  <input type="text" placeholder="<%=user.getLastName()%>"  name="lastname"><br>
  <input type="text" placeholder="<%=user.getAge()%>" name="age" ><br>
  <input type="text" placeholder="<%=user.getEmail()%>" name="email" ><br>
  <input type="text" placeholder="<%=user.getPassword()%>" name="password"><br>
  <input type="hidden" value="<%=user.getId()%>" name="id">
  <input type="submit" value="update">
</form>
<%--<% User user = (User) request.getAttribute("user"); %>--%>
<%--<a href="/update?id=<%=user.getId()%>">update</a>--%>

</body>
</html>
