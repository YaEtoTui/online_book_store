package com.project.online_book_store.app.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book extends BaseDomainEntity{
    String name;
    Integer page;
    String description;
    String language;
    Integer yearIssue;
    Integer price;
    Integer count;
    String pathImage;
    @ManyToOne()
    @JoinColumn(name = "author_id")
    Author author;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    Genre genre;
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    List<BookInCart> bookInCart = new LinkedList<>();

    public Book(Book book, Path path) {
        id = book.getId();
        name = book.getName();
        page = book.getPage();
        description = book.getDescription();
        language = book.getLanguage();
        yearIssue = book.getYearIssue();
        price = book.getPrice();
        count = book.getCount();
        pathImage = path.toString();
        author = book.getAuthor();
        genre = book.getGenre();
        bookInCart = book.getBookInCart();
    }
}
