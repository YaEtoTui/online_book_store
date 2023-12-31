package com.project.online_book_store.app.domain.entity;


import com.project.online_book_store.app.domain.entity.context.BookContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/* Сущность Книга используется для передачи информации из репозитория на сервис и наоборот */

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

    public Book(BookContext bookContext) {
        name = bookContext.getName();
        page = bookContext.getPage();
        description = bookContext.getDescription();
        language = bookContext.getLanguage();
        yearIssue = bookContext.getYearIssue();
        price = bookContext.getPrice();
        count = bookContext.getCount();
        pathImage = null;
        author = bookContext.getAuthor();
        genre = bookContext.getGenre();
        bookInCart = new LinkedList<>();
    }
}
