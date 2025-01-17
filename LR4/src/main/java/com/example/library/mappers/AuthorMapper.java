package com.example.library.mappers;

import com.example.library.model.Author;
import com.example.library.model.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorDTO toDTO(Author author) {
        if (author == null) {
            return null;
        }
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setBirthDate(author.getBirthDate());
        dto.setNationality(author.getNationality());
        return dto;
    }

    public Author toEntity(AuthorDTO dto) {
        if (dto == null) {
            return null;
        }
        Author author = new Author();
        author.setId(dto.getId());
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setBirthDate(dto.getBirthDate());
        author.setNationality(dto.getNationality());
        return author;
    }
}