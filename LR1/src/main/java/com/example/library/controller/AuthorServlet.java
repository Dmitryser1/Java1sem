package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.service.AuthorService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {

    @EJB
    private AuthorService authorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorService.getAllAuthors();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/author-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorService.createAuthor(author);
        resp.sendRedirect(req.getContextPath() + "/authors");
    }
}