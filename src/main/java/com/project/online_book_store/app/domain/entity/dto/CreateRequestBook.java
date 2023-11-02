package com.project.online_book_store.app.domain.entity.dto;

import lombok.Value;

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
