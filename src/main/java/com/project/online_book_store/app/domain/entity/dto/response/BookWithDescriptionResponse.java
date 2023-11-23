package com.project.online_book_store.app.domain.entity.dto.response;

import lombok.Value;

@Value
public class BookWithDescriptionResponse {

    Long id;
    String name;
    String description;
    Integer page;
    Integer price;
    Integer count;
    String path;
    BookResponse.AuthorInfo author;

    @Value
    public static class AuthorInfo {
        String nameAuthor;
    }
}
