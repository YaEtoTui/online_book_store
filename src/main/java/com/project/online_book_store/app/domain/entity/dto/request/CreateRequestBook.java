package com.project.online_book_store.app.domain.entity.dto.request;

import lombok.Value;

/* Запрос на создание книги (для админки) */

@Value
public class CreateRequestBook {
    String name;
    Integer page;
    String description;
    String language;
    Integer yearIssue;
    Integer price;
    Integer count;
    Long authorId;
    Long genreId;
}
