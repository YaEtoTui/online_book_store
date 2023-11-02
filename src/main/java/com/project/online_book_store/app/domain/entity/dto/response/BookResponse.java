package com.project.online_book_store.app.domain.entity.dto.response;

import lombok.Value;

@Value
public class BookResponse {

    Long id;
    String name;
    Integer page;
    Integer price;
    Integer count;
    AuthorInfo author;

    @Value
    public static class AuthorInfo {
        String nameAuthor;
    }
}
