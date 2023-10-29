package com.project.online_book_store.app.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book extends BaseDomainEntity{
    public String name;
    Integer page;
    String description;
    String language;
    Integer yearIssue;
    Integer price;
    public Integer count;
    @ManyToOne()
    @JoinColumn(name = "author_id")
    Author author;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    Genre genre;
    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    BuyBook buyBook;
}
