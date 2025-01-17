package com.example.library.service;

import com.example.library.audit.service.AuditService;
import com.example.library.mappers.BookMapper;
import com.example.library.model.Book;
import com.example.library.model.BookDTO;
import com.example.library.notification.service.NotificationService;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuditService auditService;

    @Autowired
    private NotificationService notificationService;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDTO)
                .orElse(null);
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        auditService.logEvent("Book", savedBook.getId(), ChangeType.CREATE, "admin");
        notificationService.sendNotification("Book created: " + savedBook.getTitle(), "admin@library.com");
        return bookMapper.toDTO(savedBook);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        Book updatedBook = bookRepository.save(book);
        auditService.logEvent("Book", updatedBook.getId(), ChangeType.UPDATE, "admin");
        notificationService.sendNotification("Book updated: " + updatedBook.getTitle(), "admin@library.com");
        return bookMapper.toDTO(updatedBook);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
        auditService.logEvent("Book", id, ChangeType.DELETE, "admin");
        notificationService.sendNotification("Book deleted: " + book.getTitle(), "admin@library.com");
    }
}