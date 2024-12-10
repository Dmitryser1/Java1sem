package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public void saveBook(Book book) {
        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
            author.ifPresent(book::setAuthor);
        }
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
            author.ifPresent(book::setAuthor);
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
