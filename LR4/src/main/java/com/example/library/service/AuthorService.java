package com.example.library.service;

import com.example.library.audit.service.AuditService;
import com.example.library.mappers.AuthorMapper;
import com.example.library.model.Author;
import com.example.library.model.AuthorDTO;
import com.example.library.notification.service.EmailService;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private AuditService auditService;

    @Autowired
    private EmailService emailService;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toDTO)
                .orElse(null);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        Author savedAuthor = authorRepository.save(author);

        // Логирование события
        auditService.logEvent("Author", savedAuthor.getId(), "CREATE", "admin");

        // Отправка email
        emailService.sendEmail(
                "dmitryserafimovich@gmail.com",
                "New Author Created",
                "Author " + savedAuthor.getFullName() + " has been created."
        );

        return authorMapper.toDTO(savedAuthor);
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setBirthDate(authorDTO.getBirthDate());
        author.setNationality(authorDTO.getNationality());

        Author updatedAuthor = authorRepository.save(author);

        // Логирование события
        auditService.logEvent("Author", updatedAuthor.getId(), "UPDATE", "admin");

        // Отправка email
        emailService.sendEmail(
                "dmitryserafimovich@gmail.com",
                "Author Updated",
                "Author " + updatedAuthor.getFullName() + " has been updated."
        );

        return authorMapper.toDTO(updatedAuthor);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.delete(author);

        // Логирование события
        auditService.logEvent("Author", id, "DELETE", "admin");

        // Отправка email
        emailService.sendEmail(
                "dmitryserafimovich@gmail.com",
                "Author Deleted",
                "Author " + author.getFullName() + " has been deleted."
        );
    }
}