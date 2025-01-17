<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create Author</title>
</head>
<body>
<h1>Create Author</h1>
<form action="${pageContext.request.contextPath}/authors" method="post">
  <label for="firstName">First Name:</label>
  <input type="text" id="firstName" name="firstName" required />
  <br />
  <label for="lastName">Last Name:</label>
  <input type="text" id="lastName" name="lastName" required />
  <br />
  <button type="submit">Create</button>
</form>
</body>
</html>