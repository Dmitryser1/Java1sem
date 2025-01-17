<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Authors</title>
</head>
<body>
<h1>Authors</h1>
<table border="1">
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
  </tr>
  <c:forEach items="${authors}" var="author">
    <tr>
      <td>${author.id}</td>
      <td>${author.firstName}</td>
      <td>${author.lastName}</td>
    </tr>
  </c:forEach>
</table>
<br />
<a href="create-author.jsp">Add Author</a>
</body>
</html>