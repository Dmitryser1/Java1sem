<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authors List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
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
        .delete {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <h1>Authors</h1>
    <a href="<c:url value='/authors/new'/>" class="button">Add New Author</a>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Nationality</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>${author.nationality}</td>
                <td>
                    <a href="<c:url value='/authors/${author.id}/edit'/>" class="button">Edit</a>
                    <a href="<c:url value='/authors/${author.id}/delete'/>" class="button delete" 
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="<c:url value='/books'/>" class="button">View Books</a></p>
</body>
</html>
