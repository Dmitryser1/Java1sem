<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Book List</title>
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
    }
    table, th, td {
      border: 1px solid black;
    }
    th, td {
      padding: 8px;
      text-align: left;
    }
  </style>
</head>
<body>
<h1>Book List</h1>
<table>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>ISBN</th>
    <th>Publication Year</th>
    <th>Author</th>
    <th>Available Copies</th>
  </tr>
  <c:forEach items="${books}" var="book">
    <tr>
      <td>${book.id}</td>
      <td>${book.title}</td>
      <td>${book.isbn}</td>
      <td>${book.publicationYear}</td>
      <td>${book.author.firstName} ${book.author.lastName}</td>
      <td>${book.availableCopies}</td>
    </tr>
  </c:forEach>
</table>
<br />
<a href="create-book.jsp">Add New Book</a>
</body>
</html>