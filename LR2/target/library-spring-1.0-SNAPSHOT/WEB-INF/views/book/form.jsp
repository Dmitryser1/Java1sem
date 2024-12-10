<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"], select {
            width: 300px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }
        .error {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
    <h1>${book.id == null ? 'Add New Book' : 'Edit Book'}</h1>
    
    <form:form method="post" modelAttribute="book" action="${book.id == null ? '/library/books' : '/library/books/'.concat(book.id)}">
        <form:hidden path="id"/>
        
        <div class="form-group">
            <label for="title">Title:</label>
            <form:input path="title" required="true"/>
            <form:errors path="title" cssClass="error"/>
        </div>
        
        <div class="form-group">
            <label for="author">Author:</label>
            <form:select path="author.id" required="true">
                <form:option value="" label="Select Author"/>
                <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
            </form:select>
            <form:errors path="author" cssClass="error"/>
        </div>
        
        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <form:input path="isbn"/>
            <form:errors path="isbn" cssClass="error"/>
        </div>
        
        <div class="form-group">
            <label for="publicationYear">Publication Year:</label>
            <form:input path="publicationYear" type="number"/>
            <form:errors path="publicationYear" cssClass="error"/>
        </div>
        
        <div class="form-group">
            <label for="availableCopies">Available Copies:</label>
            <form:input path="availableCopies" type="number" required="true"/>
            <form:errors path="availableCopies" cssClass="error"/>
        </div>
        
        <button type="submit" class="button">Save</button>
        <a href="<c:url value='/books'/>" class="button">Cancel</a>
    </form:form>
</body>
</html>
