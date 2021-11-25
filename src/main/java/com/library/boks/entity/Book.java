package com.library.boks.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 25, message = "Длина названия книги должна быть от 2 до 25")
    private String title;
    @NotNull
    @Size(min = 2, max = 25, message = "Длина имени автора должна быть от 5 до 25")
    private String author;

    @NotNull
    @Size(min = 2, max = 15, message = "Длина жанра должна быть от 2 до 15")
    private String Genre;

    private Integer year;

    @NotNull
    @Size(min = 4, max = 25, message = "Длина издательства должна быть от 2 до 25")
    private String publishHouse;

    private String description;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setTitle(String nameOfBook) {
        this.title = nameOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
