package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.AuthorDTO;
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

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
            .map(AuthorDTO::new)
            .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
            .map(AuthorDTO::new)
            .orElse(null);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));
        
        author.setFirstName(authorDetails.getFirstName());
        author.setLastName(authorDetails.getLastName());
        author.setBirthDate(authorDetails.getBirthDate());
        author.setNationality(authorDetails.getNationality());
        
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.delete(author);
    }
}