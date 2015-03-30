<%@ page import="javierseixas.schibsted.domain.model.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 1</title>
</head>
<body>

<h1>Page 1</h1>
<%
    User user = (User) session.getAttribute("user");
%>
<h2>Hello <%= user.username() %>!</h2>
<%@ include file="../logout.jsp" %>
</body>
</html>
