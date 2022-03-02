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
    <title>Table</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Admin page</h1><br><br><br><br>
<% User user1 =(User) request.getSession().getAttribute("user"); %>
<%List<User> all = (List<User>) request.getAttribute("all");%>
<% if (all != null && all.size() != 0) {%>
<table class="border">
    <tr>
        <th>Name</th>
        <th>Lastname</th>
    </tr>

<% for (User user : all){%>

    <tr>
        <td ><%=user.getName()%></td>
        <td ><%=user.getLastName()%></td>
        <td><a href="/delete?id=<%=user.getId()%>">delete</a></td>
    </tr>

<%}%>
</table>
<%} else {%>
<p>user list is empty or not found</p>
<%}%>


<a href="login.jsp">Log out </a><br><br>
<a href="/update?id=<%=user1.getId()%>">update</a>

</body>
</html>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Table</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

</body>
</html>
