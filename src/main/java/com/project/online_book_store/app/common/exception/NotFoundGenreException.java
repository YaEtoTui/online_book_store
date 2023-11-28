package com.project.online_book_store.app.common.exception;

/* Возникает ошибка, если в БД не найден жанр*/

public class NotFoundGenreException extends RuntimeException {

    public NotFoundGenreException(String msg) {
        super(msg);
    }
}
