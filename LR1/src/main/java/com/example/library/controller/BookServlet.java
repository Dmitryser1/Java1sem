package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    @EJB
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/book-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String isbn = req.getParameter("isbn");
        int publicationYear = Integer.parseInt(req.getParameter("publicationYear"));
        int availableCopies = Integer.parseInt(req.getParameter("availableCopies"));
        long authorId = Long.parseLong(req.getParameter("authorId"));

        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPublicationYear(publicationYear);
        book.setAvailableCopies(availableCopies);

        Author author = new Author();
        author.setId(authorId);
        book.setAuthor(author);

        bookService.createBook(book);
        resp.sendRedirect(req.getContextPath() + "/books");
    }
}