package com.project.online_book_store.app.domain.entity.dto.response;

import lombok.Value;

/* Ответ, который мы возвращаем, при создании Книги */

@Value
public class BookResponse {

    Long id;
    String name;
    Integer page;
    Integer price;
    Integer count;
    String path;
    AuthorInfo author;

    @Value
    public static class AuthorInfo {
        String nameAuthor;
    }
}
