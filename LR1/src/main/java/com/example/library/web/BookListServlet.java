package com.example.library.web;

import com.example.library.ejb.BookService;
import com.example.library.entity.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/books")
public class BookListServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Book> books = bookService.getAllBooks();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Library Books</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
            out.println("table { border-collapse: collapse; width: 100%; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            out.println("th { background-color: #4CAF50; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("h1 { color: #4CAF50; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Library Books</h1>");
            out.println("<table>");
            out.println("<tr><th>Title</th><th>Author</th><th>ISBN</th><th>Available Copies</th></tr>");
            
            for (Book book : books) {
                out.println("<tr>");
                out.println("<td>" + book.getTitle() + "</td>");
                out.println("<td>" + book.getAuthor().getFirstName() + " " + 
                           book.getAuthor().getLastName() + "</td>");
                out.println("<td>" + book.getIsbn() + "</td>");
                out.println("<td>" + book.getAvailableCopies() + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void destroy() {
        if (bookService != null) {
            bookService.close();
        }
    }
}
