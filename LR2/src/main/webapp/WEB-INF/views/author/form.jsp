<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Author Form</title>
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
        input[type="text"], input[type="date"] {
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
    <h1>${author.id == null ? 'Add New Author' : 'Edit Author'}</h1>
    
    <form:form method="post" modelAttribute="author" action="${author.id == null ? '/library/authors' : '/library/authors/'.concat(author.id)}">
        <form:hidden path="id"/>
        
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <form:input path="firstName" required="true"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <form:input path="lastName" required="true"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        
        <div class="form-group">
            <label for="birthDate">Birth Date:</label>
            <form:input path="birthDate" type="date"/>
            <form:errors path="birthDate" cssClass="error"/>
        </div>
        
        <div class="form-group">
            <label for="nationality">Nationality:</label>
            <form:input path="nationality"/>
            <form:errors path="nationality" cssClass="error"/>
        </div>
        
        <button type="submit" class="button">Save</button>
        <a href="<c:url value='/authors'/>" class="button">Cancel</a>
    </form:form>
</body>
</html>
