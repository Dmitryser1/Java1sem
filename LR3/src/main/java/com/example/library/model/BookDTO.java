package com.example.library.model;

import java.io.Serializable;
import java.util.Objects;

public class BookDTO implements Serializable {
    private Long id;
    private String title;
    private String isbn;
    private Integer publicationYear;
    private Integer availableCopies;
    private Long authorId;
    private String authorFullName;

    // Конструкторы
    public BookDTO() {}

    public BookDTO(Book book) {
        if (book != null) {
            this.id = book.getId();
            this.title = book.getTitle();
            this.isbn = book.getIsbn();
            this.publicationYear = book.getPublicationYear();
            this.availableCopies = book.getAvailableCopies();
            
            // Проверка на null для автора
            if (book.getAuthor() != null) {
                this.authorId = book.getAuthor().getId();
                this.authorFullName = String.format("%s %s", 
                    book.getAuthor().getFirstName(), 
                    book.getAuthor().getLastName());
            }
        }
    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    // Методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) &&
               Objects.equals(title, bookDTO.title) &&
               Objects.equals(isbn, bookDTO.isbn) &&
               Objects.equals(publicationYear, bookDTO.publicationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, publicationYear);
    }

    // Метод toString для удобства логирования и отладки
    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", availableCopies=" + availableCopies +
                ", authorId=" + authorId +
                ", authorFullName='" + authorFullName + '\'' +
                '}';
    }

    // Метод для создания BookDTO из Book с возможностью расширения
    public static BookDTO fromEntity(Book book) {
        return new BookDTO(book);
    }

    // Дополнительный метод для маппинга с более сложной логикой
    public Book toEntity() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setIsbn(this.isbn);
        book.setPublicationYear(this.publicationYear);
        book.setAvailableCopies(this.availableCopies);
        return book;
    }
}