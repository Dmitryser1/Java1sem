package com.example.library.ejb;

import com.example.library.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class BookService {
    private EntityManagerFactory emf;
    private EntityManager em;

    public BookService() {
        emf = Persistence.createEntityManagerFactory("LibraryPU");
        em = emf.createEntityManager();
    }

    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public void addBook(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public void updateBook(Book book) {
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
    }

    public void deleteBook(Long id) {
        em.getTransaction().begin();
        Book book = findById(id);
        if (book != null) {
            em.remove(book);
        }
        em.getTransaction().commit();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
