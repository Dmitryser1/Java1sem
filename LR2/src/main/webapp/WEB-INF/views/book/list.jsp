<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books List</title>
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
    <h1>Books</h1>
    <a href="<c:url value='/books/new'/>" class="button">Add New Book</a>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Publication Year</th>
            <th>Available Copies</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author.firstName} ${book.author.lastName}</td>
                <td>${book.isbn}</td>
                <td>${book.publicationYear}</td>
                <td>${book.availableCopies}</td>
                <td>
                    <a href="<c:url value='/books/${book.id}/edit'/>" class="button">Edit</a>
                    <a href="<c:url value='/books/${book.id}/delete'/>" class="button delete" 
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="<c:url value='/authors'/>" class="button">View Authors</a></p>
</body>
</html>
