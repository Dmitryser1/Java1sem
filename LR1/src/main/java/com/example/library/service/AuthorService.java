package com.example.library.service;

import com.example.library.entity.Author;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AuthorService {

    @PersistenceContext
    private EntityManager entityManager;

    public Author createAuthor(Author author) {
        entityManager.persist(author);
        return author;
    }

    public Author findAuthorById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> getAllAuthors() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    public Author updateAuthor(Author author) {
        return entityManager.merge(author);
    }

    public void deleteAuthor(Long id) {
        Author author = entityManager.find(Author.class, id);
        if (author != null) {
            entityManager.remove(author);
        }
    }
}