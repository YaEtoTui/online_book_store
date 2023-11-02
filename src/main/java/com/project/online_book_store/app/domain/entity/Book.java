package com.project.online_book_store.app.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @ManyToOne()
    @JoinColumn(name = "author_id")
    Author author;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    Genre genre;
    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    BuyBook buyBook;
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    List<BookInCart> bookInCart = new LinkedList<>();
}
