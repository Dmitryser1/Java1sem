<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Create Book</title>
  <style>
    form {
      width: 300px;
      margin: 0 auto;
    }
    label {
      display: block;
      margin-top: 10px;
    }
    input, select {
      width: 100%;
      padding: 8px;
      margin-top: 5px;
    }
    button {
      margin-top: 20px;
      padding: 10px 20px;
    }
  </style>
</head>
<body>
<h1>Create New Book</h1>
<form action="${pageContext.request.contextPath}/books" method="post">
  <label for="title">Title:</label>
  <input type="text" id="title" name="title" required />

  <label for="isbn">ISBN:</label>
  <input type="text" id="isbn" name="isbn" required />

  <label for="publicationYear">Publication Year:</label>
  <input type="number" id="publicationYear" name="publicationYear" required />

  <label for="availableCopies">Available Copies:</label>
  <input type="number" id="availableCopies" name="availableCopies" required />

  <label for="authorId">Author:</label>
  <select id="authorId" name="authorId" required>
    <c:forEach items="${authors}" var="author">
      <option value="${author.id}">${author.firstName} ${author.lastName}</option>
    </c:forEach>
  </select>

  <button type="submit">Create</button>
</form>
</body>
</html>