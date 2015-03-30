<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div style="color:#ff0000;">
  <%
  if (request.getAttribute("loginError") != null) {
  %>
  <%= request.getAttribute("loginError") %>
  <% } %>
</div>
<form action="/login" method="post">
  <fieldset>
    <div>Username: <input type="text" name="username" /></div>
    <div>Password: <input type="password" name="password" /></div>
    <div><input type="submit" value="Login"></div>
  </fieldset>
</form>
</body>
</html>
