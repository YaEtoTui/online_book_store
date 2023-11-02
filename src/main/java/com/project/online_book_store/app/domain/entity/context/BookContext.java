package com.project.online_book_store.app.domain.entity.context;

import com.project.online_book_store.app.domain.entity.Author;
import com.project.online_book_store.app.domain.entity.Genre;
import lombok.Value;

@Value
public class BookContext {
    String name;
    Integer page;
    String description;
    String language;
    Integer yearIssue;
    Integer price;
    Integer count;
    Author author;
    Genre genre;
}
