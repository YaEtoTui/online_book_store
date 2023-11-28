package com.project.online_book_store.app.common.exception;

/* Возникает ошибка, если в БД не найдена книга*/

public class NotFoundBookException extends RuntimeException {

    public NotFoundBookException(String msg) {
        super(msg);
    }
}
