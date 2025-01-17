package com.example.library.service;

import com.example.library.entity.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    public Book createBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    public Book findBookById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> getAllBooks() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public Book updateBook(Book book) {
        return entityManager.merge(book);
    }

    public void deleteBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }
}